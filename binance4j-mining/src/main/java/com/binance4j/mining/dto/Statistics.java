package com.binance4j.mining.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param fifteenMinHashRate 15 mins hashrate
 * @param dayHashRate        24H Hashrate
 * @param validNum           Effective quantity
 * @param invalidNum         Invalid quantity
 * @param profitToday        Today's estimate
 * @param profitYesterday    Yesterday's earnings
 * @param userName           Mining account
 * @param unit               Hashrate unit
 * @param algo               Algorithm
 */
@ApiModel("")
public record Statistics(@ApiModelProperty("") String fifteenMinHashRate, @ApiModelProperty("") String dayHashRate, @ApiModelProperty("") int validNum,
		@ApiModelProperty("") int invalidNum, @ApiModelProperty("") Map<String, String> profitToday, @ApiModelProperty("") Map<String, String> profitYesterday,
		@ApiModelProperty("") String userName, @ApiModelProperty("") String unit, @ApiModelProperty("") String algo) {
}
