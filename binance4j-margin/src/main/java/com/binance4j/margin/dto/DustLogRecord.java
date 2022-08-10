package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.margin.dto.DustLogRecord.UserAssetDribblet;
import com.binance4j.margin.dto.DustLogRecord.UserAssetDribblet.UserAssetDribbletDetail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A record of asset conversions to BNB.
 * 
 * @param total              Result count.
 * @param userAssetDribblets Transfers.
 */
@ApiModel("A record of asset conversions to BNB.")
public record DustLogRecord(@ApiModelProperty("Result count.") int total,
		@ApiModelProperty("Transfers.") List<UserAssetDribblet> userAssetDribblets) {
	/**
	 * @param operateTime              Operate time.
	 * @param totalTransferedAmount    Total transfered BNB amount for this
	 *                                 exchange.
	 * @param totalServiceChargeAmount Total service charge amount for this
	 *                                 exchange.
	 * @param transId                  Transaction id.
	 * @param userAssetDribbletDetails Transfer details.
	 */
	record UserAssetDribblet(@ApiModelProperty("Operate time.") long operateTime,
			@ApiModelProperty("Total transfered BNB amount for this exchange.") String totalTransferedAmount,
			@ApiModelProperty("Total service charge amount for this exchange.") String totalServiceChargeAmount,
			@ApiModelProperty("Transaction id.") long transId,
			@ApiModelProperty("Transfer details.") List<UserAssetDribbletDetail> userAssetDribbletDetails) {
		/**
		 * @param transId             Transaction id.
		 * @param serviceChargeAmount Fees.
		 * @param amount              Converted BNB amount.
		 * @param operateTime         Operate time in ms.
		 * @param transferedAmount    Asset amount.
		 * @param fromAsset           Asset transfered.
		 */
		record UserAssetDribbletDetail(@ApiModelProperty("Transaction id.") long transId,
				@ApiModelProperty("Fees.") String serviceChargeAmount,
				@ApiModelProperty("Converted BNB amount.") String amount,
				@ApiModelProperty("Operate time in ms.") long operateTime,
				@ApiModelProperty("Asset amount.") String transferedAmount,
				@ApiModelProperty("Asset transfered.") String fromAsset) {
		}
	}
}
