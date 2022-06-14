package com.binance4j.wallet.assetdividendrecord;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * An asset divident record
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDividendRecord {
	/**
	 * The records
	 */
	private List<AssetDividend> rows;
	/**
	 * The number of record
	 */
	private Long total;
}
