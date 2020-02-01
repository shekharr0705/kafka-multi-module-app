package com.example.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication  implements ApplicationRunner{

  @Autowired
  private KafkaProducer producer;

  public static void main(String[] args){
    SpringApplication.run(KafkaProducerApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    this.producer.ProduceMessages();
  }
}
