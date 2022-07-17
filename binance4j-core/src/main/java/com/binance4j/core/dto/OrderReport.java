package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An order report.
 * 
 * @param orderListId         /** The order list id.
 * @param origClientOrderId   /** The original client order id.
 * @param transactTime        /** The order timestamp.
 * @param side                /** The order side.
 * @param price               /** Price.
 * @param origQty             /** Original quantity.
 * @param executedQty         /** Original quantity.
 * @param cummulativeQuoteQty /** Used to calculate the average price.
 * @param status              /** Order status.
 * @param timeInForce         /** Time in force to indicate how long will the order remain active.
 * @param type                /** Type of order.
 * @param stopPrice           /** Used with stop orders.
 * @param icebergQty          /** Used with iceberg orders.
 * @param time                /** Order timestamp.
 * @param updateTime          /** Update timestamp.
 * @param origQuoteOrderQty   /** Original quote order quantity.
 * @param isWorking           /** Is working.
 * @param isIsolated          /** is isolated margin.
 * @param symbol              /** The order symbol.
 * @param orderId             /** Order id.
 * @param clientOrderId       /** Client order id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderReport(
		/** The order list id. */
		long orderListId,
		/** The original client order id. */
		String origClientOrderId,
		/** The order timestamp. */
		long transactTime,
		/** The order side. */
		OrderSide side,
		/** Price. */
		BigDecimal price,
		/** Original quantity. */
		BigDecimal origQty,
		/** Original quantity. */
		BigDecimal executedQty,
		/** Used to calculate the average price. */
		BigDecimal cummulativeQuoteQty,
		/** Order status. */
		OrderStatus status,
		/** Time in force to indicate how long will the order remain active. */
		TimeInForce timeInForce,
		/** Type of order. */
		OrderType type,
		/** Used with stop orders. */
		BigDecimal stopPrice,
		/** Used with iceberg orders. */
		BigDecimal icebergQty,
		/** Order timestamp. */
		long time,
		/** Update timestamp. */
		long updateTime,
		/** Original quote order quantity. */
		BigDecimal origQuoteOrderQty,
		/** Is working */
		boolean isWorking,
		/** is isolated margin. */
		boolean isIsolated,
		/** The order symbol. */
		String symbol,
		/** Order id. */
		long orderId,
		/** Client order id. */
		String clientOrderId) {
}
