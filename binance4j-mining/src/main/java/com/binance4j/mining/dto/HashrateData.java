package com.binance4j.mining.dto;

/** Hashrate data. */
public record HashrateData(
		/** Time in ms. */
		long time,
		/** Hashrate. */
		String hashrate,
		/** Rejection Rate. */
		long reject) {
}