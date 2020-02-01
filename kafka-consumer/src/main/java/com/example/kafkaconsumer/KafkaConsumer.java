package com.example.kafkaconsumer;

import com.example.kafka.common.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

  @KafkaListener(topics = "user-tracking")
  public void KafkaListner(User user) {

    System.out.println("Received Message"+ user.toString());

  }
}
