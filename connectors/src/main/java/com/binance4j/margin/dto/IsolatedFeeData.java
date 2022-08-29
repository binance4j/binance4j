package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated fee data.
 * 
 * @property coin          Related coin.
 * @property dailyInterest Daily interest.
 * @property borrowLimit   Borrow limit.
 */
@ApiModel("Isolated fee data.")
data class IsolatedFeeData(
@ApiModelProperty("Related coin.")
 val coin : String,
@ApiModelProperty("Daily interest.")
 val dailyInterest : String,
@ApiModelProperty("Borrow limit.")
 val borrowLimit : String)
{
}