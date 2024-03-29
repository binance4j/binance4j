package com.binance4j.portfoliomargin.client;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.portfoliomargin.dto.AccountInfo;
import com.binance4j.portfoliomargin.dto.CollaterateRateInfo;
import com.binance4j.portfoliomargin.param.AccountInfoParams;
import com.binance4j.portfoliomargin.param.CollaterateRateInfoParams;

/**
 * Api client for the margin portfolio endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#portfolio-margin-endpoints">Documentation</a>
 */
public class PortfolioMarginClient extends RestClient<PortfolioMarginMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public PortfolioMarginClient(String key, String secret) {
		super(PortfolioMarginMapping.class, key, secret);
	}

	/**
	 * Get account infos.
	 * 
	 * @return The request to execute.
	 */
	public Request<AccountInfo> getAccountInfo() {
		return new Request<>(service.getAccountInfo(new AccountInfoParams().toMap()));
	}

	/**
	 * Get collateral rate.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<CollaterateRateInfo>> getCollateralRate() {
		return new Request<>(service.getCollateralRate(new CollaterateRateInfoParams().toMap()));
	}
}
