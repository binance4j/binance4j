package com.binance4j.websocket.serialization;

import com.binance4j.websocket.candle.CandlePayload;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * {@link CandlePayload} serializer
 */
public class CandlestickEventSerializer extends JsonSerializer<CandlePayload> {

	@Override
	public void serialize(CandlePayload candlestickEvent, JsonGenerator gen, SerializerProvider serializers)
			throws IOException {
		gen.writeStartObject();

		// Write header
		gen.writeStringField("e", candlestickEvent.getEventType());
		gen.writeNumberField("E", candlestickEvent.getEventTime());
		gen.writeStringField("s", candlestickEvent.getSymbol());

		// Write candlestick data
		gen.writeObjectFieldStart("k");
		gen.writeNumberField("t", candlestickEvent.getOpenTime());
		gen.writeNumberField("T", candlestickEvent.getCloseTime());
		gen.writeStringField("i", candlestickEvent.getIntervalId());
		gen.writeNumberField("f", candlestickEvent.getFirstTradeId());
		gen.writeNumberField("L", candlestickEvent.getLastTradeId());
		gen.writeStringField("o", candlestickEvent.getOpen().toString());
		gen.writeStringField("c", candlestickEvent.getClose().toString());
		gen.writeStringField("h", candlestickEvent.getHigh().toString());
		gen.writeStringField("l", candlestickEvent.getLow().toString());
		gen.writeStringField("v", candlestickEvent.getVolume().toString());
		gen.writeNumberField("n", candlestickEvent.getNumberOfTrades());
		gen.writeBooleanField("x", candlestickEvent.getIsBarFinal());
		gen.writeStringField("q", candlestickEvent.getQuoteAssetVolume().toString());
		gen.writeStringField("V", candlestickEvent.getTakerBuyBaseAssetVolume().toString());
		gen.writeStringField("Q", candlestickEvent.getTakerBuyQuoteAssetVolume().toString());
		gen.writeEndObject();
	}
}
