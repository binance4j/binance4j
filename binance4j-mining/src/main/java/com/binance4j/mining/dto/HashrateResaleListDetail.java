package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param configId       Mining ID.
 * @param poolUsername   Transfer out of subaccount.
 * @param toPoolUsername Transfer into subaccount.
 * @param algoName       Transfer algorithm.
 * @param hashRate       Transferred Hashrate quantity.
 * @param startDay       Start date.
 * @param endDay         End date.
 * @param status         Status：0 Processing，1：Cancelled，2：Terminated.
 */
@ApiModel("")
public record HashrateResaleListDetail(@ApiModelProperty("") int configId, @ApiModelProperty("") String poolUsername,
		@ApiModelProperty("") String toPoolUsername, @ApiModelProperty("") String algoName, @ApiModelProperty("") long hashRate,
		@ApiModelProperty("") long startDay, @ApiModelProperty("") long endDay, @ApiModelProperty("") int status) {
}
