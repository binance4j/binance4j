/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.wallet.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The API key permissions.
 *
 * @property ipRestrict Is the key restricted to an ip address?
 * @property enableWithdrawals This option allows you to withdraw via API. You must apply the IP
 * Access Restriction filter in order to enable withdrawals.
 * @property enableInternalTransfer This option authorizes this key to transfer funds between your
 * master account and your sub account instantly.
 * @property permitsUniversalTransfer Authorizes this key to be used for a dedicated universal
 * transfer API to transfer multiple supported currencies. Each business's own transfer API rights
 * are not affected by this authorization.
 * @property enableVanillaOptions Authorizes this key to Vanilla options trading.
 * @property enableReading Does the key enables reading ?
 * @property enableFutures API Key created before your futures account opened does not support
 * futures API service.
 * @property enableMargin This option can be adjusted after the Cross Margin account transfer is
 * completed.
 * @property enableSpotAndMarginTrading Spot and margin trading.
 * @property createTime API key creation timestamp.
 * @property tradingAuthorityExpirationTime Expiration time for spot and margin trading permission.
 */
@ApiModel("The API key permissions.")
data class ApiPermissions(
	@ApiModelProperty("Is the key restricted to an ip address?")
	var ipRestrict: Boolean,
	@ApiModelProperty(
		"This option allows you to withdraw via API. You must apply the IP Access Restriction filter in order to enable withdrawals"
	)
	var enableWithdrawals: Boolean,
	@ApiModelProperty(
		"This option authorizes this key to transfer funds between your master account and your sub account instantly."
	)
	var enableInternalTransfer: Boolean,
	@ApiModelProperty(
		"Authorizes this key to be used for a dedicated universal transfer API to transfer multiple supported currencies. Each business's own transfer API rights are not affected by this authorization."
	)
	var permitsUniversalTransfer: Boolean,
	@ApiModelProperty("Authorizes this key to Vanilla options trading.")
	var enableVanillaOptions: Boolean,
	@ApiModelProperty("Does the key enables reading ?")
	var enableReading: Boolean,
	@ApiModelProperty(
		"API Key created before your futures account opened does not support futures API service."
	)
	var enableFutures: Boolean,
	@ApiModelProperty(
		"This option can be adjusted after the Cross Margin account transfer is completed."
	)
	var enableMargin: Boolean,
	@ApiModelProperty("Spot and margin trading.")
	var enableSpotAndMarginTrading: Boolean,
	@ApiModelProperty("API key creation timestamp.")
	var createTime: Long,
	@ApiModelProperty("Expiration time for spot and margin trading permission.")
	var tradingAuthorityExpirationTime: Long,
)
