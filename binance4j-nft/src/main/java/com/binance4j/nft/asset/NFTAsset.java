package com.binance4j.nft.asset;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFTAsset {
	/**
	 * NFT Network
	 */
	private String network;
	/**
	 * NFT Contract Address
	 */
	private String contractAddress;
	/**
	 * NFT Token ID
	 */
	private String tokenId;
}
