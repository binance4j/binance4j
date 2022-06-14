package com.binance4j.spot.order;

import com.binance4j.core.order.ContingencyType;
import com.binance4j.core.order.OCOOrderStatus;
import com.binance4j.core.order.OCOStatus;
import com.binance4j.core.order.OrderInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * An OCO Order details
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCOInfo {
	/**
	 * The order list id
	 */
	private Long orderListId;
	/**
	 * The contingency type
	 */
	private ContingencyType contingencyType;
	/**
	 * The list status type
	 */
	private OCOStatus listStatusType;
	/**
	 * The list order status
	 */
	private OCOOrderStatus listOrderStatus;
	/**
	 * The list client order id
	 */
	private String listClientOrderId;
	/**
	 * The transaction timestamp in ms
	 */
	private Long transactionTime;
	/**
	 * The orders symbol
	 */
	private String symbol;
	/**
	 * The two orders of the OCO order
	 */
	private List<OrderInfo> orders;
}
