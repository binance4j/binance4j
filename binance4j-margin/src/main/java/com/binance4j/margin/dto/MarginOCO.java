package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.NewOrderResponseType;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.SideEffectType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MarginOCO(
		String symbol,
		Boolean isIsolated,
		String listClientOrderId,
		OrderSide side,
		BigDecimal quantity,
		String limitClientOrderId,
		BigDecimal price,
		BigDecimal limitIcebergQty,
		String stopClientOrderId,
		BigDecimal stopPrice,
		BigDecimal stopLimitPrice,
		BigDecimal stopIcebergQty,
		TimeInForce stopLimitTimeInForce,
		NewOrderResponseType newOrderRespType,
		SideEffectType sideEffectType) {
}