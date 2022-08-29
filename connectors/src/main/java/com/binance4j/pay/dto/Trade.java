package com.binance4j.pay.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pay transaction.
 * 
 * @property transactionId   Transaction id.
 * @property transactionTime Transaction time in ms.
 * @property amount          Transaction amount.
 * @property currency        Transaction asset.
 * @property fundsDetail     Funds details.
 * @property orderType       Order type.
 *                        <ul>
 *                        <li>PAY: C2B Merchant Acquiring Payment</li>
 *                        <li>PAY_REFUND: C2B Merchant Acquiring
 *                        Payment,refund</li>
 *                        <li>C2C: C2C Transfer Payment</li>
 *                        <li>CRYPTO_BOX: Crypto box</li>
 *                        <li>CRYPTO_BOX_RF: Crypto Box, refund</li>
 *                        <li>C2C_HOLDING: Transfer to new Binance user</li>
 *                        <li>C2C_HOLDING_RF: Transfer to new Binance user,
 *                        refund</li>
 *                        <li>PAYOUT: B2C Disbursement Payment</li>
 *                        </ul>
 */
@ApiModel("Pay transaction.")
data class Trade(
@ApiModelProperty("Transaction id.")
@JsonProperty("orderType") var orderType: String = "",
@ApiModelProperty("Transaction time in ms.")
@JsonProperty("transactionId") var transactionId: String = "",
@ApiModelProperty("Transaction amount.")
@JsonProperty("transactionTime") var transactionTime: Long = 0L,
@ApiModelProperty("Transaction asset.")
@JsonProperty("amount") var amount: String = "",
@ApiModelProperty("Funds details.")
@JsonProperty("currency") var currency: String = "",
@ApiModelProperty("Order type. PAY: C2B Merchant Acquiring Payment. PAY_REFUND: C2B Merchant Acquiring Payment,refund. C2C: C2C Transfer Payment. CRYPTO_BOX: Crypto box. CRYPTO_BOX_RF: Crypto Box, refund. C2C_HOLDING: Transfer to new Binance user. C2C_HOLDING_RF: Transfer to new Binance user,refund. PAYOUT: B2C Disbursement Payment. ") List<FundsDetail> fundsDetail)
{
}