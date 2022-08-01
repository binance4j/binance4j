package com.binance4j.mining.dto;

import java.util.Map;

/**
 * @param fifteenMinHashRate    15 mins hashrate
 * @param dayHashRate           24H Hashrate
 * @param validNum              Effective quantity
 * @param invalidNum            Invalid quantity
 * @param ProfitTodayObject     Today's estimate
 * @param ProfitYesterdayObject Yesterday's earnings
 * @param userName              Mining account
 * @param unit                  Hashrate unit
 * @param algo                  Algorithm
 */
public record Statistics(String fifteenMinHashRate, String dayHashRate, int validNum, int invalidNum, Map<String, String> ProfitTodayObject,
		Map<String, String> ProfitYesterdayObject, String userName, String unit, String algo) {
}
