package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A mineable coin.
 * 
 * @param coinName  The currency name.
 * @param coinId    The coin id.
 * @param poolIndex The pool index.
 * @param algoId    The algorithm id.
 * @param algoName  The name of the algorithm.
 */
@ApiModel("")
public record Coin(@ApiModelProperty("") String coinName, @ApiModelProperty("") long coinId, @ApiModelProperty("") long poolIndex,
		@ApiModelProperty("") long algoId, @ApiModelProperty("") String algoName) {
}
