package com.binance4j.mining.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Statistics.
 * 
 * @param fifteenMinHashRate 15 mins hashrate.
 * @param dayHashRate        24H Hashrate.
 * @param validNum           Effective quantity.
 * @param invalidNum         Invalid quantity.
 * @param profitToday        Today's estimate.
 * @param profitYesterday    Yesterday's earnings.
 * @param userName           Mining account.
 * @param unit               Hashrate unit.
 * @param algo               Algorithm.
 */
@ApiModel("Statistics.")
public record Statistics(@ApiModelProperty("15 mins hashrate.") String fifteenMinHashRate, @ApiModelProperty("24H Hashrate.") String dayHashRate,
		@ApiModelProperty("Effective quantity.") int validNum, @ApiModelProperty("Invalid quantity.") int invalidNum,
		@ApiModelProperty("Today's estimate.") Map<String, String> profitToday, @ApiModelProperty("Yesterday's earnings.") Map<String, String> profitYesterday,
		@ApiModelProperty("Mining account.") String userName, @ApiModelProperty("Hashrate unit.") String unit, @ApiModelProperty("Algorithm.") String algo) {
}
