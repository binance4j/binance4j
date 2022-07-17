package com.binance4j.nft.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A NFT withdraw history */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NFTWithdrawHistory(
		/** total records. */
		Long total,
		/** The transactions. */
		List<NFTWithdraw> list) {
}
