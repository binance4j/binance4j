package com.binance4j.wallet.dust;

import java.util.List;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to convert small volumes (dust) into BNB
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DustTransferParams extends FramedParams {
	/** The list of assets to convert into BNB */
	private List<String> assets;

	/**
	 *
	 * 
	 * @param assets The list of assets to convert into BNB
	 */
	public DustTransferParams(List<String> assets) {
		super(10);
		this.assets = assets;
	}
}
