package com.binance4j.blvt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BVLT subscription response.
 * 
 * @param id        Subscription id.
 * @param status    Subscription status. S("success"), P("pending"), and
 *                  F("failure").
 * @param tokenName Token name.
 * @param amount    Subscribed token amount.
 * @param cost      Subscription cost.
 * @param timestamp Timestamp in ms.
 */
@ApiModel("BVLT subscription response.")
public record SubscriptionResponse(@ApiModelProperty("Subscription id.") long id,
		@ApiModelProperty("Subscription status. S(\"success\"), P(\"pending\"), and F(\"failure\").") String status,
		@ApiModelProperty("Token name.") String tokenName, @ApiModelProperty("Subscribed token amount.") String amount,
		@ApiModelProperty("Subscription cost.") String cost, @ApiModelProperty("Timestamp in ms.") long timestamp) {
}