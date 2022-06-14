package com.binance4j.nft.client;

import java.util.Map;

import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.nft.asset.NFTAssetHistory;
import com.binance4j.nft.deposit.NFTDepositHistory;
import com.binance4j.nft.transaction.NFTTransactionHistory;
import com.binance4j.nft.withdraw.NFTWithdrawHistory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface NFTMapping {
    public static final String BASE = "/sapi/v1/nft/";
    /** The signed http full header */
    public static final String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
    /** The API key http full header */
    public static final String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

    @GET(BASE + "history/transactions")
    @Headers({ API_H, SIGNED_H })
    Call<NFTTransactionHistory> getTransactions(@QueryMap Map<String, Object> map);

    @GET(BASE + "history/deposit")
    @Headers({ API_H, SIGNED_H })
    Call<NFTDepositHistory> getDeposits(@QueryMap Map<String, Object> map);

    @GET(BASE + "history/withdraw")
    @Headers({ API_H, SIGNED_H })
    Call<NFTWithdrawHistory> getWithdraws(@QueryMap Map<String, Object> map);

    @GET(BASE + "user/getAsset")
    @Headers({ API_H, SIGNED_H })
    Call<NFTAssetHistory> getAssets(@QueryMap Map<String, Object> map);
}