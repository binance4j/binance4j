package com.binance4j.wallet.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The SPOT account snapshot data.
 * 
 * @param balances        The wallet asset balances.
 * @param totalAssetOfBtc The cumulated value of the wallet in Bitcoin.
 */
@ApiModel("")
public record SpotAccountSnapshotData(@ApiModelProperty("") List<AssetBalance> balances, @ApiModelProperty("") String totalAssetOfBtc) {
}