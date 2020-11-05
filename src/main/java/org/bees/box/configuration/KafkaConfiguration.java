package org.bees.box.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {
    /**
     * kafaka集群列表
     */
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * kafaka消费group列表
     */
    @Value("${spring.kafka.consumer.group-id}")
    private String defaultGroupId;

    /**
     * 消费开始位置
     */
    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;

    /**
     * 是否自动提交
     */
    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private String enableAutoCommit;

    /**
     * #如果'enable.auto.commit'为true，则消费者偏移自动提交给Kafka的频率（以毫秒为单位），默认值为5000。
     */
    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private String autoCommitInterval;

    /**
     * 一次调用poll()操作时返回的最大记录数，默认值为500
     */
    @Value("${spring.kafka.consumer.max-poll-records}")
    private String maxPollRecords;

    /**
     * 自定义的topic1
     */
    @Value("${spring.kafka.producer.myTopic1}")
    private String myTopic1;

    /**
     * 自定义的topic2
     */
    @Value("${spring.kafka.producer.myTopic2}")
    private String myTopic2;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getDefaultGroupId() {
        return defaultGroupId;
    }

    public void setDefaultGroupId(String defaultGroupId) {
        this.defaultGroupId = defaultGroupId;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public String getEnableAutoCommit() {
        return enableAutoCommit;
    }

    public void setEnableAutoCommit(String enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    public String getAutoCommitInterval() {
        return autoCommitInterval;
    }

    public void setAutoCommitInterval(String autoCommitInterval) {
        this.autoCommitInterval = autoCommitInterval;
    }

    public String getMaxPollRecords() {
        return maxPollRecords;
    }

    public void setMaxPollRecords(String maxPollRecords) {
        this.maxPollRecords = maxPollRecords;
    }

    public String getMyTopic1() {
        return myTopic1;
    }

    public void setMyTopic1(String myTopic1) {
        this.myTopic1 = myTopic1;
    }

    public String getMyTopic2() {
        return myTopic2;
    }

    public void setMyTopic2(String myTopic2) {
        this.myTopic2 = myTopic2;
    }
}
