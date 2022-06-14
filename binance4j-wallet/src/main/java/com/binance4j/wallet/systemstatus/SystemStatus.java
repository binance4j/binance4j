package com.binance4j.wallet.systemstatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** The system status */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemStatus {
	/**
	 * The system status code (0: normal，1：maintenance)
	 */
	private Integer status;
	/**
	 * The system status message ("normal" or "system_maintenance")
	 */
	@JsonProperty("msg")
	private String message;
}