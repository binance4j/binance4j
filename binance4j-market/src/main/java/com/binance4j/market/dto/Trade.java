package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents an executed trade history item.
 * 
 * @param id           The trade id.
 * @param price        The trad price.
 * @param qty          The trade volume.
 * @param quoteQty     The trade opposite volume.
 * @param time         The trade execution in ms.
 * @param isBuyerMaker Is the trade a buyer maker trade.
 * @param isBestMatch  Was the trade the best price match?
 */
@ApiModel("")
public record Trade(@ApiModelProperty("") long id, @ApiModelProperty("") String price, @ApiModelProperty("") String qty, @ApiModelProperty("") String quoteQty,
		@ApiModelProperty("") long time, @ApiModelProperty("") boolean isBuyerMaker, @ApiModelProperty("") boolean isBestMatch) {
}
