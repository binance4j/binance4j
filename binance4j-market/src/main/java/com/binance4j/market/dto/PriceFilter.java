package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The price rules for a symbol.
 * 
 * @param minPrice Minimum price/stopPrice allowed. Disabled on minPrice == 0.
 * @param maxPrice Maximum price/stopPrice allowed. Disabled on maxPrice == 0.
 * @param tickSize Intervals that a price/stopPrice can be increased/decreased by. Disabled on tickSize == 0.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The price rules for a symbol.")
public record PriceFilter(@ApiModelProperty("Minimum price/stopPrice allowed. Disabled on minPrice == 0.") String minPrice,
		@ApiModelProperty("Maximum price/stopPrice allowed. Disabled on maxPrice == 0.") String maxPrice,
		@ApiModelProperty("Intervals that a price/stopPrice can be increased/decreased by. Disabled on tickSize == 0.") String tickSize) {
}