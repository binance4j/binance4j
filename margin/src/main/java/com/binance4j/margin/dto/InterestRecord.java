package com.binance4j.margin.dto;

import java.util.Optional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Interest record in a {@link InterestHistory}.
 * 
 * @property isolatedSymbol      Isolated symbol. Will not be returned for crossed
 *                            margin.
 * @property asset               Related asset.
 * @property rawAsset            Related raw asset. Will not be returned for
 *                            isolated margin.
 * @property interest            Interest.
 * @property interestAccuredTime Interest accrued (?) time.
 * @property interestRate        Interest rate.
 * @property principal           Borrowed quantity (?).
 * @property type                Interest type.
 * @see InterestType
 */
@ApiModel("Interest record in a InterestHistory.")
data class InterestRecord(
		@ApiModelProperty("Isolated symbol. Will not be returned for crossed margin.") Optional<String> isolatedSymbol,
		@ApiModelProperty("Related asset.") var asset : String? = null,
		@ApiModelProperty("Related raw asset. Will not be returned for isolated margin.") Optional<String> rawAsset,
		@ApiModelProperty("Interest.") var interest : String? = null,
		@ApiModelProperty("Interest accrued (?) time.") long interestAccuredTime,
		@ApiModelProperty("Interest rate.") var interestRate : String? = null,
		@ApiModelProperty("Borrowed quantity (?).") String principal,
		@ApiModelProperty("Interest type.") var type : String? = null) {
}