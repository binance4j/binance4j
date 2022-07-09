package com.binance4j.core.symbolfilter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines the maximum number of orders an account is allowed to have open on a
 * symbol. Note that both "algo" orders and normal orders are counted for this
 * filter.
 * 
 * @see https://binance-docs.github.io/apidocs/spot/en/#filters
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class MaxNumOrdersFilter {
    /**
     * The max number of orders allowed
     */
    private Integer maxNumOrders;
}
