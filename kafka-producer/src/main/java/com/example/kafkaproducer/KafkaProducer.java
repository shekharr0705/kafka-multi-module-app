package com.example.kafkaproducer;

import com.example.kafka.common.model.User;
import java.time.LocalDate;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

  @Autowired
  private KafkaTemplate<String, User> kafkaTemplate;

  public void ProduceMessages() {

    System.out.println("Started Producing Messages");
    int count = 1;

    try {

      while (true) {
        User user = User.builder().FirstName("Joe-" + count).LastName("Jack").DateOfBirth(
            LocalDate.parse("1990-12-05")).build();

        System.out.println("Producing Data for :" + user.toString());

        ProducerRecord<String, User> producerRecord = new ProducerRecord<>("user-tracking",
            "User",
            user);
        count++;
        Thread.sleep(1000L);
        kafkaTemplate.send(producerRecord);
      }

    } catch (Exception ex) {
      System.out.println("Exception Occurred : " + ex.getMessage());
    }

  }
}
