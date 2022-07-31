package com.binance4j.fiat.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.fiat.dto.PaymentHistory;
import com.binance4j.fiat.dto.TransactionHistory;
import com.binance4j.fiat.param.PaymentParams;
import com.binance4j.fiat.param.TransactionParams;

/**
 * Api client for the fiat endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#fiat-endpoints">Documentation</a>
 */
public class FiatClient extends RestClient<FiatMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public FiatClient(String key, String secret) {
		super(FiatMapping.class, key, secret);
	}

	/**
	 * Get fiat transactions.
	 * 
	 * @param params     The request params.
	 * @param pagination The pagination search.
	 * @return The request to execute.
	 */
	public Request<TransactionHistory> getTransactions(TransactionParams params, Paging pagination) {
		return new Request<>(service.getTransactions(Params.merge(params, pagination)));
	}

	/**
	 * Get fiat transactions.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<TransactionHistory> getTransactions(TransactionParams params) {
		return new Request<>(service.getTransactions(params.toMap()));
	}

	/**
	 * Get fiat payments.
	 * 
	 * @param params     The request params.
	 * @param pagination The pagination search.
	 * @return The request to execute.
	 */
	public Request<PaymentHistory> getPayments(PaymentParams params, Paging pagination) {
		return new Request<>(service.getPayments(Params.merge(params, pagination)));
	}

	/**
	 * Get fiat payments.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<PaymentHistory> getPayments(PaymentParams params) {
		return new Request<>(service.getPayments(params.toMap()));
	}
}