package com.binance4j.wallet.param;

import java.math.BigDecimal;

import com.binance4j.core.param.Params;
import com.binance4j.wallet.dto.WalletType;

/** The parameters to operate a withdraw */
public class WithdrawParams extends Params {

	/** The coin to withdraw. */
	private String coin;
	/** Client id for withdraw. */
	private String withdrawOrderId;
	/** The network to use. */
	private String network;
	/** The destination address. */
	private String address;
	/** Secondary address identifier for coins like XRP,XMR etc. */
	private String addressTag;
	/** The volume. */
	private BigDecimal amount;
	/**
	 * When making internal transfer, true for returning the fee to the destination account; false for returning the fee
	 * back to the departure account. Default false.
	 */
	private Boolean transactionFeeFlag;
	/** Description of the address. Space in name should be encoded into %20. */
	private String name;
	/** The wallet type for withdraw. */
	private Integer walletType;

	/**
	 * @param coin    The coin to withdraw.
	 * @param address The destination address.
	 * @param amount  The volume to withdraw.
	 */
	public WithdrawParams(BigDecimal amount, String coin, String address) {
		super(1);
		this.coin = coin;
		this.address = address;
		this.amount = amount;
	}

	/** @param type The wallet type to withdraw to. */
	public void setWalletType(WalletType type) {
		walletType = type.getValue();
	}

	/**
	 * @return the coin
	 */
	public String getCoin() {
		return coin;
	}

	/**
	 * @param coin the coin to set
	 */
	public void setCoin(String coin) {
		this.coin = coin;
	}

	/**
	 * @return the withdrawOrderId
	 */
	public String getWithdrawOrderId() {
		return withdrawOrderId;
	}

	/**
	 * @param withdrawOrderId the withdrawOrderId to set
	 */
	public void setWithdrawOrderId(String withdrawOrderId) {
		this.withdrawOrderId = withdrawOrderId;
	}

	/**
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @param network the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the addressTag
	 */
	public String getAddressTag() {
		return addressTag;
	}

	/**
	 * @param addressTag the addressTag to set
	 */
	public void setAddressTag(String addressTag) {
		this.addressTag = addressTag;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactionFeeFlag
	 */
	public Boolean getTransactionFeeFlag() {
		return transactionFeeFlag;
	}

	/**
	 * @param transactionFeeFlag the transactionFeeFlag to set
	 */
	public void setTransactionFeeFlag(Boolean transactionFeeFlag) {
		this.transactionFeeFlag = transactionFeeFlag;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the walletType
	 */
	public Integer getWalletType() {
		return walletType;
	}

	/**
	 * @param walletType the walletType to set
	 */
	public void setWalletType(Integer walletType) {
		this.walletType = walletType;
	}

}
