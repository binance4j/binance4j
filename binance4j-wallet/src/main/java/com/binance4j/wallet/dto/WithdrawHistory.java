package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The withdraw history */
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
		Integer transferType,
		/** (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed) */
		Integer status,
		/** Confirm times for withdraw. */
		Integer confirmNo,
		/** The withdrawn colume. */
		BigDecimal amount,
		/** The withdraw fees. */
		BigDecimal transactionFee) {
}