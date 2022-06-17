package com.binance4j.margin.asset;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginAssetRequest extends Request {
    private String asset;

    public MarginAssetRequest(String asset) {
        super(10);
        this.asset = asset;
    }
}