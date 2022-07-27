package com.binance4j.websocket.serialization;

import java.io.IOException;

import com.binance4j.websocket.dto.Candle;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/** {@link Candle} deserializer */
public class CandlestickEventDeserializer extends JsonDeserializer<Candle> {
	@Override
	public Candle deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp);
		JsonNode n = node.get("k");

		return new Candle(n.get("t").asLong(), n.get("o").asText(), n.get("h").asText(), n.get("l").asText(), n.get("c").asText(), n.get("v").asText(),
				n.get("T").asLong(), n.get("q").asText(), n.get("n").asLong(), n.get("V").asText(), n.get("Q").asText(), node.get("e").asText(),
				node.get("E").asLong(), node.get("s").asText(), n.get("i").asText(), n.get("f").asLong(), n.get("L").asLong(), n.get("x").asBoolean());
	}
}