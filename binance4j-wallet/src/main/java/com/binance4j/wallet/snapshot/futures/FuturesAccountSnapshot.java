package com.binance4j.wallet.snapshot.futures;

import com.binance4j.wallet.snapshot.Snapshot;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A daily FUTURES account snapshot
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FuturesAccountSnapshot extends Snapshot {
	/**
	 * The account snapshot data
	 */
	private FuturesSnapshotData data;
}