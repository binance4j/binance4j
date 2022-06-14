package com.binance4j.wallet.dust;

import com.binance4j.core.request.FramedRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * A request to convert small volumes (dust) into BNB
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DustTransferRequest extends FramedRequest {
	/**
	 * The list of assets to convert into BNB
	 */
	private List<String> assets;

	/**
	 * Constructor
	 *
	 * @param assets The list of assets to convert into BNB
	 */
	public DustTransferRequest(List<String> assets) {
		super(10);
		this.assets = assets;
	}
}
