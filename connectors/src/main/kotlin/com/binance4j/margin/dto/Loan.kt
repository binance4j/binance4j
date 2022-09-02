package com.binance4j.margin.dto;

import java.util.Optional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An executed trade history item.
 * 
 * @property status         Loan status.
 * @property principal      Borrowed quantity.
 * @property isolatedSymbol Isolated symbol. Will not be returned for crossed
 *                       margin.
 * @property asset          Related asset.
 * @property timestamp      Loan timestamp in ms.
 * @property txId           Transaction id.
 * @see LoanStatus
 */
@ApiModel("An executed trade history item.")
data class Loan(
@ApiModelProperty("Loan status.")
 val status : String,
@ApiModelProperty("Borrowed quantity.")
 val principal : String,
@ApiModelProperty("Isolated symbol. Will not be returned for crossed margin.") Optional<String> isolatedSymbol,
@ApiModelProperty("Related asset.")
 val asset : String,
@ApiModelProperty("Loan timestamp in ms.")
 val timestamp : Long,
@ApiModelProperty("Transaction id.")  val txId : Long)
{
}