package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.NewOrderResponseType;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.SideEffectType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MarginOCO(
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		Boolean isIsolated,
		/** TODO JAVADOC. */
		String listClientOrderId,
		/** TODO JAVADOC. */
		OrderSide side,
		/** TODO JAVADOC. */
		BigDecimal quantity,
		/** TODO JAVADOC. */
		String limitClientOrderId,
		/** TODO JAVADOC. */
		BigDecimal price,
		/** TODO JAVADOC. */
		BigDecimal limitIcebergQty,
		/** TODO JAVADOC. */
		String stopClientOrderId,
		/** TODO JAVADOC. */
		BigDecimal stopPrice,
		/** TODO JAVADOC. */
		BigDecimal stopLimitPrice,
		/** TODO JAVADOC. */
		BigDecimal stopIcebergQty,
		/** TODO JAVADOC. */
		TimeInForce stopLimitTimeInForce,
		/** TODO JAVADOC. */
		NewOrderResponseType newOrderRespType,
		/** TODO JAVADOC. */
		SideEffectType sideEffectType) {
}