package com.binance4j.core.symbolfilter;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines the allowed maximum position an account can have on the base asset of
 * a symbol.
 * 
 * @see https://binance-docs.github.io/apidocs/spot/en/#filters
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class TrailingDeltaFilter {
    // TODO javadoc
    private BigDecimal minTrailingAboveDelta;
    // TODO javadoc
    private BigDecimal maxTrailingAboveDelta;
    // TODO javadoc
    private BigDecimal minTrailingBelowDelta;
    // TODO javadoc
    private BigDecimal maxTrailingBelowDelta;
}
