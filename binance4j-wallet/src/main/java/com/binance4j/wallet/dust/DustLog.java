package com.binance4j.wallet.dust;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Logs of assets converted in BNB
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustLog {
	/**
	 * Total counts of exchange
	 */
	private Integer total;
	/**
	 * ???
	 */
	private List<DustLogUserAssetDribblets> userAssetDribblets;
}
