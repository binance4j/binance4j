package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The system status.
 * 
 * @param status  The system status code (0: normal，1：maintenance).
 * @param message The system status message ("normal" or "system_maintenance").
 */
public record SystemStatus(
		/** The system status code (0: normal，1：maintenance). */
		int status,
		/** The system status message ("normal" or "system_maintenance"). */
		@JsonProperty("msg") String message) {
}