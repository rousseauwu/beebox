package org.bees.box;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class KafkaProducerTest {
    private static Logger logger = LoggerFactory.getLogger(KafkaTest.class);

    @Autowired
    private KafkaTemplate<String,String> template;

    @Test
    public void sendMessage(){
        for (int i = 0; i < 10; i++) {
            template.send("mytopic",String.valueOf(i));
        }
        logger.info("finished");
    }
}
