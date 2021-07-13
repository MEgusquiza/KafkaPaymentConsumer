package com.bank.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Customer")
public class Customer {
  @Id
  private int id;
  private int phone;
  private int document;
  private String documentType;
  private int imei;
  private String mail;
}
