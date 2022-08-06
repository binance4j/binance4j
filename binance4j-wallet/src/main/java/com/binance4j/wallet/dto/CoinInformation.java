package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The coin infos for the authenticated account.
 * 
 * @param coin              The coin abbreviation.
 * @param name              The coin name.
 * @param depositAllEnable  The deposit permission.
 * @param isLegalMoney      if the coin is a legal money.
 * @param trading           if the coin can be traded.
 * @param withdrawAllEnable The withdraw permission.
 * @param free              The free balance.
 * @param freeze            The freezed balance.
 * @param ipoable           The Initial Public Offering balance (?)
 * @param ipoing            The Initial Public Offering freezed balance (?)
 * @param locked            The locked balance.
 * @param storage           The storage
 * @param withdrawing       The withdrawing balance.
 * @param networkList       The coin network information.
 */
@ApiModel("")
public record CoinInformation(@ApiModelProperty("") String coin, @ApiModelProperty("") String name, @ApiModelProperty("") boolean depositAllEnable,
		@ApiModelProperty("") boolean isLegalMoney, @ApiModelProperty("") boolean trading, @ApiModelProperty("") boolean withdrawAllEnable,
		@ApiModelProperty("") String free, @ApiModelProperty("") String freeze, @ApiModelProperty("") String ipoable, @ApiModelProperty("") String ipoing,
		@ApiModelProperty("") String locked, @ApiModelProperty("") String storage, @ApiModelProperty("") String withdrawing,
		@ApiModelProperty("") List<CoinNetworkInformation> networkList) {
}
