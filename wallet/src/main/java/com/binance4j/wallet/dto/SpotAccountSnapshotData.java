package com.binance4j.wallet.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The SPOT account snapshot data.
 * 
 * @param balances        Wallet asset balances.
 * @param totalAssetOfBtc Cumulated value of the wallet in Bitcoin.
 */
@ApiModel("The SPOT account snapshot data.")
public record SpotAccountSnapshotData(@ApiModelProperty("Wallet asset balances.") List<AssetBalance> balances,
		@ApiModelProperty("Cumulated value of the wallet in Bitcoin.") String totalAssetOfBtc) {
}