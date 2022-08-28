package com.binance4j.mining.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Statistics.
 * 
 * @property fifteenMinHashRate 15 mins hashrate.
 * @property dayHashRate        24H Hashrate.
 * @property validNum           Effective quantity.
 * @property invalidNum         Invalid quantity.
 * @property profitToday        Today's estimate.
 * @property profitYesterday    Yesterday's earnings.
 * @property userName           Mining account.
 * @property unit               Hashrate unit.
 * @property algo               Algorithm.
 */
@ApiModel("Statistics.")
data class Statistics(@ApiModelProperty("15 mins hashrate.") String fifteenMinHashRate,
		@ApiModelProperty("24H Hashrate.") String dayHashRate,
		@ApiModelProperty("Effective quantity.") var validNum : Int? = null, @ApiModelProperty("Invalid quantity.") var invalidNum : Int? = null,
		@ApiModelProperty("Today's estimate.") Map<String, String> profitToday,
		@ApiModelProperty("Yesterday's earnings.") Map<String, String> profitYesterday,
		@ApiModelProperty("Mining account.") var userName : String? = null, @ApiModelProperty("Hashrate unit.") var unit : String? = null,
		@ApiModelProperty("Algorithm.") var algo : String? = null) {
}
