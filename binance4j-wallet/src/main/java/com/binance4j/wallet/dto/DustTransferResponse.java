package com.binance4j.wallet.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The dust transfer (asset to BNB) response. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DustTransferResponse(
		/** The fees. */
		BigDecimal totalServiceCharge,
		/** The volume converted into BNB after fees. */
		BigDecimal totalTransfered,
		/** Detailed transfer result asset by asset. */
		List<DustTransferResult> transferResult) {
}