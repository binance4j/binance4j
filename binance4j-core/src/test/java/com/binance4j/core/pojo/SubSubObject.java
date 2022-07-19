package com.binance4j.core.pojo;

import java.util.ArrayList;
import java.util.List;

import com.binance4j.core.dto.AggTrade;

public class SubSubObject {
	private List<AggTrade> trades = new ArrayList<>();

	/** @return the trades */
	public List<AggTrade> getTrades() {
		return trades;
	}

	/** @param trades the trades to set */
	public void setTrades(List<AggTrade> trades) {
		this.trades = trades;
	}
}
