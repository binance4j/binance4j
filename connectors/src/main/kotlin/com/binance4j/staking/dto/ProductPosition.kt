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
 * @property deliverDate           Redemption arrivar time.
 * @property redeemPeriod          Redemption interval.
 * @property redeemingAmt          Amount under redemption.
 * @property partialAmtDeliverDate Arrivar time of partial redemption amount of
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
	var positionId: String,
	@ApiModelProperty("Staking project ID.")
	var productId: String,
	@ApiModelProperty("Locked asset.")
	var asset: String,
	@ApiModelProperty("Locked Amount.")
	var amount: String,
	@ApiModelProperty("Subscription time.")
	var purchaseTime: String,
	@ApiModelProperty("Lock period(days ).")
	var duration: String,
	@ApiModelProperty("Accrue days.")
	var accrualDays: String,
	@ApiModelProperty("Earned asset.")
	var rewardAsset: String,
	@ApiModelProperty("APY.")
	var apy: String,
	@ApiModelProperty("Earned amount.")
	var rewardAmt: String,
	@ApiModelProperty("Rewards assets of extra staking type.")
	var extraRewardAsset: String,
	@ApiModelProperty("APY of extra staking type.")
	var extraRewardAPY: String,
	@ApiModelProperty("Rewards of extra staking type, distribute when order expires.")
	var estExtraRewardAmt: String,
	@ApiModelProperty("Next estimated interest payment.")
	var nextInterestPay: String,
	@ApiModelProperty("Next interest payment date.")
	var nextInterestPayDate: String,
	@ApiModelProperty("Interest cycle.")
	var payInterestPeriod: String,
	@ApiModelProperty("Early redemption amount.")
	var redeemAmountEarly: String,
	@ApiModelProperty("Interest accrual end date.")
	var interestEndDate: String,
	@ApiModelProperty("Redemption arrivar time.")
	var deliverDate: String,
	@ApiModelProperty("Redemption interval.")
	var redeemPeriod: String,
	@ApiModelProperty("Amount under redemption.")
	var redeemingAmt: String,
	@ApiModelProperty("Arrivar time of partial redemption amount of order.")
	var partialAmtDeliverDate: String,
	@ApiModelProperty("When it is true, early redemption can be operated.")
	var canRedeemEarly: Boolean,
	@ApiModelProperty("When it is true, auto staking can be operated.")
	var renewable: Boolean,
	@ApiModelProperty("Order type is auto-staking or normal.")
	var type: String,
	@ApiModelProperty("Position status.")
	var status: String
)