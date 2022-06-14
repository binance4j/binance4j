package com.binance4j.wallet.snapshot.margin;

import com.binance4j.wallet.snapshot.Snapshot;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A daily MARGIN account snapshot
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarginAccountSnapshot extends Snapshot {
	/**
	 * The account snapshot data
	 */
	private MarginAccountSnapshotData data;
}