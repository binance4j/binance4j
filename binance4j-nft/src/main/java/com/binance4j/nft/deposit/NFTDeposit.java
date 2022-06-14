package com.binance4j.nft.deposit;

import com.binance4j.nft.asset.NFTAsset;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A NFT Deposit */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class NFTDeposit extends NFTAsset {
    /** Transaction ID */
    @JsonProperty("txID")
    private String transactionId;
    /** Deposit time in ms */
    private Long timestamp;
}
