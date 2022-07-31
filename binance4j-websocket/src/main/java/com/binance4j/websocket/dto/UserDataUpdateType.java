package com.binance4j.websocket.dto;

/** The user data update type */
public enum UserDataUpdateType {
	/** Corresponds to "outboundAccountPosition" events. */
	ACCOUNT_POSITION_UPDATE("outboundAccountPosition"),
	/** Corresponds to "balanceUpdate" events. */
	BALANCE_UPDATE("balanceUpdate"),
	/** Corresponds to "executionReport" events. */
	ORDER_TRADE_UPDATE("executionReport");

	/** The enum string value. */
	final String value;

	/**
	 * @param value
	 */
	private UserDataUpdateType(String value) {
		this.value = value;
	}

	/**
	 * @param eventTypeId The enum string value.
	 * @return The enum value.
	 */
	public static UserDataUpdateType getValue(String eventTypeId) {
		if (ORDER_TRADE_UPDATE.value.equals(eventTypeId)) {
			return ORDER_TRADE_UPDATE;
		} else if (ACCOUNT_POSITION_UPDATE.value.equals(eventTypeId)) {
			return ACCOUNT_POSITION_UPDATE;
		} else if (BALANCE_UPDATE.value.equals(eventTypeId)) {
			return BALANCE_UPDATE;
		}
		throw new RuntimeException("Unrecognized user data update event type id: " + eventTypeId);
	}

	@Override
	public String toString() {
		return value;
	}
}