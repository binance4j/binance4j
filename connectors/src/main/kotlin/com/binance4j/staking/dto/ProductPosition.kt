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

package com.binance4j.staking.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Product position.
 *
 * @property positionId            Staking position ID.
 * @property productId             Staking project ID.
 * @property asset                 Locked asset.
 * @property amount                Locked Amount.
 * @property purchaseTime          Subscription time.
 * @property duration              Lock period(days ).
 * @property accrualDays           Accrue days.
 * @property rewardAsset           Earned asset.
 * @property apy                   APY.
 * @property rewardAmt             Earned amount.
 * @property extraRewardAsset      Rewards assets of extra staking type.
 * @property extraRewardAPY        APY of extra staking type.
 * @property estExtraRewardAmt     Rewards of extra staking type, distribute when
 *                              order expires.
 * @property nextInterestPay       Next estimated interest payment.
 * @property nextInterestPayDate   Next interest payment date.
 * @property payInterestPeriod     Interest cycle.
 * @property redeemAmountEarly     Early redemption amount.
 * @property interestEndDate       Interest accrual end date.
 * @property deliverDate           Redemption arrival time.
 * @property redeemPeriod          Redemption interval.
 * @property redeemingAmt          Amount under redemption.
 * @property partialAmtDeliverDate Arrival time of partial redemption amount of
 *                              order.
 * @property canRedeemEarly        When it is true, early redemption can be
 *                              operated.
 * @property renewable             When it is true, auto staking can be operated.
 * @property type                  Order type is auto-staking or normal.
 * @property status                Position status.
 */
@ApiModel("Product position.")
data class ProductPosition(
	@ApiModelProperty("Staking position ID.")
	val positionId: String,
	@ApiModelProperty("Staking project ID.")
	val productId: String,
	@ApiModelProperty("Locked asset.")
	val asset: String,
	@ApiModelProperty("Locked Amount.")
	val amount: String,
	@ApiModelProperty("Subscription time.")
	val purchaseTime: String,
	@ApiModelProperty("Lock period(days ).")
	val duration: String,
	@ApiModelProperty("Accrue days.")
	val accrualDays: String,
	@ApiModelProperty("Earned asset.")
	val rewardAsset: String,
	@ApiModelProperty("APY.")
	val apy: String,
	@ApiModelProperty("Earned amount.")
	val rewardAmt: String,
	@ApiModelProperty("Rewards assets of extra staking type.")
	val extraRewardAsset: String,
	@ApiModelProperty("APY of extra staking type.")
	val extraRewardAPY: String,
	@ApiModelProperty("Rewards of extra staking type, distribute when order expires.")
	val estExtraRewardAmt: String,
	@ApiModelProperty("Next estimated interest payment.")
	val nextInterestPay: String,
	@ApiModelProperty("Next interest payment date.")
	val nextInterestPayDate: String,
	@ApiModelProperty("Interest cycle.")
	val payInterestPeriod: String,
	@ApiModelProperty("Early redemption amount.")
	val redeemAmountEarly: String,
	@ApiModelProperty("Interest accrual end date.")
	val interestEndDate: String,
	@ApiModelProperty("Redemption arrival time.")
	val deliverDate: String,
	@ApiModelProperty("Redemption interval.")
	val redeemPeriod: String,
	@ApiModelProperty("Amount under redemption.")
	val redeemingAmt: String,
	@ApiModelProperty("Arrival time of partial redemption amount of order.")
	val partialAmtDeliverDate: String,
	@ApiModelProperty("When it is true, early redemption can be operated.")
	val canRedeemEarly: Boolean,
	@ApiModelProperty("When it is true, auto staking can be operated.")
	val renewable: Boolean,
	@ApiModelProperty("Order type is auto-staking or normal.")
	val type: String,
	@ApiModelProperty("Position status.")
	val status: String
)