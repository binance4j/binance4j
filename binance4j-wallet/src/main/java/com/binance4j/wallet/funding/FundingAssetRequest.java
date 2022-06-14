package com.binance4j.wallet.funding;

import com.binance4j.core.request.FramedRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get the funding wallet
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FundingAssetRequest extends FramedRequest {

	/**
	 * The asset we want the balance
	 */
	private String asset;

	/**
	 * Get the BTC value of the asset
	 */
	private Boolean needBtcValuation;

	/**
	 * Constructor
	 */
	public FundingAssetRequest() {
		super(1);
	}

	/**
	 * Constructor
	 *
	 * @param asset The asset we want the balance
	 */
	public FundingAssetRequest(String asset) {
		this();
		this.asset = asset;
	}

	/**
	 * Constructor
	 *
	 * @param asset            The asset we want the balance
	 * @param needBtcValuation Dlo we want the value of the balance in bitcoin?
	 */
	public FundingAssetRequest(String asset, Boolean needBtcValuation) {
		this(asset);
		this.needBtcValuation = needBtcValuation;
	}
}
