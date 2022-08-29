package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An executed trade history item.
 * 
 * @property id           Trade id.
 * @property price        Trad price.
 * @property qty          Trade volume.
 * @property quoteQty     Trade opposite volume.
 * @property time         Trade execution in ms.
 * @property isBuyerMaker Is the trade a buyer maker trade.
 * @property isBestMatch  Was the trade the best price match?
 */
@ApiModel("An executed trade history item.")
data class Trade(
@ApiModelProperty("Trade id.")
 val id : Long,
@ApiModelProperty("Trad price.")
 val price : String,
@ApiModelProperty("Trade volume.")
 val qty : String,
@ApiModelProperty("Trade opposite volume.")
 val quoteQty : String,
@ApiModelProperty("Trade execution in ms.")
 val time : Long,
@ApiModelProperty("Is the trade a buyer maker trade.")
 val isBuyerMaker : Boolean,
@ApiModelProperty("Was the trade the best price match?")  val isBestMatch : Boolean)
{
}
