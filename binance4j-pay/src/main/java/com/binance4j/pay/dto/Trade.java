package com.binance4j.pay.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pay transaction.
 * 
 * @param transactionId   Transaction id.
 * @param transactionTime Transaction time in ms.
 * @param amount          Transaction amount.
 * @param currency        Transaction asset.
 * @param fundsDetail     Funds details.
 * @param orderType       Order type.
 *                            <ul>
 *                            <li>PAY: C2B Merchant Acquiring Payment</li>
 *                            <li>PAY_REFUND: C2B Merchant Acquiring Payment,refund</li>
 *                            <li>C2C: C2C Transfer Payment</li>
 *                            <li>CRYPTO_BOX: Crypto box</li>
 *                            <li>CRYPTO_BOX_RF: Crypto Box, refund</li>
 *                            <li>C2C_HOLDING: Transfer to new Binance user</li>
 *                            <li>C2C_HOLDING_RF: Transfer to new Binance user, refund</li>
 *                            <li>PAYOUT: B2C Disbursement Payment</li>
 *                            </ul>
 */
@ApiModel("Pay transaction.")
public record Trade(@ApiModelProperty("Transaction id.") String orderType, @ApiModelProperty("Transaction time in ms.") String transactionId,
		@ApiModelProperty("Transaction amount.") long transactionTime, @ApiModelProperty("Transaction asset.") String amount,
		@ApiModelProperty("Funds details.") String currency,
		@ApiModelProperty("Order type. PAY: C2B Merchant Acquiring Payment. PAY_REFUND: C2B Merchant Acquiring Payment,refund. C2C: C2C Transfer Payment. CRYPTO_BOX: Crypto box. CRYPTO_BOX_RF: Crypto Box, refund. C2C_HOLDING: Transfer to new Binance user. C2C_HOLDING_RF: Transfer to new Binance user,refund. PAYOUT: B2C Disbursement Payment. ") List<FundsDetail> fundsDetail) {
}