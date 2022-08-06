package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate resale list detail.
 * 
 * @param configId       Mining ID.
 * @param poolUsername   Transfer out of subaccount.
 * @param toPoolUsername Transfer into subaccount.
 * @param algoName       Transfer algorithm.
 * @param hashRate       Transferred Hashrate quantity.
 * @param startDay       Start date.
 * @param endDay         End date.
 * @param status         Status：0 Processing，1：Cancelled，2：Terminated.
 */
@ApiModel("Hashrate resale list detail.")
public record HashrateResaleListDetail(@ApiModelProperty("Mining ID.") int configId, @ApiModelProperty("Transfer out of subaccount.") String poolUsername,
		@ApiModelProperty("Transfer into subaccount.") String toPoolUsername, @ApiModelProperty("Transfer algorithm.") String algoName,
		@ApiModelProperty("Transferred Hashrate quantity.") long hashRate, @ApiModelProperty("Start date.") long startDay,
		@ApiModelProperty("End date.") long endDay, @ApiModelProperty("Status：0 Processing，1：Cancelled，2：Terminated.") int status) {
}
