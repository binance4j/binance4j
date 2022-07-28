package com.binance4j.staking.dto;

/** A staking purchase response. */
public record PurchaseResponse(
		/** The position id. */
		String positionId,
		/** Was the transaction successfull? */
		boolean success) {
}