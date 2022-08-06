package com.binance4j.websocket.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Net asset value.
 * 
 * @param eventType    Event type.
 * @param eventTime    Event time.
 * @param name         Name.
 * @param tokensIssued Tokens issued.
 * @param baskets      BVLT basket.
 * @param nav          Nav.
 * @param realLeverage Real leverage.
 * @param leverage     Leverage.
 * @param fundingRatio Funding ratio.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Net asset value.")
public record BLVT(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType, @ApiModelProperty("Event time.") @JsonProperty("E") long eventTime,
		@ApiModelProperty("Name.") @JsonProperty("s") String name, @ApiModelProperty("Tokens issued.") @JsonProperty("m") String tokensIssued,
		@ApiModelProperty("BVLT basket.") @JsonProperty("b") List<BLVTBasket> baskets, @ApiModelProperty("Nav.") @JsonProperty("n") String nav,
		@ApiModelProperty("Real leverage.") @JsonProperty("l") String realLeverage, @ApiModelProperty("Leverage.") @JsonProperty("t") int leverage,
		@ApiModelProperty("Funding ratio.") @JsonProperty("f") String fundingRatio) {
}