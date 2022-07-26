package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/** The {@link SavingsClient#purchaseFixed} params. */
public class FixedPurchaseParams extends Params {
	/** The product id. */
	String productId;
	/** The amount. */
	Long lot;

	/**
	 * @param productId The product id.
	 * @param lot       Lot amount.
	 */
	public FixedPurchaseParams(String productId, Long lot) {
		super(1);
		this.productId = productId;
		this.lot = lot;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the lot
	 */
	public Long getLot() {
		return lot;
	}

	/**
	 * @param lot the lot to set
	 */
	public void setLot(Long lot) {
		this.lot = lot;
	}
}