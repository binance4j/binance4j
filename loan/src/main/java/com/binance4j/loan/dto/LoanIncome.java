package com.binance4j.loan.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A loan income.
 * 
 * @property asset     Income asset.
 * @property type      Income type.
 * @property amount    Income maount.
 * @property timestamp Timestamp in ms.
 * @property tranId    Transaction id.
 */
@ApiModel("A loan income.")
data class LoanIncome(
@ApiModelProperty("Income asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Income type.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("Income maount.")
@JsonProperty("amount") var amount:String?=null,
@ApiModelProperty("Timestamp in ms.")
@JsonProperty("timestamp") var timestamp:Long?=null,
@ApiModelProperty("Transaction id.")
@JsonProperty("tranId") var tranId:String?=null)
{
}