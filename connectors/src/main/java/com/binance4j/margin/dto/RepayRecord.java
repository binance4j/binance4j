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
 val txId : Long,
@ApiModelProperty("Transaction timestamp in ms.")
 val timestamp : Long,
@ApiModelProperty("Isolated symbol, will not be returned for crossed margin.") Optional<String> isolatedSymbol,
@ApiModelProperty("Total amount repaid.")
 val amount : String,
@ApiModelProperty("Asset.")
 val asset : String,
@ApiModelProperty("Interest repaid.")
 val interest : String,
@ApiModelProperty("Quantity repaid.")
 val principal : String,
@ApiModelProperty("Repay status.")
 val status : String)
{
}