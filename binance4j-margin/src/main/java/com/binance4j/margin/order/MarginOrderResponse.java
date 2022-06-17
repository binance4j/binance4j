package com.binance4j.margin.order;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.OrderStatus;
import com.binance4j.core.order.OrderType;
import com.binance4j.core.order.Trade;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Réponse retournée par l'API quand un ordre est passé
 *
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginOrderResponse {
	private OrderSide side;
	private OrderStatus status;
	private OrderType type;
	private TimeInForce timeInForce;
	private String symbol;
	private Long orderId;
	private Long transactTime;
	private BigDecimal clientOrderId;
	private BigDecimal price;
	private BigDecimal origQty;
	private BigDecimal executedQty;
	private BigDecimal cummulativeQuoteQty;
	private BigDecimal marginBuyBorrowAmount;
	private BigDecimal marginBuyBorrowAsset;
	private Boolean isIsolated;
	private List<Trade> fills;
}