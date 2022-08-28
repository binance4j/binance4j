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
@JsonProperty("amount") var amount:String?=null,
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Create time.")
@JsonProperty("createTime") var createTime:Long?=null,
@ApiModelProperty("Lending type.")
@JsonProperty("lendingType") var lendingType:String?=null,
@ApiModelProperty("Lot.")
@JsonProperty("lot") var lot:Long?=null,
@ApiModelProperty("Product name.")
@JsonProperty("productName") var productName:String?=null,
@ApiModelProperty("Purchase id.")
@JsonProperty("purchaseId") var purchaseId:Long?=null,
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null)
{
}