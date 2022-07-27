package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
 * @param transferType    1 for internal transfer, 0 for external transfer.
 * @param status          (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)
 * @param confirmNo       Confirm times for withdraw.
 * @param amount          The withdrawn colume.
 * @param transactionFee  The withdraw fees.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WithdrawHistory(
		/** The address to withdraw to. */
		String address,
		/** The the withdraw date operation. */
		String applyTime,
		/** The coin to withdraw. */
		String coin,
		/** The withdraw id. */
		String id,
		/** The withdraw order id. will not be returned if there's no withdrawOrderId for this withdraw. */
		String withdrawOrderId,
		/** The network to withdraw on. */
		String network,
		/** The reason for withdrawal failure. */
		String info,
		/** The transaction id. */
		String txId,
		/** 1 for internal transfer, 0 for external transfer. */
		int transferType,
		/** (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed) */
		int status,
		/** Confirm times for withdraw. */
		int confirmNo,
		/** The withdrawn colume. */
		String amount,
		/** The withdraw fees. */
		String transactionFee) {
}