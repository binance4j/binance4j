package com.binance4j.portfoliomargin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.portfoliomargin.client.PortfolioMarginClient;
import com.binance4j.portfoliomargin.dto.AccountInfo;

import retrofit2.Call;

/** {@link PortfolioMarginClient#getAccountInfo} request. */
@GetRequest(path = "/sapi/v1/portfolio/account", signature = Signature.USER_DATA)
public class GetAccountInfoRequest extends Request<AccountInfo> {
	/**
	 * @param call the retrofit call
	 */
	public GetAccountInfoRequest(Call<AccountInfo> call) {
		super(call);
	}
}
