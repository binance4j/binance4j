package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#toggleBNBBurnOnSpotTradeAndMarginInterest} params. */
public class ToggleBurnParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** Determines whether to use BNB to pay for trading fees on SPOT. */
	private Boolean spotBNBBurn;
	/** Determines whether to use BNB to pay for margin loan's interest. */
	private Boolean interestBNBBurn;

	/** Default constructor */
	public ToggleBurnParams() {
		super();
	}

	/**
	 * @param spotBNBBurn     Determines whether to use BNB to pay for trading fees on SPOT.
	 * @param interestBNBBurn Determines whether to use BNB to pay for margin loan's interest.
	 */
	public ToggleBurnParams(Boolean spotBNBBurn, Boolean interestBNBBurn) {
		this();
		this.spotBNBBurn = spotBNBBurn;
		this.interestBNBBurn = interestBNBBurn;
	}

	/** @return the spotBNBBurn */
	public Boolean getSpotBNBBurn() {
		return spotBNBBurn;
	}

	/** @param spotBNBBurn the spotBNBBurn to set */
	public void setSpotBNBBurn(Boolean spotBNBBurn) {
		this.spotBNBBurn = spotBNBBurn;
	}

	/** @return the interestBNBBurn */
	public Boolean getInterestBNBBurn() {
		return interestBNBBurn;
	}

	/** @param interestBNBBurn the interestBNBBurn to set */
	public void setInterestBNBBurn(Boolean interestBNBBurn) {
		this.interestBNBBurn = interestBNBBurn;
	}

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}