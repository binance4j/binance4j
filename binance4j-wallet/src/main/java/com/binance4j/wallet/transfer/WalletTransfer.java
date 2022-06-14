package com.binance4j.wallet.transfer;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** A wallet to wallet transfer */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletTransfer {
    /**
     * The transfered asset
     */
    private String asset;
    /**
     * The transfered amount
     */
    private BigDecimal amount;
    /**
     * The transfer type (origin wallet to destination wallet)
     */
    private WalletTransferType type;
    /**
     * The transfer status
     */
    private String status;
    /**
     * The transaction id
     */
    private Long tranId;
    /**
     * The transfer timestamp
     */
    private Long timestamp;
}
