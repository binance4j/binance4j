package com.binance4j.websocket.serialization;

import com.binance4j.websocket.candle.CandlePayload;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * {@link CandlePayload} deserializer
 */
public class CandlestickEventDeserializer extends JsonDeserializer<CandlePayload> {

	@Override
	public CandlePayload deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		JsonNode candlestickNode = node.get("k");
		CandlePayload candlestickEvent = new CandlePayload();

		// Parse header
		candlestickEvent.setEventType(node.get("e").asText());
		candlestickEvent.setEventTime(node.get("E").asLong());
		candlestickEvent.setSymbol(node.get("s").asText());

		// Parse candlestick data
		candlestickEvent.setOpenTime(candlestickNode.get("t").asLong());
		candlestickEvent.setCloseTime(candlestickNode.get("T").asLong());
		candlestickEvent.setIntervalId(candlestickNode.get("i").asText());
		candlestickEvent.setFirstTradeId(candlestickNode.get("f").asLong());
		candlestickEvent.setLastTradeId(candlestickNode.get("L").asLong());
		candlestickEvent.setOpen(new BigDecimal(candlestickNode.get("o").asText()));
		candlestickEvent.setClose(new BigDecimal(candlestickNode.get("c").asText()));
		candlestickEvent.setHigh(new BigDecimal(candlestickNode.get("h").asText()));
		candlestickEvent.setLow(new BigDecimal(candlestickNode.get("l").asText()));
		candlestickEvent.setVolume(new BigDecimal(candlestickNode.get("v").asText()));
		candlestickEvent.setNumberOfTrades(candlestickNode.get("n").asLong());
		candlestickEvent.setIsBarFinal(candlestickNode.get("x").asBoolean());
		candlestickEvent.setQuoteAssetVolume(new BigDecimal(candlestickNode.get("q").asText()));
		candlestickEvent.setTakerBuyBaseAssetVolume(new BigDecimal(candlestickNode.get("V").asText()));
		candlestickEvent.setTakerBuyQuoteAssetVolume(new BigDecimal(candlestickNode.get("Q").asText()));

		return candlestickEvent;
	}
}
