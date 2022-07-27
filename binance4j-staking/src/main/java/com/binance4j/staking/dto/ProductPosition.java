package com.binance4j.staking.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @param positionId            Staking position ID.
 * @param productId             Staking project ID.
 * @param asset                 Locked asset.
 * @param amount                Locked Amount.
 * @param purchaseTime          Subscription time.
 * @param duration              Lock period(days ).
 * @param accrualDays           Accrue days.
 * @param rewardAsset           Earned asset.
 * @param apy                   APY.
 * @param rewardAmt             Earned amount.
 * @param extraRewardAsset      Rewards assets of extra staking type.
 * @param extraRewardAPY        APY of extra staking type.
 * @param estExtraRewardAmt     Rewards of extra staking type, distribute when order expires.
 * @param nextInterestPay       Next estimated interest payment.
 * @param nextInterestPayDate   Next interest payment date.
 * @param payInterestPeriod     Interest cycle.
 * @param redeemAmountEarly     Early redemption amount.
 * @param interestEndDate       Interest accrual end date.
 * @param deliverDate           Redemption arrival time.
 * @param redeemPeriod          Redemption interval.
 * @param redeemingAmt          Amount under redemption.
 * @param partialAmtDeliverDate Arrival time of partial redemption amount of order.
 * @param canRedeemEarly        When it is true, early redemption can be operated.
 * @param renewable             When it is true, auto staking can be operated.
 * @param type                  Order type is auto-staking or normal.
 * @param status                Position status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductPosition(
		/** Staking position ID. */
		String positionId,
		/** Staking project ID. */
		String productId,
		/** Locked asset. */
		String asset,
		/** Locked Amount. */
		String amount,
		/** Subscription time. */
		String purchaseTime,
		/** Lock period(days ). */
		String duration,
		/** Accrue days. */
		String accrualDays,
		/** Earned asset. */
		String rewardAsset,
		/** APY. */
		String apy,
		/** Earned amount. */
		String rewardAmt,
		/** Rewards assets of extra staking type. */
		String extraRewardAsset,
		/** APY of extra staking type. */
		String extraRewardAPY,
		/** Rewards of extra staking type, distribute when order expires. */
		String estExtraRewardAmt,
		/** Next estimated interest payment. */
		String nextInterestPay,
		/** Next interest payment date. */
		String nextInterestPayDate,
		/** Interest cycle. */
		String payInterestPeriod,
		/** Early redemption amount. */
		String redeemAmountEarly,
		/** Interest accrual end date. */
		String interestEndDate,
		/** Redemption arrival time. */
		String deliverDate,
		/** Redemption interval. */
		String redeemPeriod,
		/** Amount under redemption. */
		String redeemingAmt,
		/** Arrival time of partial redemption amount of order. */
		String partialAmtDeliverDate,
		/** When it is true, early redemption can be operated. */
		boolean canRedeemEarly,
		/** When it is true, auto staking can be operated. */
		boolean renewable,
		/** Order type is auto-staking or normal. */
		String type,
		/** Position status. */
		String status) {
}