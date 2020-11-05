package org.bees.box.controller;

import org.bees.box.configuration.KafkaConfiguration;
import org.bees.box.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private KafkaConfiguration kafkaConfiguration;

    @RequestMapping("/send/{msg}")
    public void send(@PathVariable String msg) {
        kafkaService.send(kafkaConfiguration.getMyTopic1().toString(), msg);
    }

}
