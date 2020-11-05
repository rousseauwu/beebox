package org.bees.box.service;

public interface KafkaService {
    public void send(String topic, String value);
}
