package com.binance4j.fiat.client;

import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
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
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public FiatClient(String key, String secret) {
		super(FiatMapping.class, key, secret);
	}

	/**
	 * Get fiat transactions.
	 * 
	 * @param params       Request params.
	 * @param framedPaging Paging.
	 * @return The request to execute.
	 */
	public Request<TransactionHistory> getTransactions(TransactionParams params, FramedPaging framedPaging) {
		return new Request<>(service.getTransactions(Params.merge(params.toMap(), framedPaging.toMap(Map.of("startTime", "beginTime", "limit", "rows")))));
	}

	/**
	 * Get fiat transactions.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<TransactionHistory> getTransactions(TransactionParams params) {
		return new Request<>(service.getTransactions(params.toMap()));
	}

	/**
	 * Get fiat payments.
	 * 
	 * @param params       Request params.
	 * @param framedPaging Paging.
	 * @return The request to execute.
	 */
	public Request<PaymentHistory> getPayments(PaymentParams params, FramedPaging framedPaging) {
		return new Request<>(service.getPayments(Params.merge(params.toMap(), framedPaging.toMap(Map.of("startTime", "beginTime", "limit", "rows")))));
	}

	/**
	 * Get fiat payments.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<PaymentHistory> getPayments(PaymentParams params) {
		return new Request<>(service.getPayments(params.toMap()));
	}
}