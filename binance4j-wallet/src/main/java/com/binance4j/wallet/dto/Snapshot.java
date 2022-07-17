package com.binance4j.wallet.dto;

/** A daily account snapshot */
public interface Snapshot {
	/** The snapshot type ("spot/margin/futures") */
	String type();

	/** The snapshot update timestamp. */
	long updateTime();
}