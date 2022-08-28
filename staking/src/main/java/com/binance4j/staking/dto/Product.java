package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A staking product.
 * 
 * @property projectId Project id.
 * @property detail    Detail.
 * @property quota     Quota.
 */
@ApiModel("A staking product.")
data class Product(
@ApiModelProperty("Project id.")
var projectId:String?=null,
@ApiModelProperty("Detail.")
var detail:ProductDetail?=null,
@ApiModelProperty("Quota.")
var quota:ProductQuota?=null)
{
}