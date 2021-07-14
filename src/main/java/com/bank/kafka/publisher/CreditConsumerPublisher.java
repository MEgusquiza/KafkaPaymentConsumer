package com.bank.kafka.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.bank.model.CreditPayment;

//import com.bank.model.CreditConsumer;


@Component
public class CreditConsumerPublisher {
	
	@Autowired
	private KafkaTemplate<String, CreditPayment> kafkaTemplate;

	private String topic = "topic-credit-consumer";

	public void sendCreditConsumerTransactionTopic(CreditPayment creditConsumer) {
		
		kafkaTemplate.send(topic, creditConsumer);
		
	}
	
}
