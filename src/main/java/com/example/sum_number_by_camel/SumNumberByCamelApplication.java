package com.example.sum_number_by_camel;

import com.example.sum_number_by_camel.consumer.CamelConsumer;
import com.example.sum_number_by_camel.producer.CamelProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Random;

@SpringBootApplication
@EnableScheduling
public class SumNumberByCamelApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SumNumberByCamelApplication.class, args);

        CamelProducer producer = context.getBean(CamelProducer.class);
        CamelConsumer consumer = context.getBean(CamelConsumer.class);

        producer.sendMessage();
        consumer.consume();
        consumer.sum();
    }

}
