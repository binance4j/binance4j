package com.binance4j.nft.asset;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * A NFT withdraw history
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFTAssetHistory {
	/**
	 * total records
	 */
	private Long total;
	/**
	 * THe transactions
	 */
	private List<NFTAsset> list;
}
