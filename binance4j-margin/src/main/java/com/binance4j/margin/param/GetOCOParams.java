package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAllOCO} params. */
@Param(weight = 10)
public class GetOCOParams implements Params {
	/** Is the order isolated? */
	Boolean isIsolated;
	/** THe symbol. Mandatory for isolated margin, not supported for cross margin. */
	String symbol;
	/** Either orderListId or origClientOrderId must be provided. */
	Long orderListId;
	/** Either orderListId or origClientOrderId must be provided. */
	String origClientOrderId;

	/** @return the isIsolated */
	public Boolean getIsIsolated() {
		return isIsolated;
	}

	/** @param isIsolated the isIsolated to set */
	public void setIsIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/** @return the orderListId */
	public Long getOrderListId() {
		return orderListId;
	}

	/** @param orderListId the orderListId to set */
	public void setOrderListId(Long orderListId) {
		this.orderListId = orderListId;
	}

	/** @return the origClientOrderId */
	public String getOrigClientOrderId() {
		return origClientOrderId;
	}

	/** @param origClientOrderId the origClientOrderId to set */
	public void setOrigClientOrderId(String origClientOrderId) {
		this.origClientOrderId = origClientOrderId;
	}

}
