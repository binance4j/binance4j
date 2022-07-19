package com.binance4j.core.serialization;

import java.io.IOException;
import java.math.BigDecimal;

import com.binance4j.core.dto.Candle;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

/** {@link Candle} deserializer */
public class CandleDeserializer extends JsonDeserializer<Candle> {

	@Override
	public Candle deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {

		ObjectCodec oc = jp.getCodec();
		ArrayNode node = (ArrayNode) oc.readTree(jp);

		return new Candle(node.get(0).asLong(), new BigDecimal(node.get(1).asText()), new BigDecimal(node.get(2).asText()),
				new BigDecimal(node.get(3).asText()), new BigDecimal(node.get(4).asText()), new BigDecimal(node.get(5).asText()), node.get(6).asLong(),
				new BigDecimal(node.get(7).asText()), node.get(8).asLong(), new BigDecimal(node.get(9).asText()), new BigDecimal(node.get(10).asText()));
	}
}
