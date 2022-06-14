package com.binance4j.wallet.dust;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustLogUserAssetDribblets {
    /**
     * The operation timestamp
     */
    private Long operateTime;
    /**
     * The volume of asset converted
     */
    private BigDecimal totalTransferedAmount;
    /**
     * The fees
     */
    private BigDecimal totalServiceChargeAmount;
    /**
     * The transaction id
     */
    private Long transId;
    /**
     * ???
     */
    private List<DustLogUserAssetDribbletDetails> userAssetDribbletDetails;
}