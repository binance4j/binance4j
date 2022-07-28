package com.binance4j.wallet.dto;

/**
 * The API key permissions.
 * 
 * @param ipRestrict                     is the key restricted to an ip address?
 * @param enableWithdrawals              This option allows you to withdraw via API. You must apply the IP Access
 *                                           Restriction filter in order to enable withdrawals
 * @param enableInternalTransfer         This option authorizes this key to transfer funds between your master account
 *                                           and your sub account instantly.
 * @param permitsUniversalTransfer       Authorizes this key to be used for a dedicated universal transfer API to
 *                                           transfer multiple supported currencies. Each business's own transfer API
 *                                           rights are not affected by this authorization.
 * @param enableVanillaOptions           Authorizes this key to Vanilla options trading.
 * @param enableReading                  Does the key enables reading ?
 * @param enableFutures                  API Key created before your futures account opened does not support futures API
 *                                           service
 * @param enableMargin                   This option can be adjusted after the Cross Margin account transfer is
 *                                           completed
 * @param enableSpotAndMarginTrading     Spot and margin trading.
 * @param createTime                     The API key creation timestamp.
 * @param tradingAuthorityExpirationTime Expiration time for spot and margin trading permission.
 */
public record ApiPermissions(
		/** is the key restricted to an ip address? */
		boolean ipRestrict,
		/**
		 * This option allows you to withdraw via API. You must apply the IP Access Restriction filter in order to enable
		 * withdrawals.
		 */
		boolean enableWithdrawals,
		/** This option authorizes this key to transfer funds between your master account and your sub account instantly. */
		boolean enableInternalTransfer,
		/**
		 * Authorizes this key to be used for a dedicated universal transfer API to transfer multiple supported currencies. Each
		 * business's own transfer API rights are not affected by this authorization.
		 */
		boolean permitsUniversalTransfer,
		/** Authorizes this key to Vanilla options trading. */
		boolean enableVanillaOptions,
		/** Does the key enables reading ? */
		boolean enableReading,
		/** API Key created before your futures account opened does not support futures API service */
		boolean enableFutures,
		/** This option can be adjusted after the Cross Margin account transfer is completed */
		boolean enableMargin,
		/** Spot and margin trading. */
		boolean enableSpotAndMarginTrading,
		/** The API key creation timestamp. */
		long createTime,
		/** Expiration time for spot and margin trading permission. */
		long tradingAuthorityExpirationTime) {
}