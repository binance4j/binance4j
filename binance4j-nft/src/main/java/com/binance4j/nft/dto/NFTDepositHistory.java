package com.binance4j.nft.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A NFT deposit history */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NFTDepositHistory(
		/** total records. */
		Long total,
		/** The transactions. */
		List<NFTDeposit> list) {
}
