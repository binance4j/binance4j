package com.binance4j.blvt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BLVT redemption response.
 * 
 * @param id           Subscription id.
 * @param status       Subscription status. S("success"), P("pending"), and F("failure").
 * @param tokenName    Token name.
 * @param amount       Redemption value in usdt.
 * @param redeemAmount Redemption token amount.
 * @param timestamp    Timestamp in ms.
 */
@ApiModel("BLVT redemption response.")
public record RedemptionResponse(@ApiModelProperty("Subscription id.") long id,
		@ApiModelProperty("Subscription status. S(\"success\"), P(\"pending\"), and F(\"failure\").") String status,
		@ApiModelProperty("Token name.") String tokenName, @ApiModelProperty("Redemption value in usdt.") String redeemAmount,
		@ApiModelProperty("Redemption token amount.") String amount, @ApiModelProperty("Timestamp in ms.") long timestamp) {
}