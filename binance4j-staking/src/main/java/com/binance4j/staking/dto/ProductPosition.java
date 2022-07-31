package com.binance4j.staking.dto;

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
public record ProductPosition(String positionId, String productId, String asset, String amount, String purchaseTime, String duration, String accrualDays,
		String rewardAsset, String apy, String rewardAmt, String extraRewardAsset, String extraRewardAPY, String estExtraRewardAmt, String nextInterestPay,
		String nextInterestPayDate, String payInterestPeriod, String redeemAmountEarly, String interestEndDate, String deliverDate, String redeemPeriod,
		String redeemingAmt, String partialAmtDeliverDate, boolean canRedeemEarly, boolean renewable, String type, String status) {
}