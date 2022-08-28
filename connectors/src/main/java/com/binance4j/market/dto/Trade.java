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
@JsonProperty("id") var id:Long?=null,
@ApiModelProperty("Trad price.")
@JsonProperty("price") var price:String?=null,
@ApiModelProperty("Trade volume.")
@JsonProperty("qty") var qty:String?=null,
@ApiModelProperty("Trade opposite volume.")
@JsonProperty("quoteQty") var quoteQty:String?=null,
@ApiModelProperty("Trade execution in ms.")
@JsonProperty("time") var time:Long?=null,
@ApiModelProperty("Is the trade a buyer maker trade.")
@JsonProperty("isBuyerMaker") var isBuyerMaker:Boolean?=null,
@ApiModelProperty("Was the trade the best price match?") @JsonProperty("isBestMatch") var isBestMatch:Boolean?=null)
{
}
