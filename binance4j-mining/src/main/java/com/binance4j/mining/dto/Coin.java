package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A mineable coin.
 * 
 * @param coinName  Currency name.
 * @param coinId    Coin id.
 * @param poolIndex Pool index.
 * @param algoId    Algorithm id.
 * @param algoName  Name of the algorithm.
 */
@ApiModel("A mineable coin.")
public record Coin(@ApiModelProperty("Currency name.") String coinName, @ApiModelProperty("Coin id.") long coinId,
		@ApiModelProperty("Pool index.") long poolIndex, @ApiModelProperty("Algorithm id.") long algoId,
		@ApiModelProperty("Name of the algorithm.") String algoName) {
}
