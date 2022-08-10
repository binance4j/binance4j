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
@ApiModel("Logs of assets converted in BNB.")
public record DustLog(@ApiModelProperty("Total counts of exchange.") int total,
		@ApiModelProperty("Dribblets.") List<UserAssetDribblets> userAssetDribblets) {
}
