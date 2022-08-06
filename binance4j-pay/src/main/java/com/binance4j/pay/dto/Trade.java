package com.binance4j.pay.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A pay transaction.
 * 
 * @param transactionId   Transaction id.
 * @param transactionTime Transaction time in ms.
 * @param amount          Transaction amount.
 * @param currency        Transaction asset.
 * @param fundsDetail     Funds details.
 * @param orderType       Order type
 *                            <ul>
 *                            <li>PAY: C2B Merchant Acquiring Payment</li>
 *                            <li>PAY_REFUND: C2B Merchant Acquiring Payment,@ApiModelProperty("")refund</li>
 *                            <li>C2C: C2C Transfer Payment</li>
 *                            <li>CRYPTO_BOX: Crypto box</li>
 *                            <li>CRYPTO_BOX_RF: Crypto Box,@ApiModelProperty("") refund</li>
 *                            <li>C2C_HOLDING: Transfer to new Binance user</li>
 *                            <li>C2C_HOLDING_RF: Transfer to new Binance user,@ApiModelProperty("")refund</li>
 *                            <li>PAYOUT: B2C Disbursement Payment</li>
 *                            </ul>
 */
@ApiModel("")
public record Trade(@ApiModelProperty("")
/**
 * Order type.
 * <ul>
 * <li>PAY: C2B Merchant Acquiring Payment</li>
 * <li>PAY_REFUND: C2B Merchant Acquiring Payment,@ApiModelProperty("")refund</li>
 * <li>C2C: C2C Transfer Payment</li>
 * <li>CRYPTO_BOX: Crypto box</li>
 * <li>CRYPTO_BOX_RF: Crypto Box,@ApiModelProperty("") refund</li>
 * <li>C2C_HOLDING: Transfer to new Binance user</li>
 * <li>C2C_HOLDING_RF: Transfer to new Binance user,@ApiModelProperty("")refund</li>
 * <li>PAYOUT: B2C Disbursement Payment</li>
 * </ul>
 */
String orderType, @ApiModelProperty("") String transactionId, @ApiModelProperty("") long transactionTime, @ApiModelProperty("") String amount,
		@ApiModelProperty("") String currency, @ApiModelProperty("") List<FundsDetail> fundsDetail) {
}