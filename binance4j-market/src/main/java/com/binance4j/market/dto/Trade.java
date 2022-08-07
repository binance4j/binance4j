package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An executed trade history item.
 * 
 * @param id           Trade id.
 * @param price        Trad price.
 * @param qty          Trade volume.
 * @param quoteQty     Trade opposite volume.
 * @param time         Trade execution in ms.
 * @param isBuyerMaker Is the trade a buyer maker trade.
 * @param isBestMatch  Was the trade the best price match?
 */
@ApiModel("An executed trade history item.")
public record Trade(@ApiModelProperty("Trade id.") long id, @ApiModelProperty("Trad price.") String price, @ApiModelProperty("Trade volume.") String qty,
		@ApiModelProperty("Trade opposite volume.") String quoteQty, @ApiModelProperty("Trade execution in ms.") long time,
		@ApiModelProperty("Is the trade a buyer maker trade.") boolean isBuyerMaker,
		@ApiModelProperty("Was the trade the best price match?") boolean isBestMatch) {
}
