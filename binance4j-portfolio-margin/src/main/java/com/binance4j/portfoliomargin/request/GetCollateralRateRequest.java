package com.binance4j.portfoliomargin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.portfoliomargin.client.PortfolioMarginClient;
import com.binance4j.portfoliomargin.dto.CollaterateRateInfo;

import retrofit2.Call;

/** {@link PortfolioMarginClient#getCollateralRate} request. */
@GetRequest(path = "/sapi/v1/portfolio/collateralRate", signature = Signature.USER_DATA, weight = 50)
public class GetCollateralRateRequest extends Request<List<CollaterateRateInfo>> {
	/**
	 * @param call the retrofit call
	 */
	public GetCollateralRateRequest(Call<List<CollaterateRateInfo>> call) {
		super(call);
	}
}
