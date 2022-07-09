package com.binance4j.core.symbolfilter;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines valid range for a price based on the average of the previous trades.
 * avgPriceMins is the number of minutes the average price is calculated over. 0
 * means the last price is used.
 * 
 * @see https://binance-docs.github.io/apidocs/spot/en/#filters
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class PercentPriceFilter {
    /** Multiplier up */
    private BigDecimal multiplierUp;

    /** Multiplier down */
    private BigDecimal multiplierDown;

    /** Weighted average price */
    private BigDecimal avgPriceMins;

}
