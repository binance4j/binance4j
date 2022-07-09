package com.binance4j.core.symbolfilter;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines the minimum notional value allowed for an order on a symbol.
 * 
 * @see https://binance-docs.github.io/apidocs/spot/en/#filters
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class MinNotionalFilter {
    /**
     * The minimum notional value allowed for an order on a symbol. An
     * order's notional value is the price * quantity.
     */
    private BigDecimal minNotional;

    /**
     * Whether or not the filter is applied to MARKET orders
     */
    private Boolean applyToMarket;

    /**
     * The number of minutes the average price is calculated over. 0 means
     * the last price is used.
     */
    private Integer avgPriceMins;
}
