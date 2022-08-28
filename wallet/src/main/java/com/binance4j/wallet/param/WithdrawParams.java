package com.binance4j.wallet.param;

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
	String amount;
	/** The coin to withdraw. */
	String coin;
	/** The destination address. */
	String address;
	/** Client id for withdraw. */
	String withdrawOrderId;
	/** The network to use. */
	String network;
	/** Secondary address identifier for coins like XRP,XMR etc. */
	String addressTag;
	/**
	 * When making internal transfer, true for returning the fee to the destination
	 * account; false for returning the fee
	 * back to the departure account. Default false.
	 */
	Boolean transactionFeeFlag;
	/** Description of the address. Space in name should be encoded into %20. */
	String name;
	/** The wallet type for withdraw. */
	String walletType;

	/**
	 * @param coin    Coin to withdraw.
	 * @param address Destination address.
	 * @param amount  Volume to withdraw.
	 */
	public WithdrawParams(String amount, String coin, String address) {
		this.coin = coin;
		this.address = address;
		this.amount = amount;
	}

	/** @param type Wallet type to withdraw to. */
	public void setWalletType(WalletType type) {
		walletType = type.toString();
	}

	/**
	 * @return the coin
	 */
	public String getCoin() {
		return coin;
	}

	/**
	 * @param coin Coin to set
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
	 * @param withdrawOrderId WithdrawOrderId to set
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
	 * @param network Network to set
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
	 * @param address Address to set
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
	 * @param addressTag AddressTag to set
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
	 * @param amount Amount to set
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
	 * @param transactionFeeFlag TransactionFeeFlag to set
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
	 * @param name Name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the walletType
	 */
	public String getWalletType() {
		return walletType;
	}

	/**
	 * @param walletType WalletType to set
	 */
	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}
}
