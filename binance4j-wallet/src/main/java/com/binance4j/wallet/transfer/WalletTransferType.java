package com.binance4j.wallet.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User universal transfer type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum WalletTransferType {
	/**
	 * Spot account transfer to USDⓈ-M Futures account
	 */
	MAIN_UMFUTURE,
	/**
	 * Spot account transfer to COIN-M Futures account
	 */
	MAIN_CMFUTURE,
	/**
	 * Spot account transfer to Margin（cross）account
	 */
	MAIN_MARGIN,
	/**
	 * USDⓈ-M Futures account transfer to Spot account
	 */
	UMFUTURE_MAIN,
	/**
	 * USDⓈ-M Futures account transfer to Margin（cross）account
	 */
	UMFUTURE_MARGIN,
	/**
	 * COIN-M Futures account transfer to Spot account
	 */
	CMFUTURE_MAIN,
	/**
	 * COIN-M Futures account transfer to Margin(cross) account
	 */
	CMFUTURE_MARGIN,
	/**
	 * Margin（cross）account transfer to Spot account
	 */
	MARGIN_MAIN,
	/**
	 * Margin（cross）account transfer to USDⓈ-M Futures
	 */
	MARGIN_UMFUTURE,
	/**
	 * Margin（cross）account transfer to COIN-M Futures
	 */
	MARGIN_CMFUTURE,
	/**
	 * Isolated margin account transfer to Margin(cross) account
	 */
	ISOLATEDMARGIN_MARGIN,
	/**
	 * Margin(cross) account transfer to Isolated margin account
	 */
	MARGIN_ISOLATEDMARGIN,
	/**
	 * Isolated margin account transfer to Isolated margin account
	 */
	ISOLATEDMARGIN_ISOLATEDMARGIN,
	/**
	 * Spot account transfer to Funding account
	 */
	MAIN_FUNDING,
	/**
	 * Funding account transfer to Spot account
	 */
	FUNDING_MAIN,
	/**
	 * Funding account transfer to UMFUTURE account
	 */
	FUNDING_UMFUTURE,
	/**
	 * UMFUTURE account transfer to Funding account
	 */
	UMFUTURE_FUNDING,
	/**
	 * MARGIN account transfer to Funding account
	 */
	MARGIN_FUNDING,
	/**
	 * Funding account transfer to Margin account
	 */
	FUNDING_MARGIN,
	/**
	 * Funding account transfer to CMFUTURE account
	 */
	FUNDING_CMFUTURE,
	/**
	 * CMFUTURE account transfer to Funding account
	 */
	CMFUTURE_FUNDING
}
