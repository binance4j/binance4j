package com.binance4j.wallet.dto;

import java.util.List;

/**
 * Dribblets.
 * 
 * @param operateTime              The operation timestamp.
 * @param totalTransferedAmount    Total transfered BNB amount for this exchange.
 * @param totalServiceChargeAmount Total service charge amount for this exchange.
 * @param transId                  The transaction id.
 * @param userAssetDribbletDetails Details of this exchange.
 */
public record UserAssetDribblets(long operateTime, String totalTransferedAmount, String totalServiceChargeAmount, long transId,
		List<UserAssetDribbletDetails> userAssetDribbletDetails) {
}