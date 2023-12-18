package com.example.amppoc.config;



import org.apache.kafka.clients.consumer.ConsumerConfig;
        import org.apache.kafka.clients.producer.ProducerConfig;
        import org.apache.kafka.common.serialization.StringDeserializer;
        import org.apache.kafka.common.serialization.StringSerializer;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
        import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;

        import java.util.HashMap;
        import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // SSL Configuration
/*        config.put("security.protocol", "SSL");
        config.put("ssl.truststore.location", "/path/to/your/truststore.jks");
        config.put("ssl.truststore.password", "truststore-password");
        config.put("ssl.keystore.location", "/path/to/your/keystore.jks");
        config.put("ssl.keystore.password", "keystore-password");
        config.put("ssl.key.password", "key-password");*/

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);

        // SSL Configuration
        /*config.put("security.protocol", "SSL");
        config.put("ssl.truststore.location", "/path/to/your/truststore.jks");
        config.put("ssl.truststore.password", "truststore-password");*/

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new StringDeserializer());
    }

    @Bean
    public ContainerProperties containerProperties() {
        return new ContainerProperties("my-topic");
    }
}

