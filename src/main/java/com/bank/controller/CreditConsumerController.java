package com.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.CreditConsumer;
import com.bank.service.CreditConsumerService;


@RestController
@RequestMapping("/credit")
@EnableCaching
public class CreditConsumerController {
     
  private final Logger logger = LoggerFactory.getLogger(CreditConsumerController.class);
  
     @Autowired
     private CreditConsumerService service;
     
	 CreditConsumer paymentFromTopic = null; 
	 
  	    @GetMapping("/cosumer/payment")
        public CreditConsumer consumerPaymentMessage() {
          logger.info("Retrive credit payment");
        return paymentFromTopic;
         }
	  
	    @PostMapping
	    public CreditConsumer save(@RequestBody CreditConsumer creditConsumer) {
	        return service.save(creditConsumer);
	    }

	    @GetMapping
	    public List<CreditConsumer> getAllProducts() {
	        return service.findAll();
	    }

	    @GetMapping("/{id}")
	    @Cacheable(key = "#id",value = "CreditConsumer",unless = "#result.amount > 100")
	    public CreditConsumer findProduct(@PathVariable int id) {
	        return service.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    @CacheEvict(key = "#id",value = "CreditConsumer")
	    public String remove(@PathVariable int id) {
	        return service.delete(id);
	    }
     
	  
}
