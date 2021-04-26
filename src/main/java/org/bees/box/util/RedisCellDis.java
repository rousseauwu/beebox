package org.bees.box.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RedisCellDis {
    /**
     * jedis命令客户端
     */
    protected JedisCommands jedis;

    /**
     * 自定义限流key
     */
    protected String key;

    /**
     * 时间窗口 单位秒
     */
    protected int period;

    /**
     * 最大令牌容量
     */
    protected int maxCapacity;

    public RedisCellDis(JedisCommands jedis, String key, int period, int maxCapacity) {
        this.jedis = jedis;
        this.key = key;
        this.period = period;
        this.maxCapacity = maxCapacity;
    }

    /**
     * 尝试申请资源
     *
     * @param quote 目标资源数
     * @return 是否申请成功
     */
    public boolean tryAcquire(int quote) throws IOException {
        List<String> keys = new ArrayList<>();
        keys.add(key);
        List<String> argvs = new ArrayList<>();
        argvs.add(String.valueOf(maxCapacity));
        argvs.add(String.valueOf(maxCapacity));
        argvs.add(String.valueOf(period));
        argvs.add(String.valueOf(quote));
        Object result = null;
        if (jedis instanceof Jedis) {
            result = ((Jedis) this.jedis).eval(LUA_SCRIPT, keys, argvs);
        } else if (jedis instanceof JedisCluster) {
            result = ((JedisCluster) this.jedis).eval(LUA_SCRIPT, keys, argvs);
        } else {
            throw new RuntimeException("redis instance is error");
        }
        return ((List<Long>) result).get(0) == 0;
    }

    public static final String LUA_SCRIPT = "local key = KEYS[1]\n" +
            "local init_burst = tonumber(ARGV[1])\n" +
            "local max_burst = tonumber(ARGV[2])\n" +
            "local period = tonumber(ARGV[3])\n" +
            "local quota = ARGV[4]\n" +
            "return redis.call('CL.THROTTLE',key,init_burst,max_burst,period,quota)";
}
