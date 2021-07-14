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
@RedisHash("Customer")
public class Customer implements Serializable {
  private static final long serialVersionUID = -3132669942722488069L;
  
  @Id
  private int id;
  private int phone;
  private int document;
  private String documentType;
  private int imei;
  private String mail;
}
