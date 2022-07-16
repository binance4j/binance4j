package com.binance4j.websocket.serialization;

import java.io.IOException;

import com.binance4j.websocket.userdata.AccountUpdatePayload;
import com.binance4j.websocket.userdata.BalanceUpdatePayload;
import com.binance4j.websocket.userdata.OrderTradeUpdatePayload;
import com.binance4j.websocket.userdata.UserDataUpdatePayload;
import com.binance4j.websocket.userdata.UserDataUpdatePayloadType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/** {@link UserDataUpdatePayload} deserializer */
public class UserDataUpdateEventDeserializer extends JsonDeserializer<UserDataUpdatePayload> {
	@Override
	public UserDataUpdatePayload deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = jp.getCodec().readTree(jp);
		String json = node.toString();
		final String eventTypeId = node.get("e").asText();
		final Long eventTime = node.get("E").asLong();

		UserDataUpdatePayloadType userDataUpdateEventType = UserDataUpdatePayloadType.getValue(eventTypeId);

		return switch (userDataUpdateEventType) {
		case ACCOUNT_POSITION_UPDATE -> new UserDataUpdatePayload(userDataUpdateEventType, eventTime, mapper.readValue(json, AccountUpdatePayload.class), null,
				null);
		case BALANCE_UPDATE -> new UserDataUpdatePayload(userDataUpdateEventType, eventTime, null, mapper.readValue(json, BalanceUpdatePayload.class), null);
		case ORDER_TRADE_UPDATE -> new UserDataUpdatePayload(userDataUpdateEventType, eventTime, null, null,
				mapper.readValue(json, OrderTradeUpdatePayload.class));
		default -> throw new IllegalArgumentException();
		};
	}
}