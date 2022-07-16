package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines the quantity (aka "lots" in auction terms) rules for a symbol.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class LotSizeFilter {
	/** The minimum quantity/icebergQty allowed. */
	private BigDecimal minQty;
	/** The maximum quantity/icebergQty allowed. */
	private BigDecimal maxQty;
	/**
	 * The intervals that a quantity/icebergQty can be increased/decreased by.
	 */
	private BigDecimal stepSize;
}
