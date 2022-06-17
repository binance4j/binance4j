package com.binance4j.margin.oco;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.NewOrderResponseType;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.SideEffectType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginOCO {
    private String symbol;
    private Boolean isIsolated;
    private String listClientOrderId;
    private OrderSide side;
    private BigDecimal quantity;
    private String limitClientOrderId;
    private BigDecimal price;
    private BigDecimal limitIcebergQty;
    private String stopClientOrderId;
    private BigDecimal stopPrice;
    private BigDecimal stopLimitPrice;
    private BigDecimal stopIcebergQty;
    private TimeInForce stopLimitTimeInForce;
    private NewOrderResponseType newOrderRespType;
    private SideEffectType sideEffectType;
}