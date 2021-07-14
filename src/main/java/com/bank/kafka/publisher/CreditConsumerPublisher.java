package com.bank.kafka.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.bank.model.CreditPayment;
import com.bank.utils.ConsumerYankiUtils;


@Component
public class CreditConsumerPublisher {
	
	@Autowired
	private KafkaTemplate<String, CreditPayment> kafkaTemplate;

	public void sendCreditConsumerTransactionTopic(CreditPayment creditConsumer) {
		
	kafkaTemplate.send(ConsumerYankiUtils.RESPONSE_CONSUMER_TOPIC, creditConsumer);
		
	}
	
}
