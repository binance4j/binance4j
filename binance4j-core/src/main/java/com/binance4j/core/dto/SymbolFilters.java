package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The trading rules of a symbol */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolFilters {
	private IcebergPartsFilter icebergParts;
	private LotSizeFilter lotSize;
	private MarketLotSizeFilter marketLotSize;
	private MaxNumAlgoOrdersFilter maxNumAlgoOrders;
	private MaxNumIcebergOrdersFilter maxNumIcebergOrders;
	private MaxNumOrdersFilter maxNumOrders;
	private MaxPositionFilter maxPosition;
	private MinNotionalFilter minNotional;
	private NotionalFilter notional;
	private PercentPriceBySideFilter percentPriceBySide;
	private PercentPriceFilter percentPrice;
	private PriceFilter price;
	private TrailingDeltaFilter trailingDelta;
}
