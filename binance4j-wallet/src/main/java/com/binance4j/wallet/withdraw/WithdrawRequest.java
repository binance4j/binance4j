package com.binance4j.wallet.withdraw;

import com.binance4j.core.request.FramedRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * A request to operate a withdraw
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WithdrawRequest extends FramedRequest {
	/**
	 * The coin to withdraw
	 */
	private String coin;
	/**
	 * Client id for withdraw
	 */
	private String withdrawOrderId;
	/**
	 * The network to use
	 */
	private String network;
	/**
	 * The destination address
	 */
	private String address;
	/**
	 * Secondary address identifier for coins like XRP,XMR etc.
	 */
	private String addressTag;
	/**
	 * The volume
	 */
	private BigDecimal amount;
	/**
	 * When making internal transfer, true for returning the fee to the
	 * destination account; false for returning the fee back to the
	 * departure account. Default false.
	 */
	private Boolean transactionFeeFlag;
	/**
	 * Description of the address. Space in name should be encoded into %20.
	 */
	private String name;
	/**
	 * The wallet type for withdraw
	 */
	private Integer walletType;

	/**
	 * Constructor
	 *
	 * @param coin    The coin to withdraw
	 * @param address The destination address
	 * @param amount  The volume to withdraw
	 */
	public WithdrawRequest(BigDecimal amount, String coin, String address) {
		super(1);
		this.coin = coin;
		this.address = address;
		this.amount = amount;
	}

	/**
	 * @param type The wallet type to withdraw to
	 */
	public void setWalletType(WalletType type) {
		walletType = type.getValue();
	}
}
