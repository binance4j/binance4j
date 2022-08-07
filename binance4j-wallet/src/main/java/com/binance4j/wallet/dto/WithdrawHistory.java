package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The withdraw history.
 * 
 * @param address         Address to withdraw to.
 * @param applyTime       Withdraw date operation.
 * @param coin            Coin to withdraw.
 * @param id              Withdraw id.
 * @param withdrawOrderId Withdraw order id. will not be returned if there's no withdrawOrderId for this withdraw.
 * @param network         Network to withdraw on.
 * @param info            Reason for withdrawal failure.
 * @param txId            Transaction id.
 * @param txKey           Transaction key.
 * @param transferType    1 for internal transfer, 0 for external transfer.
 * @param status          (0:Email Sent, 1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)
 * @param confirmNo       Confirm times for withdraw.
 * @param amount          Withdrawn colume.
 * @param transactionFee  Withdraw fees.
 * @param walletType      Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.
 */
@ApiModel("The withdraw history.")
public record WithdrawHistory(@ApiModelProperty("Address to withdraw to.") String address, @ApiModelProperty("Withdraw date operation.") String applyTime,
		@ApiModelProperty("Coin to withdraw.") String coin, @ApiModelProperty("Withdraw id.") String id,
		@ApiModelProperty("Withdraw order id. will not be returned if there's no withdrawOrderId for this withdraw.") String withdrawOrderId,
		@ApiModelProperty("Network to withdraw on.") String network, @ApiModelProperty("Reason for withdrawal failure.") String info,
		@ApiModelProperty("Transaction id.") String txId, @ApiModelProperty("Transaction key.") String txKey,
		@ApiModelProperty("1 for internal transfer, 0 for external transfer.") int transferType,
		@ApiModelProperty("(0:Email Sent, 1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)") int status,
		@ApiModelProperty("Confirm times for withdraw.") int confirmNo, @ApiModelProperty("Withdrawn colume.") String amount,
		@ApiModelProperty("Withdraw fees.") String transactionFee,
		@ApiModelProperty("Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.") int walletType) {
}