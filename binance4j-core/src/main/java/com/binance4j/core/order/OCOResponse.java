package com.binance4j.core.order;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The resposne of an OCO order */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCOResponse {
	/**
	 * The order list id
	 */
	private Long orderListId;
	/**
	 * ???
	 */
	private ContingencyType contingencyType;
	/**
	 * The list status
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
	 * The order timestamp
	 */
	private Long transactionTime;
	/**
	 * The order symbol
	 */
	private String symbol;
	/**
	 * The 2 orders
	 */
	private List<MiniOrderInfo> orders;
	/**
	 * if isolated margin
	 */
	private Boolean isIsolated;
	/**
	 * The order reports
	 */
	private List<OrderReport> orderReports;
}