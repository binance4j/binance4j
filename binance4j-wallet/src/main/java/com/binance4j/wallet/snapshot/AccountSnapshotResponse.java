package com.binance4j.wallet.snapshot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * The base of an account snapshot response
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AccountSnapshotResponse<T> {
	/**
	 * The response status code (200 for success; others are error
	 * codes)
	 */
	private Integer code;
	/**
	 * The potential response error message
	 */
	private String msg;
	/**
	 * A list of account snapshots
	 */
	private List<T> snapshotVos;
}
