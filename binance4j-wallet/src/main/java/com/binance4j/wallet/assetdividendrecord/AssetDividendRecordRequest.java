package com.binance4j.wallet.assetdividendrecord;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get a list of asset dividends */
@Data
@EqualsAndHashCode(callSuper = true)
public class AssetDividendRecordRequest extends IntervalRequest {
    /**
     * The asset abbreviation
     */
    private String asset;
    /**
     * The result limit. Default 20, max 500
     */
    private Integer limit = 20;

    /** Default constructor */
    public AssetDividendRecordRequest() {
        super(10);
    }

    /**
     * Constructor with asset
     * 
     * @param asset The asset we want the records
     */
    public AssetDividendRecordRequest(String asset) {
        this();
        this.asset = asset;
    }

    /**
     * Constructor with asset and limit
     * 
     * @param asset The asset we want the records
     */
    public AssetDividendRecordRequest(String asset, Integer limit) {
        this(asset);
        this.limit = limit;
    }
}
