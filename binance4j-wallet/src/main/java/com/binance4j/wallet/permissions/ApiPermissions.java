package com.binance4j.wallet.permissions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The API key permissions */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiPermissions {
    /**
     * is the key restricted to an ip address?
     */
    private Boolean ipRestrict;
    /**
     * This option allows you to withdraw via API. You must apply the IP
     * Access Restriction filter in order to enable withdrawals
     * 
     * 
     */
    private Boolean enableWithdrawals;
    /**
     * This option authorizes this key to transfer funds between your master
     * account and your sub account instantly
     * 
     * 
     */
    private Boolean enableInternalTransfer;
    /**
     * Authorizes this key to be used for a dedicated universal transfer API
     * to transfer multiple supported currencies. Each business's own
     * transfer API rights are not affected by this authorization
     * 
     * 
     */
    private Boolean permitsUniversalTransfer;
    /**
     * Authorizes this key to Vanilla options trading
     */
    private Boolean enableVanillaOptions;
    /**
     * Does the key enables reading ?
     */
    private Boolean enableReading;
    /**
     * API Key created before your futures account opened does not support
     * futures API service
     * 
     * 
     */
    private Boolean enableFutures;
    /**
     * This option can be adjusted after the Cross Margin account transfer
     * is completed
     * 
     * 
     */
    private Boolean enableMargin;
    /**
     * Spot and margin trading
     */
    private Boolean enableSpotAndMarginTrading;
    /**
     * The API key creation timestamp
     */
    private Long createTime;
    /**
     * Expiration time for spot and margin trading permission
     */
    private Long tradingAuthorityExpirationTime;
}