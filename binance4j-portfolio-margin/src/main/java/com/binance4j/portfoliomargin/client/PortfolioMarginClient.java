package com.binance4j.portfoliomargin.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.portfoliomargin.param.AccountInfoParams;
import com.binance4j.portfoliomargin.param.CollaterateRateInfoParams;
import com.binance4j.portfoliomargin.request.GetAccountInfoRequest;
import com.binance4j.portfoliomargin.request.GetCollateralRateRequest;

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
	public GetAccountInfoRequest getAccountInfo() {
		return new GetAccountInfoRequest(service.getAccountInfo(new AccountInfoParams().toMap()));
	}

	/**
	 * Get collateral rate.
	 * 
	 * @return The request to execute.
	 */
	public GetCollateralRateRequest getCollateralRate() {
		return new GetCollateralRateRequest(service.getCollateralRate(new CollaterateRateInfoParams().toMap()));
	}
}
