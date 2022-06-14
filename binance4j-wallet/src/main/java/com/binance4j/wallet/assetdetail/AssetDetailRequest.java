package com.binance4j.wallet.assetdetail;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get details about a supported asset */
@Data
@EqualsAndHashCode(callSuper = true)
public class AssetDetailRequest extends FramedRequest {
    /**
     * The asset abbreviation
     */
    private String asset;

    /** Default constructor */
    public AssetDetailRequest() {
        super(1);
    }

    /**
     * Constructor
     * 
     * @param asset the asset we want the details
     */
    public AssetDetailRequest(String asset) {
        this();
        this.asset = asset;
    }
}
