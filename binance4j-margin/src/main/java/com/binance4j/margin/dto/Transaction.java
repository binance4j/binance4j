package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A transfer, borrow or repay transaction.
 * 
 * @param tranId    Transaction id.
 * @param clientTag Client tag.
 */
@ApiModel("A transfer, borrow or repay transaction.")
public record Transaction(@ApiModelProperty("Transaction id.") String tranId, @ApiModelProperty("Client tag.") String clientTag) {
}