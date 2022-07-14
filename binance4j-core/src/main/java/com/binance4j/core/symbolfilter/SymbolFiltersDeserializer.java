package com.binance4j.core.symbolfilter;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

/** {@link SymbolFilters} deserializer */
public class SymbolFiltersDeserializer extends JsonDeserializer<SymbolFilters> {

	@Override
	public SymbolFilters deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
		SymbolFilters filters = new SymbolFilters();
		ObjectCodec oc = jp.getCodec();
		ArrayNode node = (ArrayNode) oc.readTree(jp);

		node.forEach(n -> {
			switch (n.get("filterType").asText()) {
				case "ICEBERG_PARTS":
					filters.setIcebergParts(new IcebergPartsFilter(n.get("limit").asInt()));
					break;
				case "LOT_SIZE":
					filters.setLotSize(new LotSizeFilter(
							new BigDecimal(n.get("minQty").asText()),
							new BigDecimal(n.get("maxQty").asText()),
							new BigDecimal(n.get("stepSize").asText())));
					break;
				case "MARKET_LOT_SIZE":
					filters.setMarketLotSize(new MarketLotSizeFilter(
							new BigDecimal(n.get("minQty").asText()),
							new BigDecimal(n.get("maxQty").asText()),
							new BigDecimal(n.get("stepSize").asText())));
					break;
				case "MAX_NUM_ALGO_ORDERS":
					filters.setMaxNumAlgoOrders(
							new MaxNumAlgoOrdersFilter(new BigDecimal(n.get("maxNumAlgoOrders").asText())));
					break;
				case "MAX_NUM_ICEBERG_ORDERS":
					filters.setMaxNumIcebergOrders(new MaxNumIcebergOrdersFilter(n.get("maxNumAlgoOrders").asInt()));
					break;
				case "MAX_NUM_ORDERS":
					filters.setMaxNumOrders(new MaxNumOrdersFilter(n.get("maxNumOrders").asInt()));
					break;
				case "MAX_POSITION":
					filters.setMaxPosition(new MaxPositionFilter(new BigDecimal(n.get("maxPosition").asText())));
					break;
				case "MIN_NOTIONAL":
					filters.setMinNotional(new MinNotionalFilter(
							new BigDecimal(n.get("minNotional").asText()),
							n.get("applyToMarket").asBoolean(),
							n.get("avgPriceMins").asInt()));
					break;
				case "NOTIONAL":
					filters.setNotional(new NotionalFilter(
							new BigDecimal(n.get("minNotional").asText()),
							new BigDecimal(n.get("maxNotional").asText()),
							n.get("applyMinToMarket").asBoolean(),
							n.get("applyMaxToMarket").asBoolean(),
							n.get("avgPriceMins").asInt()));
					break;
				case "PERCENT_PRICE_BY_SIDE":
					filters.setPercentPriceBySide(new PercentPriceBySideFilter(
							new BigDecimal(n.get("bidMultiplierUp").asText()),
							new BigDecimal(n.get("bidMultiplierDown").asText()),
							new BigDecimal(n.get("askMultiplierUp").asText()),
							new BigDecimal(n.get("askMultiplierDown").asText()),
							new BigDecimal(n.get("avgPriceMins").asText())));
					break;
				case "PERCENT_PRICE":
					filters.setPercentPrice(new PercentPriceFilter(
							new BigDecimal(n.get("multiplierUp").asText()),
							new BigDecimal(n.get("multiplierDown").asText()),
							new BigDecimal(n.get("avgPriceMins").asText())));
					break;
				case "PRICE_FILTER":
					filters.setPrice(new PriceFilter(
							new BigDecimal(n.get("minPrice").asText()),
							new BigDecimal(n.get("maxPrice").asText()),
							new BigDecimal(n.get("tickSize").asText())));
					break;
				case "TRAILING_DELTA":
					filters.setTrailingDelta(new TrailingDeltaFilter(
							new BigDecimal(n.get("minTrailingAboveDelta").asText()),
							new BigDecimal(n.get("maxTrailingAboveDelta").asText()),
							new BigDecimal(n.get("minTrailingBelowDelta").asText()),
							new BigDecimal(n.get("maxTrailingBelowDelta").asText())));
					break;
				default:
					break;
			}
		});
		return filters;
	}
}
