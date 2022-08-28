package com.binance4j.websocket.serialization;

import java.io.IOException;

import com.binance4j.websocket.dto.AccountUpdate;
import com.binance4j.websocket.dto.BalanceUpdate;
import com.binance4j.websocket.dto.OrderTradeUpdate;
import com.binance4j.websocket.dto.UserDataUpdate;
import com.binance4j.websocket.dto.UserDataUpdateType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/** {@link UserDataUpdate} deserializer */
public class UserDataUpdateEventDeserializer extends JsonDeserializer<UserDataUpdate> {
	@Override
	public UserDataUpdate deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = jp.getCodec().readTree(jp);
		String json = node.toString();
		final String eventTypeId = node.get("e").asText();
		final Long eventTime = node.get("E").asLong();
		UserDataUpdateType userDataUpdateEventType = UserDataUpdateType.getValue(eventTypeId);
		return switch (userDataUpdateEventType) {
			case ACCOUNT_POSITION_UPDATE -> new UserDataUpdate(userDataUpdateEventType, eventTime,
					mapper.readValue(json, AccountUpdate.class), null, null);
			case BALANCE_UPDATE -> new UserDataUpdate(userDataUpdateEventType, eventTime, null,
					mapper.readValue(json, BalanceUpdate.class), null);
			case ORDER_TRADE_UPDATE -> new UserDataUpdate(userDataUpdateEventType, eventTime, null, null,
					mapper.readValue(json, OrderTradeUpdate.class));
			default -> throw new IllegalArgumentException();
		};
	}
}