package com.binance4j.margin.dto;

import java.util.Optional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data about a repay.
 * 
 * @property txId           Transaction id.
 * @property timestamp      Transaction timestamp in ms.
 * @property isolatedSymbol Isolated symbol, will not be returned for crossed
 *                       margin.
 * @property amount         Total amount repaid.
 * @property asset          Asset.
 * @property interest       Interest repaid.
 * @property principal      Quantity repaid.
 * @property status         Repay status.
 * @see LoanStatus
 */
@ApiModel("Data about a repay.")
data class RepayRecord(
@ApiModelProperty("Transaction id.")
var txId:Long?=null,
@ApiModelProperty("Transaction timestamp in ms.")
var timestamp:Long?=null,
@ApiModelProperty("Isolated symbol, will not be returned for crossed margin.") Optional<String> isolatedSymbol,
@ApiModelProperty("Total amount repaid.")
var amount:String?=null,
@ApiModelProperty("Asset.")
var asset:String?=null,
@ApiModelProperty("Interest repaid.")
var interest:String?=null,
@ApiModelProperty("Quantity repaid.")
var principal:String?=null,
@ApiModelProperty("Repay status.")
var status:String?=null)
{
}