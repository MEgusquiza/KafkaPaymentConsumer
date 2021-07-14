package com.bank.utils;

public class ConsumerYankiUtils {

  public static final String CONSUMER_GROUP="group-payment-consumer-yanki";
  public static final String SERVER_CONFIG="localhost:9092";
  public static final String SERVER_REDIS="localhost";
  public static final int PORT_REDIS=6379;
  public static final String CONSUMER_TOPIC="topic-publish-payment-yanki";
  public static final String CONTAINER_FACTORY="paymentKafkaListenerContainerFactory";
  public static final String RESPONSE_CONSUMER_TOPIC="topic-consumer-payment-yanki";
  
  
}
