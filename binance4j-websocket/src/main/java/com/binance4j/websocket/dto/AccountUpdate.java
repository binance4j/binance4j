package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;
import com.binance4j.websocket.serialization.AssetBalanceDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account update event which will reflect the current position/balances of the
 * account.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @param eventType Event type.
 * @param eventTime Timestamp.
 * @param balances  Assets balance.
 * @see UserDataUpdate
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Account update event which will reflect the current position/balances of the account.")
public record AccountUpdate(@ApiModelProperty("Event type.") @JsonProperty("e") String eventType,
		@ApiModelProperty("Timestamp.") @JsonProperty("E") Long eventTime,
		@ApiModelProperty("Assets balance.") @JsonProperty("B") @JsonDeserialize(contentUsing = AssetBalanceDeserializer.class) List<AssetBalance> balances) {
}
