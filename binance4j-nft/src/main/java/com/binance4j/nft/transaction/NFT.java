package com.binance4j.nft.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFT {
    /** NFT Network */
    private String network;
    /** NFT Token ID */
    private String tokenId;
    /** NFT Contract Address */
    private String contractAddress;
}
