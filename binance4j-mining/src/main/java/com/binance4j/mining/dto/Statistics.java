package com.binance4j.mining.dto;

import java.util.Map;

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
public record Statistics(String fifteenMinHashRate, String dayHashRate, int validNum, int invalidNum, Map<String, String> profitToday,
		Map<String, String> profitYesterday, String userName, String unit, String algo) {
}
