package com.binance4j.loan.client;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.TimeIntervalParams;
import com.binance4j.loan.dto.LoanIncome;
import com.binance4j.loan.param.LoanIncomeHistoryParams;

/**
 * Api client for the loan endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints">Documentation</a>
 */
public class LoanClient extends RestClient<PayMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public LoanClient(String key, String secret) {
		super(PayMapping.class, key, secret);
	}

	/**
	 * Get crypto loans income history.
	 * 
	 * @param params         The request params.
	 * @param intervalParams The time interval search.
	 * @return The request to execute.
	 */
	public Request<List<LoanIncome>> getLoansIncome(LoanIncomeHistoryParams params, TimeIntervalParams intervalParams) {
		return new Request<>(service.getLoansIncome(params.toMap(intervalParams)));
	}

	/**
	 * Get crypto loans income history.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<LoanIncome>> getLoansIncome(LoanIncomeHistoryParams params) {
		return new Request<>(service.getLoansIncome(params.toMap()));
	}
}
