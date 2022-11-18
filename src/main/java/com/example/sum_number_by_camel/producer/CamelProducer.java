package com.example.sum_number_by_camel.producer;



import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class CamelProducer {

    @Autowired
    @Produce
    ProducerTemplate template;

    @Async
    @Scheduled(fixedDelay = 10000 , initialDelay = 10000)
    public void sendMessage() {

        java.util.Random random = new java.util.Random();


        int i = random.nextInt(100);
        template.sendBody("kafka:sum?brokers=localhost:9092" , String.valueOf(i));



    }

}
