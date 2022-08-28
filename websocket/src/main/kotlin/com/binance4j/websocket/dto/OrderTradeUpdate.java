package com.binance4j.websocket.dto;

import com.binance4j.core.dto.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Order or trade report update event.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @property eventType               Event type.
 * @property eventTime               Timestamp.
 * @property symbol                  Trading pair.
 * @property newClientOrderId        Client order id.
 * @property side                    Buy/Sell order side.
 * @property type                    Type of order.
 * @property timeInForce             Time in force to indicate how Long will the
 *                                order remain active.
 * @property originalQuantity        Original quantity in the order.
 * @property price                   Price.
 * @property executionType           Type of execution.
 * @property orderStatus             Status of the order.
 * @property orderRejectReason       Reason why the order was rejected.
 * @property orderId                 Order id.
 * @property quantityLastFilledTrade Quantity of the last filled trade.
 * @property accumulatedQuantity     Accumulated quantity of filled trades on this
 *                                order.
 * @property priceOfLastFilledTrade  Price of last filled trade.
 * @property commission              Commission.
 * @property commissionAsset         Asset on which commission is taken.
 * @property orderTradeTime          Order/trade time.
 * @property tradeId                 Trade id.
 * @property orderCreationTime       Order creation time.
 * @property cumulativeQuoteQuantity Cumulative quote asset transacted quantity.
 * @property lastQuoteQuantity       Last quote asset transacted quantity (i.e.
 *                                lastPrice * lastQty).
 * @property quoteOrderQuantity      Quote Order quantity.
 * @see UserDataUpdate
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Order or trade report update event.")
data class OrderTradeUpdate(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
		@ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime,
		@ApiModelProperty("Trading pair.") @JsonProperty("s") String symbol,
		@ApiModelProperty("Client order id.") @JsonProperty("c") String newClientOrderId,
		@ApiModelProperty("Buy/Sell order side.") @JsonProperty("S") String side,
		@ApiModelProperty("Type of order.") @JsonProperty("o") String type,
		@ApiModelProperty("Time in force to indicate how Long will the order remain active.") @JsonProperty("f") TimeInForce timeInForce,
		@ApiModelProperty("Original quantity in the order.") @JsonProperty("q") String originalQuantity,
		@ApiModelProperty("Price.") @JsonProperty("p") String price,
		@ApiModelProperty("Type of execution.") @JsonProperty("x") String executionType,
		@ApiModelProperty("Status of the order.") @JsonProperty("X") String orderStatus,
		@ApiModelProperty("Reason why the order was rejected.") @JsonProperty("r") String orderRejectReason,
		@ApiModelProperty("Order id.") @JsonProperty("i") Long orderId,
		@ApiModelProperty("Quantity of the last filled trade.") @JsonProperty("l") String quantityLastFilledTrade,
		@ApiModelProperty("Accumulated quantity of filled trades on this order.") @JsonProperty("z") String accumulatedQuantity,
		@ApiModelProperty("Price of last filled trade.") @JsonProperty("L") String priceOfLastFilledTrade,
		@ApiModelProperty("Commission.") @JsonProperty("n") String commission,
		@ApiModelProperty("Asset on which commission is taken.") @JsonProperty("N") String commissionAsset,
		@ApiModelProperty("Order/trade time.") @JsonProperty("T") Long orderTradeTime,
		@ApiModelProperty("Trade id.") @JsonProperty("t") Long tradeId,
		@ApiModelProperty("Order creation time.") @JsonProperty("O") Long orderCreationTime,
		@ApiModelProperty("Cumulative quote asset transacted quantity.") @JsonProperty("Z") String cumulativeQuoteQuantity,
		@ApiModelProperty("Last quote asset transacted quantity (i.e. lastPrice * lastQty).") @JsonProperty("Y") String lastQuoteQuantity,
		@ApiModelProperty("Quote Order quantity.") @JsonProperty("Q") String quoteOrderQuantity) {
}