package com.binance4j.loan.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.loan.param.LoanIncomeHistoryParams;
import com.binance4j.loan.request.GetLoansIncomeRequest;

/**
 * Api client for the loan endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints">Documentation</a>
 */
public class LoanClient extends RestClient<LoanMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public LoanClient(String key, String secret) {
		super(LoanMapping.class, key, secret);
	}

	/**
	 * Get crypto loans income history.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval search.
	 * @return The request to execute.
	 */
	public GetLoansIncomeRequest getLoansIncome(LoanIncomeHistoryParams params, TimeFrame timeFrame) {
		return new GetLoansIncomeRequest(service.getLoansIncome(Params.merge(params, timeFrame)));
	}

	/**
	 * Get crypto loans income history.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetLoansIncomeRequest getLoansIncome(LoanIncomeHistoryParams params) {
		return new GetLoansIncomeRequest(service.getLoansIncome(params.toMap()));
	}
}
