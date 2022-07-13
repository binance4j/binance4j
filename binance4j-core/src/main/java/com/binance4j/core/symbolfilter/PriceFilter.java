package com.binance4j.core.symbolfilter;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines the price rules for a symbol.
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class PriceFilter {
    /** The minimum price/stopPrice allowed. Disabled on minPrice == 0. */
    private BigDecimal minPrice;

    /** The maximum price/stopPrice allowed. Disabled on maxPrice == 0. */
    private BigDecimal maxPrice;

    /**
     * The intervals that a price/stopPrice can be increased/decreased by. Disabled
     * on tickSize == 0.
     */
    private BigDecimal tickSize;
}
