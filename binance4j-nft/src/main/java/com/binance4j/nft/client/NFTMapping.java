package com.binance4j.nft.client;

import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.nft.dto.AssetHistory;
import com.binance4j.nft.dto.DepositHistory;
import com.binance4j.nft.dto.TransactionHistory;
import com.binance4j.nft.dto.WithdrawHistory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** The {@link NFTClient} mapping */
public interface NFTMapping extends RestMapping {
	/** The base uri */
	String BASE = "/sapi/v1/nft/";

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "history/transactions")
	@Headers({ API_H, SIGNED_H })
	Call<TransactionHistory> getTransactions(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "history/deposit")
	@Headers({ API_H, SIGNED_H })
	Call<DepositHistory> getDeposits(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "history/withdraw")
	@Headers({ API_H, SIGNED_H })
	Call<WithdrawHistory> getWithdraws(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "user/getAsset")
	@Headers({ API_H, SIGNED_H })
	Call<AssetHistory> getAssets(@QueryMap Map<String, Object> map);
}