package com.binance4j.margin.asset;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginAssetParams extends Params {
    private String asset;

    public MarginAssetParams(String asset) {
        super(10);
        this.asset = asset;
    }
}