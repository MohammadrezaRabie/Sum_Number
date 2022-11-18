package com.example.sum_number_by_camel.consumer;

import org.apache.camel.Consume;
import org.apache.camel.ConsumerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@EnableAsync
public class CamelConsumer {

    Logger logger = Logger.getLogger(CamelConsumer.class.getName());

    @Autowired
    ConsumerTemplate consumerTemplate;

    private static List<Integer> list = new ArrayList<>();

    @Consume
    @Async
    @Scheduled(fixedDelay = 60000 , initialDelay = 60000)
    public void consume() throws InterruptedException {

        while (true){

            Object body = consumerTemplate.receiveBody("kafka:sum?brokers=localhost:9092");

            int number = Integer.parseInt((String) body);
//            System.out.println(number);
            list.add(number);

        }
    }

    @Consume
    @Async
    @Scheduled(fixedDelay = 60000 , initialDelay = 60000)
    public void sum(){

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        logger.info("Sum is : " + sum);
    }
}
