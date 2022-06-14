package com.binance4j.wallet.snapshot.futures;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The snapshot assets balances */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesSnapshotDataAssets {
    /**
     * The asset abbreviation
     */
    private String asset;
    /**
     * The margin balance
     */
    private BigDecimal marginBalance;
    /**
     * The wallet balance
     */
    private BigDecimal walletBalance;
}