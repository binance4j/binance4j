package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A mining algorithm.
 * 
 * @param algoName  Algorithm name.
 * @param algoId    Algorithm id.
 * @param poolIndex Sequence.
 * @param unit      Unit.
 */
@ApiModel("")
public record Algorithm(@ApiModelProperty("") String algoName, @ApiModelProperty("") long algoId, @ApiModelProperty("") long poolIndex,
		@ApiModelProperty("") String unit) {
}
