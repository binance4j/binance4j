package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
 * @param estExtraRewardAmt     Rewards of extra staking type,@ApiModelProperty("") distribute when order expires.
 * @param nextInterestPay       Next estimated interest payment.
 * @param nextInterestPayDate   Next interest payment date.
 * @param payInterestPeriod     Interest cycle.
 * @param redeemAmountEarly     Early redemption amount.
 * @param interestEndDate       Interest accrual end date.
 * @param deliverDate           Redemption arrival time.
 * @param redeemPeriod          Redemption interval.
 * @param redeemingAmt          Amount under redemption.
 * @param partialAmtDeliverDate Arrival time of partial redemption amount of order.
 * @param canRedeemEarly        When it is true,@ApiModelProperty("") early redemption can be operated.
 * @param renewable             When it is true,@ApiModelProperty("") auto staking can be operated.
 * @param type                  Order type is auto-staking or normal.
 * @param status                Position status.
 */
@ApiModel("")
public record ProductPosition(@ApiModelProperty("") String positionId, @ApiModelProperty("") String productId, @ApiModelProperty("") String asset,
		@ApiModelProperty("") String amount, @ApiModelProperty("") String purchaseTime, @ApiModelProperty("") String duration,
		@ApiModelProperty("") String accrualDays, @ApiModelProperty("") String rewardAsset, @ApiModelProperty("") String apy,
		@ApiModelProperty("") String rewardAmt, @ApiModelProperty("") String extraRewardAsset, @ApiModelProperty("") String extraRewardAPY,
		@ApiModelProperty("") String estExtraRewardAmt, @ApiModelProperty("") String nextInterestPay, @ApiModelProperty("") String nextInterestPayDate,
		@ApiModelProperty("") String payInterestPeriod, @ApiModelProperty("") String redeemAmountEarly, @ApiModelProperty("") String interestEndDate,
		@ApiModelProperty("") String deliverDate, @ApiModelProperty("") String redeemPeriod, @ApiModelProperty("") String redeemingAmt,
		@ApiModelProperty("") String partialAmtDeliverDate, @ApiModelProperty("") boolean canRedeemEarly, @ApiModelProperty("") boolean renewable,
		@ApiModelProperty("") String type, @ApiModelProperty("") String status) {
}