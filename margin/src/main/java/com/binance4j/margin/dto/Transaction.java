package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A transfer, borrow or repay transaction.
 * 
 * @property tranId    Transaction id.
 * @property clientTag Client tag.
 */
@ApiModel("A transfer, borrow or repay transaction.")
data class Transaction(
@ApiModelProperty("Transaction id.")
@JsonProperty("tranId") var tranId:String?=null,
@ApiModelProperty("Client tag.")
@JsonProperty("clientTag") var clientTag:String?=null)
{
}