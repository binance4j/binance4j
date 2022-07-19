package com.binance4j.wallet.dto;

/** A daily account snapshot */
public interface Snapshot {
	/** @return The snapshot type ("spot/margin/futures") */
	String type();

	/** @return The snapshot update timestamp. */
	long updateTime();
}