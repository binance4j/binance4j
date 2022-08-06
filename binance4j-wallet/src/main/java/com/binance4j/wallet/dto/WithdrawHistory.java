package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The withdraw history.
 * 
 * @param address         The address to withdraw to.
 * @param applyTime       The the withdraw date operation.
 * @param coin            The coin to withdraw.
 * @param id              The withdraw id.
 * @param withdrawOrderId The withdraw order id. will not be returned if there's no withdrawOrderId for this withdraw.
 * @param network         The network to withdraw on.
 * @param info            The reason for withdrawal failure.
 * @param txId            The transaction id.
 * @param transferType    1 for internal transfer,@ApiModelProperty("") 0 for external transfer.
 * @param status          (0:Email Sent,@ApiModelProperty("")1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing
 *                            5:Failure 6:Completed)
 * @param confirmNo       Confirm times for withdraw.
 * @param amount          The withdrawn colume.
 * @param transactionFee  The withdraw fees.
 */
@ApiModel("")
public record WithdrawHistory(@ApiModelProperty("") String address, @ApiModelProperty("") String applyTime, @ApiModelProperty("") String coin,
		@ApiModelProperty("") String id, @ApiModelProperty("") String withdrawOrderId, @ApiModelProperty("") String network, @ApiModelProperty("") String info,
		@ApiModelProperty("") String txId, @ApiModelProperty("") int transferType, @ApiModelProperty("") int status, @ApiModelProperty("") int confirmNo,
		@ApiModelProperty("") String amount, @ApiModelProperty("") String transactionFee) {
}