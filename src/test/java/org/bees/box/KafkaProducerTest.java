package org.bees.box;


import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class KafkaProducerTest extends BeeBoxApplicationTest {
    private static Logger logger = LoggerFactory.getLogger(KafkaProducerTest.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Test
    public void sendMessage() {
        String topic = "mytopic";
        for (int i = 1; i <= 10; i++) {
            String value = "value_" + i;
            ProducerRecord msg = new ProducerRecord(topic, value);
            Object o = null;
            try {
                o = kafkaTemplate.send(msg).get();
                logger.info(JSONObject.toJSONString(o));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            logger.info(JSONObject.toJSONString(o));
        }

        logger.info("finished");
    }

    @Test
    public void listen() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "CountryCounter");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String,
                String>(props);
        consumer.subscribe(Collections.singletonList("customerCountries"));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    logger.debug("topic = %s, partition = %s, offset = %d, customer = %s, country = % s\n ",
                            record.topic(), record.partition(), record.offset(),
                            record.key(), record.value());
                    int updatedCount = 1;
                    logger.info("%s", JSONObject.toJSONString(record));
                }
            }
        } finally {
            consumer.close();
        }
    }

}
