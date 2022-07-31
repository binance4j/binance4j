package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An order report.
 * 
 * @param orderListId              /** The order list id.
 * @param origClientOrderId        /** The original client order id.
 * @param transactTime             /** The order timestamp.
 * @param side                     /** The order side.
 * @param price                    /** Price.
 * @param origQuantity             /** Original quantity.
 * @param executedQuantity         /** Original quantity.
 * @param cummulativeQuoteQuantity /** Used to calculate the average price.
 * @param status                   /** Order status.
 * @param timeInForce              /** Time in force to indicate how long will the order remain active.
 * @param type                     /** Type of order.
 * @param stopPrice                /** Used with stop orders.
 * @param icebergQuantity          /** Used with iceberg orders.
 * @param time                     /** Order timestamp.
 * @param updateTime               /** Update timestamp.
 * @param origQuoteOrderQuantity   /** Original quote order quantity.
 * @param isWorking                /** Is working.
 * @param isIsolated               /** is isolated margin.
 * @param symbol                   /** The order symbol.
 * @param orderId                  /** Order id.
 * @param clientOrderId            /** Client order id.
 */
public record OrderReport(long orderListId, String origClientOrderId, long transactTime, OrderSide side, String price,
		@JsonProperty("origQty") String origQuantity, @JsonProperty("executedQty") String executedQuantity,
		@JsonProperty("cummulativeQuoteQty") String cummulativeQuoteQuantity, String status, String timeInForce, String type, String stopPrice,
		@JsonProperty("icebergQty") String icebergQuantity, long time, long updateTime, @JsonProperty("origQuoteOrderQty") String origQuoteOrderQuantity,
		boolean isWorking, boolean isIsolated, String symbol, long orderId, String clientOrderId) {
}
