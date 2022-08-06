package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModelProperty;

/** User universal transfer type */
public enum WalletTransferType {
	/** Spot account transfer to USDⓈ-M Futures account. */
	MAIN_UMFUTURE, @ApiModelProperty("")
	/** Spot account transfer to COIN-M Futures account. */
	MAIN_CMFUTURE, @ApiModelProperty("")
	/** Spot account transfer to Margin（cross）account. */
	MAIN_MARGIN, @ApiModelProperty("")
	/** USDⓈ-M Futures account transfer to Spot account. */
	UMFUTURE_MAIN, @ApiModelProperty("")
	/** USDⓈ-M Futures account transfer to Margin（cross）account. */
	UMFUTURE_MARGIN, @ApiModelProperty("")
	/** COIN-M Futures account transfer to Spot account. */
	CMFUTURE_MAIN, @ApiModelProperty("")
	/** COIN-M Futures account transfer to Margin(cross) account. */
	CMFUTURE_MARGIN, @ApiModelProperty("")
	/** Margin（cross）account transfer to Spot account. */
	MARGIN_MAIN, @ApiModelProperty("")
	/** Margin（cross）account transfer to USDⓈ-M Futures. */
	MARGIN_UMFUTURE, @ApiModelProperty("")
	/** Margin（cross）account transfer to COIN-M Futures. */
	MARGIN_CMFUTURE, @ApiModelProperty("")
	/** Isolated margin account transfer to Margin(cross) account. */
	ISOLATEDMARGIN_MARGIN, @ApiModelProperty("")
	/** Margin(cross) account transfer to Isolated margin account. */
	MARGIN_ISOLATEDMARGIN, @ApiModelProperty("")
	/** Isolated margin account transfer to Isolated margin account. */
	ISOLATEDMARGIN_ISOLATEDMARGIN, @ApiModelProperty("")
	/** Spot account transfer to Funding account. */
	MAIN_FUNDING, @ApiModelProperty("")
	/** Funding account transfer to Spot account. */
	FUNDING_MAIN, @ApiModelProperty("")
	/** Funding account transfer to UMFUTURE account. */
	FUNDING_UMFUTURE, @ApiModelProperty("")
	/** UMFUTURE account transfer to Funding account. */
	UMFUTURE_FUNDING, @ApiModelProperty("")
	/** MARGIN account transfer to Funding account. */
	MARGIN_FUNDING, @ApiModelProperty("")
	/** Funding account transfer to Margin account. */
	FUNDING_MARGIN, @ApiModelProperty("")
	/** Funding account transfer to CMFUTURE account. */
	FUNDING_CMFUTURE, @ApiModelProperty("")
	/** CMFUTURE account transfer to Funding account. */
	CMFUTURE_FUNDING
}
