package com.binance4j.wallet.transfer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The transfers wrapper */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletTransferHistory {
    /**
     * The list of transfers
     */
    private List<WalletTransfer> rows;
    /**
     * The result size
     */
    private Long total;
}