package org.bees.box.service.impl;

import org.bees.box.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaServiceImpl implements KafkaService {

    private static Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, String> template;

    @Override
    public void send(String topic, String value) {
        ListenableFuture<SendResult<String, String>> listenableFuture = template.send(topic, value);
        listenableFuture.addCallback(successCallBack -> logger.info("send success"), failureCallBack -> logger.info("send failed"));
    }
}
