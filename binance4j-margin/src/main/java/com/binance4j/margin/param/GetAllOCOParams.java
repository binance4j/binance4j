package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAllOCO} params. */
public class GetAllOCOParams extends IntervalParams {
	/** Is the order isolated? */
	private Boolean isIsolated;
	/** mandatory for isolated margin, not supported for cross margin. */
	private String symbol;
	/** If supplied, neither startTime or endTime can be provided. */
	private Long fromId;
	/** Default Value: 500; Max Value: 1000 */
	private Integer limit;

	/** Default constructor */
	public GetAllOCOParams() {
		super(200);
	}

	/** @return the isIsolated */.
	public Boolean isIsolated() {
		return isIsolated;
	}

	/** @param isIsolated the isIsolated to set */.
	public void isIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

	/** @return the symbol */.
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */.
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/** @return the fromId */.
	public Long getFromId() {
		return fromId;
	}

	/** @param fromId the fromId to set */.
	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	/** @return the limit */.
	public Integer getLimit() {
		return limit;
	}

	/** @param limit the limit to set */.
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
