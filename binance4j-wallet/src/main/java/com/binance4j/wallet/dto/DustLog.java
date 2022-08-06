package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Logs of assets converted in BNB.
 * 
 * @param total              Total counts of exchange.
 * @param userAssetDribblets Dribblets.
 */
@ApiModel("")
public record DustLog(@ApiModelProperty("") int total, @ApiModelProperty("") List<UserAssetDribblets> userAssetDribblets) {
}
