package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Product position.
 * 
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
@ApiModel("Product position.")
public record ProductPosition(@ApiModelProperty("Staking position ID.") String positionId, @ApiModelProperty("Staking project ID.") String productId,
		@ApiModelProperty("Locked asset.") String asset, @ApiModelProperty("Locked Amount.") String amount,
		@ApiModelProperty("Subscription time.") String purchaseTime, @ApiModelProperty("Lock period(days ).") String duration,
		@ApiModelProperty("Accrue days.") String accrualDays, @ApiModelProperty("Earned asset.") String rewardAsset, @ApiModelProperty("APY.") String apy,
		@ApiModelProperty("Earned amount.") String rewardAmt, @ApiModelProperty("Rewards assets of extra staking type.") String extraRewardAsset,
		@ApiModelProperty("APY of extra staking type.") String extraRewardAPY,
		@ApiModelProperty("Rewards of extra staking type, distribute when order expires.") String estExtraRewardAmt,
		@ApiModelProperty("Next estimated interest payment.") String nextInterestPay,
		@ApiModelProperty("Next interest payment date.") String nextInterestPayDate, @ApiModelProperty("Interest cycle.") String payInterestPeriod,
		@ApiModelProperty("Early redemption amount.") String redeemAmountEarly, @ApiModelProperty("Interest accrual end date.") String interestEndDate,
		@ApiModelProperty("Redemption arrival time.") String deliverDate, @ApiModelProperty("Redemption interval.") String redeemPeriod,
		@ApiModelProperty("Amount under redemption.") String redeemingAmt,
		@ApiModelProperty("Arrival time of partial redemption amount of order.") String partialAmtDeliverDate,
		@ApiModelProperty("When it is true, early redemption can be operated.") boolean canRedeemEarly,
		@ApiModelProperty("When it is true, auto staking can be operated.") boolean renewable,
		@ApiModelProperty("Order type is auto-staking or normal.") String type, @ApiModelProperty("Position status.") String status) {
}