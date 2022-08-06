package com.binance4j.margin.dto;

import java.util.Optional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Interest record in a {@link InterestHistory}.
 * 
 * @param isolatedSymbol      Isolated symbol. Will not be returned for crossed margin.
 * @param asset               Related asset.
 * @param rawAsset            Related raw asset. Will not be returned for isolated margin.
 * @param interest            Interest.
 * @param interestAccuredTime Interest accrued (?) time.
 * @param interestRate        Interest rate.
 * @param principal           Borrowed quantity (?).
 * @param type                Interest type.
 * @see InterestType
 */
@ApiModel("Interest record in a InterestHistory.")
public record InterestRecord(@ApiModelProperty("Isolated symbol. Will not be returned for crossed margin.") Optional<String> isolatedSymbol,
		@ApiModelProperty("Related asset.") String asset,
		@ApiModelProperty("Related raw asset. Will not be returned for isolated margin.") Optional<String> rawAsset,
		@ApiModelProperty("Interest.") String interest, @ApiModelProperty("Interest accrued (?) time.") long interestAccuredTime,
		@ApiModelProperty("Interest rate.") String interestRate, @ApiModelProperty("Borrowed quantity (?).") String principal,
		@ApiModelProperty("Interest type.") String type) {
}