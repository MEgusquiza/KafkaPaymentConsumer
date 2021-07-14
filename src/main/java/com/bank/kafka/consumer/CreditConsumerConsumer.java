package com.bank.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bank.kafka.Topic;
import com.bank.model.CreditPayment;
//import com.bank.model.CreditConsumer;
import com.bank.service.CreditConsumerService;
import com.bank.utils.ConsumerYankiUtils;

@Component
public class CreditConsumerConsumer {
	
    private final Logger logger = LoggerFactory.getLogger(Topic.class);
    
	@Autowired
	CreditConsumerService creditConsumerService;
	
	@KafkaListener( groupId = ConsumerYankiUtils.CONSUMER_GROUP,topics = ConsumerYankiUtils.CONSUMER_TOPIC, containerFactory =ConsumerYankiUtils.CONTAINER_FACTORY)
	public CreditPayment recoverCreatedCreditPayment(CreditPayment creditPayment) throws Exception {
	    // creditConsumerService.update(creditPayment);
	   logger.info("Recived transaction payment: {} ", creditPayment.toString() );
	  return creditPayment;
      }
	
}
