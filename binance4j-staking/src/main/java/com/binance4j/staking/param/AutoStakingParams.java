package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/** The {@link StakingClient} params. */
public class AutoStakingParams extends Params {
	/** The product type. */
	@Mandatory
	ProductType product;
	/** The position id. */
	@Mandatory
	String positionId;
	/** Renew purchase? */
	@Mandatory
	Boolean renewable;

	/**
	 * @param product    The product type.
	 * @param positionId The position id.
	 * @param renewable  Renew purchase?
	 */
	public AutoStakingParams(ProductType product, String positionId, Boolean renewable) {

		this.product = product;
		this.positionId = positionId;
		this.renewable = renewable;
	}

	/**
	 * @return the product
	 */
	public ProductType getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductType product) {
		this.product = product;
	}

	/**
	 * @return the positionId
	 */
	public String getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId the positionId to set
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return the renewable
	 */
	public Boolean getRenewable() {
		return renewable;
	}

	/**
	 * @param renewable the renewable to set
	 */
	public void setRenewable(Boolean renewable) {
		this.renewable = renewable;
	}

}
