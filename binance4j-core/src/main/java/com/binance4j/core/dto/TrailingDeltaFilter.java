package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines the minimum and maximum value for the parameter trailingDelta.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class TrailingDeltaFilter {
	/** The min trailing above delta. */
	private BigDecimal minTrailingAboveDelta;
	/** The max trailing above delta. */
	private BigDecimal maxTrailingAboveDelta;
	/** The min trailing below delta. */
	private BigDecimal minTrailingBelowDelta;
	/** The max trailing below delta. */
	private BigDecimal maxTrailingBelowDelta;
}
