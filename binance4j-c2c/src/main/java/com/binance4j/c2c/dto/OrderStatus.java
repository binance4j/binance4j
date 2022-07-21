package com.binance4j.c2c.dto;

/** Order status. */
public enum OrderStatus {
	/** Pending. */
	PENDING,
	/** Trading. */
	TRADING,
	/** Buyer_payed. */
	BUYER_PAYED,
	/** Distributing. */
	DISTRIBUTING,
	/** Completed. */
	COMPLETED,
	/** In_appeal. */
	IN_APPEAL,
	/** Cancelled. */
	CANCELLED,
	/** Cancelled_by_system. */
	CANCELLED_BY_SYSTEM
}
