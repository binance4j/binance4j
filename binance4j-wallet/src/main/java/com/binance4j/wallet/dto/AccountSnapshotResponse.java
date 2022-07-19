package com.binance4j.wallet.dto;

import java.util.List;

/** The base of an account snapshot response. */
public interface AccountSnapshotResponse<T> {
	/** @return The response status code (200 for success; others are error codes) */
	int code();

	/** @return The potential response error message. */
	String msg();

	/** @return A list of account snapshots. */
	List<T> snapshotVos();
}
