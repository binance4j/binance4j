package com.binance4j.margin.dto;

/** Desired side-effect for margin orders */
public enum SideEffectType {
	/** normal trade order. */
	NO_SIDE_EFFECT,
	/** margin trade order. */
	MARGIN_BUY,
	/** for making auto repayment after order filled. */
	AUTO_REPAY
}
