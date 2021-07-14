package com.bank.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bank.model.CreditPayment;
//import com.bank.model.CreditConsumer;
import com.bank.service.CreditConsumerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.Disposable;

@Component
public class CreditConsumerConsumer {
	
	//@Autowired
	//private PurchaseService purchaseService;
		
	@Autowired
	CreditConsumerService creditConsumerService;
	
	@KafkaListener( groupId = "credit-payment-consumer-yanki",topics = "credit-payment-topic", containerFactory ="paymentKafkaListenerContainerFactory")
	public CreditPayment recoverCreatedCreditPayment(CreditPayment data) throws Exception {
    return creditConsumerService.update(data);
      }
	
}
