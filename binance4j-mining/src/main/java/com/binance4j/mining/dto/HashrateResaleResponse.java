package com.binance4j.mining.dto;

/**
 * @param code Code.
 * @param msg  Message.
 * @param data Mining account.
 */
public record HashrateResaleResponse(int code, String msg, int data) {
}
