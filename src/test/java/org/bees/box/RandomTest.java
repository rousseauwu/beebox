package org.bees.box;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class RandomTest {
    //是ParameterizedType
    private HashMap<String, Object> map;
    private HashSet<String> set;
    private List<String> list;
    private Class<?> clz;

    //不是ParameterizedType
    private Integer i;
    private String str;


    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING = -1 << COUNT_BITS;
        int SHUTDOWN = 0 << COUNT_BITS;
        int STOP = 1 << COUNT_BITS;
        int TIDYING = 2 << COUNT_BITS;
        int TERMINATED = 3 << COUNT_BITS;
        int CAPACITY = (1 << COUNT_BITS) - 1;
        System.out.println(COUNT_BITS);
        System.out.println(CAPACITY);
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);

        System.out.println(RUNNING | 0);

        System.out.println(~0);
    }

    interface Hello {
        void moring(String name);

        void hi(String name);
    }

}
