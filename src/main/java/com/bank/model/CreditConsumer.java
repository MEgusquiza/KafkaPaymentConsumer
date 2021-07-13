package com.bank.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("CreditConsumer")
public class CreditConsumer {//implements Serializable {

  //private static final long serialVersionUID = -1121869869398552288L;

        @Id
		private int id;
		private int phone;
		private Double amount;
		private String description = "";	

}
