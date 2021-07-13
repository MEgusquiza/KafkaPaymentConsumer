package com.bank.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.bank.model.CreditConsumer;
import com.bank.service.CreditConsumerService;


@Repository
public class CreditConsumerServiceImpl implements CreditConsumerService{
      
 public static final String HASH_KEY = "CreditConsumer";       
         @Autowired
         private RedisTemplate template;

 	     @Override
	     public CreditConsumer findById(int id) {
	     System.out.println("called findProductById() from DB");
	     return (CreditConsumer) template.opsForHash().get(HASH_KEY,id);
         }

	    @Override
	    public List<CreditConsumer> findAll() {
	      return template.opsForHash().values(HASH_KEY);
	    }

	    @Override
	    public CreditConsumer update(CreditConsumer creditConsumer) {
	     return save(creditConsumer);
	    }

	    @Override
	    public CreditConsumer save(CreditConsumer creditConsumer) {
	      template.opsForHash().put(HASH_KEY,creditConsumer.getId(),creditConsumer);
	        return creditConsumer;
	    }
	    
	    @Override
	    public String delete(int id) {
	      template.opsForHash().delete(HASH_KEY,id);
	        return "product removed !!";
	    }

}
