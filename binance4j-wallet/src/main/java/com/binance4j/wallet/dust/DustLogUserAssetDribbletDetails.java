package com.binance4j.wallet.dust;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** Dust log details */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustLogUserAssetDribbletDetails {
    /**
     * The transaction id
     */
    private Long transId;
    /**
     * The timestamp
     */
    private Long operateTime;
    /**
     * The fees
     */
    private BigDecimal serviceChargeAmount;
    /**
     * The volume
     */
    private BigDecimal amount;
    /**
     * The transfered amount
     * 
     * 
     */
    private BigDecimal transferedAmount;
    /**
     * The transfered asset
     */
    private String fromAsset;
}