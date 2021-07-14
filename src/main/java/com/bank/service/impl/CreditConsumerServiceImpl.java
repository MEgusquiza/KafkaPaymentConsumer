package com.bank.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.bank.model.CreditPayment;
import com.bank.service.CreditConsumerService;


@Repository
public class CreditConsumerServiceImpl implements CreditConsumerService{
      
 public static final String HASH_KEY = "CreditPayment";       
         @Autowired
         private RedisTemplate template;

 	     @Override
	     public CreditPayment findById(int id) {
	     return (CreditPayment) template.opsForHash().get(HASH_KEY,id);
         }

	    @Override
	    public List<CreditPayment> findAll() {
	      return template.opsForHash().values(HASH_KEY);
	    }

	    @Override
	    public CreditPayment update(CreditPayment creditConsumer) {
	     return save(creditConsumer);
	    }

	    @Override
	    public CreditPayment save(CreditPayment creditConsumer) {
	      template.opsForHash().put(HASH_KEY,creditConsumer.getId(),creditConsumer);
	        return creditConsumer;
	    }
	    
	    @Override
	    public String delete(int id) {
	      template.opsForHash().delete(HASH_KEY,id);
	        return "product removed !!";
	    }

}
