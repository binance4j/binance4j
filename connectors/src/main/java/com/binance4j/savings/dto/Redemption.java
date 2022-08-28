package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Redemption infos.
 * 
 * @property amount      Amount.
 * @property asset       Asset.
 * @property createTime  Create time.
 * @property principal   Principal.
 * @property projectId   Project id.
 * @property projectName Project name.
 * @property status      Status.
 * @property type        Type.
 */
@ApiModel("Redemption infos.")
data class Redemption(
@ApiModelProperty("Amount.")
@JsonProperty("amount") var amount:String?=null,
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Create time.")
@JsonProperty("createTime") var createTime:Long?=null,
@ApiModelProperty("Principal.")
@JsonProperty("principal") var principal:String?=null,
@ApiModelProperty("Project id.")
@JsonProperty("projectId") var projectId:String?=null,
@ApiModelProperty("Project name.")
@JsonProperty("projectName") var projectName:String?=null,
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Type.")
@JsonProperty("type") var type:String?=null)
{
}