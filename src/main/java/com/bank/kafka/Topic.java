package com.bank.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.bank.model.CreditPayment;
import com.bank.utils.ConsumerYankiUtils;


@Configuration
@EnableKafka
public class Topic {
  
    private final Logger logger = LoggerFactory.getLogger(Topic.class);
    
    @Bean
	public NewTopic creditPaymentTransactionTopic() {
      logger.info("Create topic, credit-consumer-topic");
		return TopicBuilder
				.name(ConsumerYankiUtils.RESPONSE_CONSUMER_TOPIC)
				.partitions(1)
				.replicas(1)
				.build();
	}
	
	@Bean
	public ConsumerFactory<String, CreditPayment> paymentConsumerFactory() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ConsumerYankiUtils.SERVER_CONFIG );
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG,ConsumerYankiUtils.CONSUMER_GROUP); 
		return new DefaultKafkaConsumerFactory<>(configs,new StringDeserializer(),new JsonDeserializer<>(CreditPayment.class,false));
	}
	
	 @Bean
	 public ConcurrentKafkaListenerContainerFactory<String,CreditPayment> paymentKafkaListenerContainerFactory(){
	 ConcurrentKafkaListenerContainerFactory<String,CreditPayment> factory = new ConcurrentKafkaListenerContainerFactory<String,CreditPayment>();
	 factory.setConsumerFactory(paymentConsumerFactory());
	 return factory;
	 } 
	 
}
