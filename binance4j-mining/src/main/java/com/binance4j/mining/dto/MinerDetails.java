package com.binance4j.mining.dto;

import java.util.List;

/**
 * Miner details.
 * 
 * @param workerName    Mining Account name.
 * @param type          Type of hourly hashrate.
 * @param hashrateDatas Hashrate datas
 */
public record MinerDetails(
		/** Mining Account name. */
		String workerName,
		/** Type of hourly hashrate. */
		String type,
		/** Hashrate datas */
		List<HashrateData> hashrateDatas) {
}