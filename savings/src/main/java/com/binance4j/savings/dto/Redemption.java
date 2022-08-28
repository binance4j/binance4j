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
var amount:String?=null,
@ApiModelProperty("Asset.")
var asset:String?=null,
@ApiModelProperty("Create time.")
var createTime:Long?=null,
@ApiModelProperty("Principal.")
var principal:String?=null,
@ApiModelProperty("Project id.")
var projectId:String?=null,
@ApiModelProperty("Project name.")
var projectName:String?=null,
@ApiModelProperty("Status.")
var status:String?=null,
@ApiModelProperty("Type.")
var type:String?=null)
{
}