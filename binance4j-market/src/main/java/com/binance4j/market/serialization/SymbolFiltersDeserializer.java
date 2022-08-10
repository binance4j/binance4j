package com.binance4j.market.serialization;

import java.io.IOException;

import com.binance4j.market.dto.IcebergPartsFilter;
import com.binance4j.market.dto.LotSizeFilter;
import com.binance4j.market.dto.MarketLotSizeFilter;
import com.binance4j.market.dto.MaxNumAlgoOrdersFilter;
import com.binance4j.market.dto.MaxNumIcebergOrdersFilter;
import com.binance4j.market.dto.MaxNumOrdersFilter;
import com.binance4j.market.dto.MaxPositionFilter;
import com.binance4j.market.dto.MinNotionalFilter;
import com.binance4j.market.dto.NotionalFilter;
import com.binance4j.market.dto.PercentPriceBySideFilter;
import com.binance4j.market.dto.PercentPriceFilter;
import com.binance4j.market.dto.PriceFilter;
import com.binance4j.market.dto.SymbolFilters;
import com.binance4j.market.dto.TrailingDeltaFilter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

/** {@link SymbolFilters} deserializer */
public class SymbolFiltersDeserializer extends JsonDeserializer<SymbolFilters> {
	IcebergPartsFilter icebergPartsFilter;
	LotSizeFilter lotSizeFilter;
	MarketLotSizeFilter marketLotSizeFilter;
	MaxNumAlgoOrdersFilter maxNumAlgoOrdersFilter;
	MaxNumIcebergOrdersFilter maxNumIcebergOrdersFilter;
	MaxNumOrdersFilter maxNumOrdersFilter;
	MaxPositionFilter maxPositionFilter;
	MinNotionalFilter minNotionalFilter;
	NotionalFilter notionalFilter;
	PercentPriceBySideFilter percentPriceBySideFilter;
	PercentPriceFilter percentPriceFilter;
	PriceFilter priceFilter;
	TrailingDeltaFilter trailingDeltaFilter;

	@Override
	public SymbolFilters deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		ObjectCodec oc = jp.getCodec();
		ArrayNode node = (ArrayNode) oc.readTree(jp);
		node.forEach(n -> {
			switch (n.get("filterType").asText()) {
				case "ICEBERG_PARTS" -> icebergPartsFilter = new IcebergPartsFilter(n.get("limit").asInt());
				case "LOT_SIZE" -> lotSizeFilter = new LotSizeFilter(n.get("minQty").asText(), n.get("maxQty").asText(),
						n.get("stepSize").asText());
				case "MARKET_LOT_SIZE" ->
					marketLotSizeFilter = new MarketLotSizeFilter(n.get("minQty").asText(), n.get("maxQty").asText(),
							n.get("stepSize").asText());
				case "MAX_NUM_ALGO_ORDERS" ->
					maxNumAlgoOrdersFilter = new MaxNumAlgoOrdersFilter(n.get("maxNumAlgoOrders").asText());
				case "MAX_NUM_ICEBERG_ORDERS" ->
					maxNumIcebergOrdersFilter = new MaxNumIcebergOrdersFilter(n.get("maxNumAlgoOrders").asInt());
				case "MAX_NUM_ORDERS" -> maxNumOrdersFilter = new MaxNumOrdersFilter(n.get("maxNumOrders").asInt());
				case "MAX_POSITION" -> maxPositionFilter = new MaxPositionFilter(n.get("maxPosition").asText());
				case "MIN_NOTIONAL" -> minNotionalFilter = new MinNotionalFilter(n.get("minNotional").asText(),
						n.get("applyToMarket").asBoolean(),
						n.get("avgPriceMins").asInt());
				case "NOTIONAL" ->
					notionalFilter = new NotionalFilter(n.get("minNotional").asText(), n.get("maxNotional").asText(),
							n.get("applyMinToMarket").asBoolean(), n.get("applyMaxToMarket").asBoolean(),
							n.get("avgPriceMins").asInt());
				case "PERCENT_PRICE_BY_SIDE" ->
					percentPriceBySideFilter = new PercentPriceBySideFilter(n.get("bidMultiplierUp").asText(),
							n.get("bidMultiplierDown").asText(), n.get("askMultiplierUp").asText(),
							n.get("askMultiplierDown").asText(),
							n.get("avgPriceMins").asText());
				case "PERCENT_PRICE" -> percentPriceFilter = new PercentPriceFilter(n.get("multiplierUp").asText(),
						n.get("multiplierDown").asText(),
						n.get("avgPriceMins").asText());
				case "PRICE_FILTER" -> priceFilter = new PriceFilter(n.get("minPrice").asText(),
						n.get("maxPrice").asText(), n.get("tickSize").asText());
				case "TRAILING_DELTA" ->
					trailingDeltaFilter = new TrailingDeltaFilter(n.get("minTrailingAboveDelta").asText(),
							n.get("maxTrailingAboveDelta").asText(), n.get("minTrailingBelowDelta").asText(),
							n.get("maxTrailingBelowDelta").asText());
				default -> {
				}
			}
		});
		return new SymbolFilters(icebergPartsFilter, lotSizeFilter, marketLotSizeFilter, maxNumAlgoOrdersFilter,
				maxNumIcebergOrdersFilter, maxNumOrdersFilter,
				maxPositionFilter, minNotionalFilter, notionalFilter, percentPriceBySideFilter, percentPriceFilter,
				priceFilter, trailingDeltaFilter);
	}
}
