package com.binance4j.wallet.dto;

/**
 * Details of a supported asset.
 * 
 * @param minWithdrawAmount The minimal withdraw amount.
 * @param depositStatus     The deposit status (false if ALL of networks' are false).
 * @param withdrawFee       The withdraw fee.
 * @param withdrawStatus    The withdraw status (false if ALL of networks' are false).
 * @param depositTip        The reason of the status.
 */
public record AssetDetail(String minWithdrawAmount, boolean depositStatus, Float withdrawFee, boolean withdrawStatus, String depositTip) {
	/** @return Reason. */
	public String depositTip() {
		return depositTip == null ? "" : depositTip;
	}
}