package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WalletType;

/**
 * {@link WalletClient#withdraw} params.
 */
@Param
public class WithdrawParams implements Params {
	/** The volume. */
	@Mandatory
	String amount;
	/** The coin to withdraw. */
	@Mandatory
	String coin;
	/** The destination address. */
	@Mandatory
	String address;
	/** Client id for withdraw. */
	String withdrawOrderId;
	/** The network to use. */
	String network;
	/** Secondary address identifier for coins like XRP,XMR etc. */
	String addressTag;
	/**
	 * When making internal transfer, true for returning the fee to the destination account; false for returning the fee
	 * back to the departure account. Default false.
	 */
	Boolean transactionFeeFlag;
	/** Description of the address. Space in name should be encoded into %20. */
	String name;
	/** The wallet type for withdraw. */
	Integer walletType;

	/**
	 * @param coin    The coin to withdraw.
	 * @param address The destination address.
	 * @param amount  The volume to withdraw.
	 */
	public WithdrawParams(String amount, String coin, String address) {
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
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
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
