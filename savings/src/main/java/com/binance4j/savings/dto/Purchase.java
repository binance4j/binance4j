package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Purchase infos.
 * 
 * @property amount      Amount.
 * @property asset       Asset.
 * @property createTime  Create time.
 * @property lendingType Lending type.
 * @property lot         Lot.
 * @property productName Product name.
 * @property purchaseId  Purchase id.
 * @property status      Status.
 */
@ApiModel("Purchase infos.")
data class Purchase(
@ApiModelProperty("Amount.")
var amount:String?=null,
@ApiModelProperty("Asset.")
var asset:String?=null,
@ApiModelProperty("Create time.")
var createTime:Long?=null,
@ApiModelProperty("Lending type.")
var lendingType:String?=null,
@ApiModelProperty("Lot.")
var lot:Long?=null,
@ApiModelProperty("Product name.")
var productName:String?=null,
@ApiModelProperty("Purchase id.")
var purchaseId:Long?=null,
@ApiModelProperty("Status.")
var status:String?=null)
{
}