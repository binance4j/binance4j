package com.binance4j.margin.forceliquidation;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.OrderSide;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForceLiquidation {
    private BigDecimal avgPrice;
    private BigDecimal executedQty;
    private long orderId;
    private BigDecimal price;
    private BigDecimal qty;
    private OrderSide side;
    private String symbol;
    private TimeInForce timeInForce;
    private Boolean isIsolated;
    private long updatedTime;
}
