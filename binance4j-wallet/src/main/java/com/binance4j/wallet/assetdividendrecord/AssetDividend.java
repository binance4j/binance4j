package com.binance4j.wallet.assetdividendrecord;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** An asset divident */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDividend {
    /**
     * The divident amount
     */
    private BigDecimal amount;
    /**
     * ???
     */
    private String enInfo;
    /**
     * The asset abbreviation
     */
    private String asset;
    /**
     * The id
     */
    private Long id;
    /**
     * ???
     */
    private Long divTime;
    /**
     * The transaction id
     */
    private Long tranId;
}