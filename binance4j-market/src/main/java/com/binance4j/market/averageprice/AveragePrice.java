package com.binance4j.market.averageprice;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** Current average price for a symbol. */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AveragePrice {
    /**
     * ???
     */
    private Integer mins;
    /**
     * The average price of the asset
     */
    private BigDecimal price;
}
