package com.bank.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.bank.model.CreditConsumer;
import com.bank.service.CreditConsumerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.Disposable;

@Component
public class CreditConsumerConsumer {
	
	//@Autowired
	//private PurchaseService purchaseService;
		
	@Autowired
	CreditConsumerService creditConsumerService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@KafkaListener( groupId = "credit-payment-consumer-yanki",topics = "credit-payment-topic", containerFactory ="paymentKafkaListenerContainerFactory")
	public Disposable recoverCreatedCreditPayment(String value) throws Exception {
		
	CreditConsumer creditConsumer = objectMapper.readValue(value, CreditConsumer.class);
		
    return (Disposable)creditConsumerService.update(creditConsumer);
      }
	
}
