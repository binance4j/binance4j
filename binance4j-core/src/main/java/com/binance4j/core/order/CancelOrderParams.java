package com.binance4j.core.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The request to cancel an order */
@Data
@EqualsAndHashCode(callSuper = true)
public class CancelOrderParams extends FramedParams {
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
   
   * 
   * 
   * 
   */
  public CancelOrderParams(String symbol, Long orderId) {
    super(10);
    this.symbol = symbol;
    this.orderId = orderId;
  }

  /**
   
   * 
   * 
   * 
   */
  public CancelOrderParams(String symbol, String origClientOrderId) {
    super(10);
    this.symbol = symbol;
    this.origClientOrderId = origClientOrderId;
  }
}