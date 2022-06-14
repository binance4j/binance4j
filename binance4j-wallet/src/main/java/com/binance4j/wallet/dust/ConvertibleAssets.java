package com.binance4j.wallet.dust;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Assets that can be converted into BNB
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertibleAssets {
	private List<ConvertibleAsset> details;
	/**
	 * The BTC valuation
	 */
	private BigDecimal totalTransferBtc;
	/**
	 * The BNB valuation
	 */
	private BigDecimal totalTransferBNB;
	/**
	 * The commission fee
	 */
	private BigDecimal dribbletPercentage;
}
