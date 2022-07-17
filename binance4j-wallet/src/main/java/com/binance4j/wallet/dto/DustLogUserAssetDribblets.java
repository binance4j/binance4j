package com.binance4j.wallet.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DustLogUserAssetDribblets(
		/** The operation timestamp. */
		Long operateTime,
		/** The volume of asset converted. */
		BigDecimal totalTransferedAmount,
		/** The fees. */
		BigDecimal totalServiceChargeAmount,
		/** The transaction id. */
		Long transId,
		/** TODO JAVADOC */
		List<DustLogUserAssetDribbletDetails> userAssetDribbletDetails) {
}