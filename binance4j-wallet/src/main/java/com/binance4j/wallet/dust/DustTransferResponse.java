package com.binance4j.wallet.dust;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The dust transfer (asset to BNB) response */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustTransferResponse {
	/**
	 * The fees
	 */
	private BigDecimal totalServiceCharge;
	/**
	 * The volume converted into BNB after fees
	 */
	private BigDecimal totalTransfered;
	/**
	 * Detailed transfer result asset by asset
	 */
	private List<DustTransferResult> transferResult;
}