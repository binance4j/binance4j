package com.binance4j.wallet.snapshot.spot;

import com.binance4j.core.account.AssetBalance;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * The SPOT account snapshot data
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotAccountSnapshotData {
	/**
	 * The wallet asset balances
	 */
	private List<AssetBalance> balances;
	/**
	 * The cumulated value of the wallet in Bitcoin
	 */
	private BigDecimal totalAssetOfBtc;
}