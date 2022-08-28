package com.binance4j.portfoliomargin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Collaterate rate info.
 * 
 * @param asset          Asset.
 * @param collateralRate Collateral rate.
 */
@ApiModel("Collaterate rate info.")
public record CollaterateRateInfo(@ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Collateral rate.") String collateralRate) {
}