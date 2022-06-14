package com.binance4j.core.order;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The request to cancel an order */
@Data
@EqualsAndHashCode(callSuper = true)
public class CancelOrderRequest extends FramedRequest {
  /**
   * The trade symbol
   */
  private String symbol;
  /**
   * The order id
   */
  private Long orderId;
  /**
   * The original client order id
   */
  private String origClientOrderId;
  /**
   * The new client order id
   */
  private String newClientOrderId;

  /**
   * Constructor
   * 
   * 
   * 
   */
  public CancelOrderRequest(String symbol, Long orderId) {
    super(10);
    this.symbol = symbol;
    this.orderId = orderId;
  }

  /**
   * Constructor
   * 
   * 
   * 
   */
  public CancelOrderRequest(String symbol, String origClientOrderId) {
    super(10);
    this.symbol = symbol;
    this.origClientOrderId = origClientOrderId;
  }
}