package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.margin.dto.DustLogRecord.UserAssetDribblet;
import com.binance4j.margin.dto.DustLogRecord.UserAssetDribblet.UserAssetDribbletDetail;

/**
 * A record of asset conversions to BNB.
 * 
 * @param total              Result count.
 * @param userAssetDribblets Transfers.
 */
public record DustLogRecord(int total, List<UserAssetDribblet> userAssetDribblets) {
	/**
	 * @param operateTime
	 * @param totalTransferedAmount    Total transfered BNB amount for this exchange.
	 * @param totalServiceChargeAmount Total service charge amount for this exchange.
	 * @param transId                  Transaction id.
	 * @param userAssetDribbletDetails Transfer details.
	 */
	record UserAssetDribblet(long operateTime, String totalTransferedAmount, String totalServiceChargeAmount, long transId,
			List<UserAssetDribbletDetail> userAssetDribbletDetails) {
		/**
		 * @param transId             Transaction id.
		 * @param serviceChargeAmount Fees.
		 * @param amount              Converted BNB amount.
		 * @param operateTime         Operate time in ms.
		 * @param transferedAmount    Asset amount.
		 * @param fromAsset           Asset transfered.
		 */
		record UserAssetDribbletDetail(long transId, String serviceChargeAmount, String amount, long operateTime, String transferedAmount, String fromAsset) {
		}
	}
}
