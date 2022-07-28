package com.binance4j.fiat.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Pagination;
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
	public Request<TransactionHistory> getTransactions(TransactionParams params, Pagination pagination) {
		return new Request<>(service.getTransactions(params.toMap(pagination)));
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
	public Request<PaymentHistory> getPayments(PaymentParams params, Pagination pagination) {
		return new Request<>(service.getPayments(params.toMap(pagination)));
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