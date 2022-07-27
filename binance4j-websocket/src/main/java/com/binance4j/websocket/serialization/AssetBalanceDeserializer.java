package com.binance4j.websocket.serialization;

import java.io.IOException;

import com.binance4j.core.dto.AssetBalance;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/** {@link AssetBalance} deserializer */
public class AssetBalanceDeserializer extends JsonDeserializer<AssetBalance> {
	@Override
	public AssetBalance deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		JsonNode n = jp.getCodec().readTree(jp);
		return new AssetBalance(n.get("a").asText(), n.get("f").asText(), n.get("l").asText());
	}
}