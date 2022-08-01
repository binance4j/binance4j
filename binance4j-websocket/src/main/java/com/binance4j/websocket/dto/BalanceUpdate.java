package com.binance4j.websocket.dto;

/**
 * Account update event which will reflect the balance changes of the account. This event is embedded as part of a user
 * data update event.
 *
 * @param eventType    The event type.
 * @param eventTime    The timestamp.
 * @param asset        The asset.
 * @param balanceDelta The balance delta.
 * @param clearTime    Clear time in ms.
 * @see UserDataUpdate
 */
public record BalanceUpdate(String e, Long E, String a, String d, Long T) {
}