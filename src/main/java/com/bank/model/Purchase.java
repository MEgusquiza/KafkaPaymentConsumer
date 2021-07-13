package com.bank.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Purchase")
public class Purchase implements Serializable {

  private static final long serialVersionUID = 1L;
    @Id
	private String id;
	private String operationNumber;
	private Double amount;

}
