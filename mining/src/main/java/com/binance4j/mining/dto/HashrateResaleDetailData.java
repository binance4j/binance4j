package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate detail data.
 * 
 * @property profitTransferDetails Details.
 * @property totalNum              Total amount.
 * @property pageSize              Rows per page.
 */
@ApiModel("Hashrate detail data.")
data class HashrateResaleDetailData(
@ApiModelProperty("Details.")
List<HashrateResaleDetail> profitTransferDetails,
@ApiModelProperty("Total amount.") @JsonProperty("totalNum : Long? = null, @ApiModelProperty("Rows per page.") var pageSize ")
var totalNum:Long?=null,
@ApiModelProperty("Rows per page.")
var pageSize:Long?=null)
{
}