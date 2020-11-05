package org.bees.box;


import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*/*.xml")
public class KafkaProducerTest {
    private static Logger logger = LoggerFactory.getLogger(KafkaTest.class);

    @Autowired
    private Producer kafkaProducer;

    @Test
    public void sendMessage(){
        String topic = "mytopic";
        for (int i = 1; i <= 10; i++) {
            String value = "value_" + i;
            ProducerRecord<String, String> msg = new ProducerRecord<String, String>(topic, value);
            kafkaProducer.send(msg);
        }

        logger.info("finished");
    }
}
