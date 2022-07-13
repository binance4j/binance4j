package com.binance4j.core.symbolfilter;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines the valid range for the price based on the lastPrice of the symbol.
 * There is a different range depending on whether the order is placed on the
 * BUY side or the SELL side.
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class PercentPriceBySideFilter {
    /** Bid multiplier up */
    private BigDecimal bidMultiplierUp;

    /** Bid multiplier down */
    private BigDecimal bidMultiplierDown;

    /** Ask multiplier up */
    private BigDecimal askMultiplierUp;

    /** Ask multiplier down */
    private BigDecimal askMultiplierDown;

    /** Weighted average price */
    private BigDecimal avgPriceMins;

}
