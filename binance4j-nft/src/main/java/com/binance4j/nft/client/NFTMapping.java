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

/** {@link NFTClient} mapping. */
public interface NFTMapping extends RestMapping {
	/** The base uri. */
	String BASE = "/sapi/v1/nft/";

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "history/transactions")
	@Headers({ SIGNED_H, UID_H, "X-WEIGHT: 3000" })
	Call<TransactionHistory> getTransactions(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "history/deposit")
	@Headers({ SIGNED_H, UID_H, "X-WEIGHT: 3000" })
	Call<DepositHistory> getDeposits(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "history/withdraw")
	@Headers({ SIGNED_H, UID_H, "X-WEIGHT: 3000" })
	Call<WithdrawHistory> getWithdraws(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "user/getAsset")
	@Headers({ SIGNED_H, UID_H, "X-WEIGHT: 3000" })
	Call<AssetHistory> getAssets(@QueryMap Map<String, Object> map);
}