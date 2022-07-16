package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiTradingStatusTriggerCondition {
	/** Number of GTC orders. */
	@JsonProperty("GCR")
	private Long gcr;
	/** Number of FOK/IOC orders. */
	@JsonProperty("IFER")
	private Long ifer;
	/** Number of FOK/IOC orders. */
	@JsonProperty("UFR")
	private Long ufr;
}
