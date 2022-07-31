package com.binance4j.wallet.dto;

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
public record WithdrawHistory(String address, String applyTime, String coin, String id, String withdrawOrderId, String network, String info, String txId,
		int transferType, int status, int confirmNo, String amount, String transactionFee) {
}