package com.binance4j.portfoliomargin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Collaterate rate info.
 * 
 * @param asset          The asset.
 * @param collateralRate The collateral rate.
 */
@ApiModel("")
public record CollaterateRateInfo(@ApiModelProperty("") String asset, @ApiModelProperty("") String collateralRate) {
}