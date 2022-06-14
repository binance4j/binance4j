package com.binance4j.wallet.withdraw;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

/**
 * The withdraw history
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawHistory {
	/**
	 * The address to withdraw to
	 */
	private String address;
	/**
	 * The the withdraw date operation
	 */
	private String applyTime;
	/**
	 * The coin to withdraw
	 */
	private String coin;
	/**
	 * The withdraw id
	 */
	private String id;
	/**
	 * The withdraw order id. will not be returned if there's no withdrawOrderId for
	 * this withdraw.
	 */
	private String withdrawOrderId;
	/**
	 * The network to withdraw on
	 */
	private String network;
	/**
	 * The reason for withdrawal failure
	 */
	private String info;
	/**
	 * The transaction id
	 */
	private String txId;
	/**
	 * 1 for internal transfer, 0 for external transfer
	 */
	private Integer transferType;
	/**
	 * (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected
	 * 4:Processing 5:Failure 6:Completed)
	 */
	private Integer status;
	/**
	 * Confirm times for withdraw
	 */
	private Integer confirmNo;
	/**
	 * The withdrawn colume
	 */
	private BigDecimal amount;
	/**
	 * The withdraw fees
	 */
	private BigDecimal transactionFee;
}