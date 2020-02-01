package com.example.kafkaproducer;

import com.example.kafka.common.model.User;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class ProducerConfiguration {
  @Bean
  public ProducerFactory<String, User> producerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093,localhost:9094");
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);
    return new DefaultKafkaProducerFactory<>(configProps,new StringSerializer(),new org.springframework.kafka.support.serializer.JsonSerializer<User>());
  }
  @Bean
  public KafkaTemplate<String, User> kafkaTemplate() {
    return new KafkaTemplate<String,User>(producerFactory());
  }
}
