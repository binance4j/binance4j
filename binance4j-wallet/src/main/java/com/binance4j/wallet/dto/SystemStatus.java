package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The system status.
 * 
 * @param status  The system status code (0: normal，1：maintenance).
 * @param message The system status message ("normal" or "system_maintenance").
 */
public record SystemStatus(int status, @JsonProperty("msg") String message) {
}