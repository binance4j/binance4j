package com.binance4j.wallet.dto;

import java.util.List;

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
public record CoinInformation(String coin, String name, boolean depositAllEnable, boolean isLegalMoney, boolean trading, boolean withdrawAllEnable, String free,
		String freeze, String ipoable, String ipoing, String locked, String storage, String withdrawing, List<CoinNetworkInformation> networkList) {
}
