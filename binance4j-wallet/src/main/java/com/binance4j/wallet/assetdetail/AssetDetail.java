package com.binance4j.wallet.assetdetail;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** Details of a supported asset */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDetail {
    /**
     * The minimal withdraw amount
     */
    private BigDecimal minWithdrawAmount;
    /**
     * The deposit status (false if ALL of networks' are false)
     */
    private Boolean depositStatus;
    /**
     * The withdraw fee
     */
    private Float withdrawFee;
    /**
     * The withdraw status (false if ALL of networks' are false)
     */
    private Boolean withdrawStatus;
    /**
     * The reason of the status
     */
    private String depositTip;
}