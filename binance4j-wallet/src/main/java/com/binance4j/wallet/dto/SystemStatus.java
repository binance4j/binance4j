package com.binance4j.wallet.dto;

/**
 * The system status.
 * 
 * @param status The system status code (0: normal，1：maintenance).
 * @param msg    The system status message ("normal" or "system_maintenance").
 */
public record SystemStatus(int status, String msg) {
}