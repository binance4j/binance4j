package com.binance4j.spot.order;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to fetch open orders from one or all pairs */
@Data
@EqualsAndHashCode(callSuper = true)
public class OpenOrdersStatusRequest extends FramedRequest {
  /**
   * @return The pair we want the open orders
   * 
   */
  private String symbol;

  /** Constructor toi get all open orders */
  public OpenOrdersStatusRequest() {
    super(1);
  }

  /**
   * Constructor to get the open orders of a specific pair
   * 
   * @param symbol The pair we want the open orders
   */
  public OpenOrdersStatusRequest(String symbol) {
    this();
    this.symbol = symbol;
  }
}
