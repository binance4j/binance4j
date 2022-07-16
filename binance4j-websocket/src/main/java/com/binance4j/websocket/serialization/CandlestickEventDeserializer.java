package com.binance4j.websocket.serialization;

import java.io.IOException;
import java.math.BigDecimal;

import com.binance4j.websocket.candle.CandlePayload;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/** {@link CandlePayload} deserializer */
public class CandlestickEventDeserializer extends JsonDeserializer<CandlePayload> {
	@Override
	public CandlePayload deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp);
		JsonNode n = node.get("k");

		return new CandlePayload(n.get("t").asLong(), new BigDecimal(n.get("o").asText()), new BigDecimal(n.get("h").asText()),
				new BigDecimal(n.get("l").asText()), new BigDecimal(n.get("c").asText()), new BigDecimal(n.get("v").asText()), n.get("T").asLong(),
				new BigDecimal(n.get("q").asText()), n.get("n").asLong(), new BigDecimal(n.get("V").asText()), new BigDecimal(n.get("Q").asText()),
				node.get("e").asText(), node.get("E").asLong(), node.get("s").asText(), n.get("i").asText(), n.get("f").asLong(), n.get("L").asLong(),
				n.get("x").asBoolean());
	}
}