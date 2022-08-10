package com.binance4j.websocket.serialization;

import java.io.IOException;

import com.binance4j.websocket.dto.Candle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/** {@link Candle} serializer */
public class CandlestickEventSerializer extends JsonSerializer<Candle> {
	@Override
	public void serialize(Candle candlestickEvent, JsonGenerator gen, SerializerProvider serializers)
			throws IOException {
		gen.writeStartObject(); // Write header
		gen.writeStringField("e", candlestickEvent.eventType());
		gen.writeNumberField("E", candlestickEvent.eventTime());
		gen.writeStringField("s", candlestickEvent.symbol()); // Write candlestick data
		gen.writeObjectFieldStart("k");
		gen.writeNumberField("t", candlestickEvent.openTime());
		gen.writeNumberField("T", candlestickEvent.closeTime());
		gen.writeStringField("i", candlestickEvent.intervalId());
		gen.writeNumberField("f", candlestickEvent.firstTradeId());
		gen.writeNumberField("L", candlestickEvent.lastTradeId());
		gen.writeStringField("o", candlestickEvent.open().toString());
		gen.writeStringField("c", candlestickEvent.close().toString());
		gen.writeStringField("h", candlestickEvent.high().toString());
		gen.writeStringField("l", candlestickEvent.low().toString());
		gen.writeStringField("v", candlestickEvent.volume().toString());
		gen.writeNumberField("n", candlestickEvent.numberOfTrades());
		gen.writeBooleanField("x", candlestickEvent.isBarFinal());
		gen.writeStringField("q", candlestickEvent.quoteAssetVolume().toString());
		gen.writeStringField("V", candlestickEvent.takerBuyBaseAssetVolume().toString());
		gen.writeStringField("Q", candlestickEvent.takerBuyQuoteAssetVolume().toString());
		gen.writeEndObject();
	}
}
