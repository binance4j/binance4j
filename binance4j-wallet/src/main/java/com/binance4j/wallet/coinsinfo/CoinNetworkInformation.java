package com.binance4j.wallet.coinsinfo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * The coin network informations
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinNetworkInformation {
    /**
     * The address pattern
     */
    private String addressRegex;
    /**
     * ?
     */
    private String addressRule;
    /**
     * The coin abbreviation
     */
    private String coin;
    /**
     * The deposit description
     */
    private String depositDesc;
    /**
     * The withdra description
     */
    private String withdrawDesc;
    /**
     * The network name
     */
    private String name;
    /**
     * The memo pattern
     */
    private String memoRegex;
    /**
     * ?
     */
    private String network;
    /**
     * Tips about the network
     */
    private String specialTips;
    /**
     * Tips about the withdraw
     */
    private String specialWithdrawTips;
    /**
     * ?
     */
    private BigDecimal depositDust;
    /**
     * The withdraw fee
     */
    private BigDecimal withdrawFee;
    /**
     * ?
     */
    private BigDecimal withdrawIntegerMultiple;
    /**
     * The maximal amount authorized to be withdrawn
     */
    private BigDecimal withdrawMax;
    /**
     * The minimal amount authorized to be withdrawn
     */
    private BigDecimal withdrawMin;
    /**
     * The min number for balance confirmation
     */
    private int minConfirm;
    /**
     * The confirmation number for balance unlock
     */
    private int unLockConfirm;
    /**
     * If deposit is enabled
     */
    private Boolean depositEnable;
    /**
     * if is the default network
     */
    private Boolean isDefault;
    /**
     * ?
     */
    private Boolean resetAddressStatus;
    /**
     * If withdraw is enabled
     */
    private Boolean withdrawEnable;
    /**
     * If the coin needs to provide memo to withdraw
     */
    private Boolean sameAddress;
}