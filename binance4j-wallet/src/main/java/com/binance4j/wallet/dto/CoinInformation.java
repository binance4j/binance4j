package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The coin infos for the authenticated account.
 * 
 * @param coin              Coin abbreviation.
 * @param name              Coin name.
 * @param depositAllEnable  Deposit permission.
 * @param isLegalMoney      Is the coin a legal money?
 * @param trading           Can the coin be traded?
 * @param withdrawAllEnable Withdraw permission.
 * @param free              Free balance.
 * @param freeze            Freezed balance.
 * @param ipoable           Initial Public Offering balance (?)
 * @param ipoing            Initial Public Offering freezed balance (?)
 * @param locked            Locked balance.
 * @param storage           Storage
 * @param withdrawing       Withdrawing balance.
 * @param networkList       Coin network information.
 */
@ApiModel("The coin infos for the authenticated account.")
public record CoinInformation(@ApiModelProperty("Coin abbreviation.") String coin, @ApiModelProperty("Coin name.") String name,
		@ApiModelProperty("Deposit permission.") boolean depositAllEnable, @ApiModelProperty("Is the coin a legal money?") boolean isLegalMoney,
		@ApiModelProperty("Can the coin be traded?") boolean trading, @ApiModelProperty("Withdraw permission.") boolean withdrawAllEnable,
		@ApiModelProperty("Free balance.") String free, @ApiModelProperty("Freezed balance.") String freeze,
		@ApiModelProperty("Initial Public Offering balance (?)") String ipoable, @ApiModelProperty("Initial Public Offering freezed balance (?)") String ipoing,
		@ApiModelProperty("Locked balance.") String locked, @ApiModelProperty("Storage") String storage,
		@ApiModelProperty("Withdrawing balance.") String withdrawing, @ApiModelProperty("Coin network information.") List<CoinNetworkInformation> networkList) {
}
