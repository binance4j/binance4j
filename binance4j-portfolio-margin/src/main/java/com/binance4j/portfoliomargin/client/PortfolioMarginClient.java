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
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#portfolio-margin-endpoints">Documentation</a>
 */
public class PortfolioMarginClient extends RestClient<PortfolioMarginMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public PortfolioMarginClient(String key, String secret) {
		super(PortfolioMarginMapping.class, key, secret);
	}

	/**
	 * Get account infos.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<AccountInfo> getAccountInfo(AccountInfoParams params) {
		return new Request<>(service.getAccountInfo(params.toMap()));
	}

	/**
	 * Get account infos.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<AccountInfo> getAccountInfo() {
		return new Request<>(service.getAccountInfo(new AccountInfoParams().toMap()));
	}

	/**
	 * Get collateral rate.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<CollaterateRateInfo>> getCollateralRate(CollaterateRateInfoParams params) {
		return new Request<>(service.getCollateralRate(params.toMap()));
	}

	/**
	 * Get collateral rate.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<CollaterateRateInfo>> getCollateralRate() {
		return new Request<>(service.getCollateralRate(new CollaterateRateInfoParams().toMap()));
	}
}
