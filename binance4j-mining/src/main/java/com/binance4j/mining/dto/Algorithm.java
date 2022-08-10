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
@ApiModel("A mining algorithm.")
public record Algorithm(@ApiModelProperty("Algorithm name.") String algoName,
		@ApiModelProperty("Algorithm id.") long algoId,
		@ApiModelProperty("Sequence.") long poolIndex, @ApiModelProperty("Unit.") String unit) {
}
