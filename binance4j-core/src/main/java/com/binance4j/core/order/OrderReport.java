package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/** An order report */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderReport extends OrderInfo {
	/**
	 * The order list id
	 */
	private Long orderListId;
	/**
	 * The original client order id
	 */
	private String origClientOrderId;
	/**
	 * The order timestamp
	 */
	private Long transactTime;
}
