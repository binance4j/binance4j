package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible purchase response.
 * 
 * @property purchaseId Purchase id.
 */
@ApiModel("Flexible purchase response.")
data class PurchaseResponse(
@ApiModelProperty("Purchase id.")
var purchaseId:String?=null)
{
}