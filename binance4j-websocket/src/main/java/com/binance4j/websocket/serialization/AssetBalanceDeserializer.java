package com.binance4j.websocket.serialization;

import com.binance4j.core.account.AssetBalance;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * {@link AssetBalance} deserializer
 */
public class AssetBalanceDeserializer extends JsonDeserializer<AssetBalance> {

	@Override
	public AssetBalance deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);

		return new AssetBalance(
				node.get("a").asText(),
				new BigDecimal(node.get("f").asText()),
				new BigDecimal(node.get("l").asText()));
	}
}
