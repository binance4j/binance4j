package com.binance4j.margin.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.margin.account.MarginAccount;
import com.binance4j.margin.account.MarginIsolatedAccount;
import com.binance4j.margin.account.MarginIsolatedAccountLimit;
import com.binance4j.margin.account.ToogleAccountResponse;
import com.binance4j.margin.asset.MarginAsset;
import com.binance4j.margin.borrow.MaxBorrowableResponse;
import com.binance4j.margin.borrow.MaxTransferableResponse;
import com.binance4j.margin.burn.BNBBurnStatus;
import com.binance4j.margin.fee.CrossMarginFee;
import com.binance4j.margin.fee.IsolatedMarginFee;
import com.binance4j.margin.forceliquidation.ForceLiquidationRecord;
import com.binance4j.margin.interest.InterestHistory;
import com.binance4j.margin.interest.InterestRate;
import com.binance4j.margin.loan.LoanRecord;
import com.binance4j.margin.oco.GetMarginOCOResponse;
import com.binance4j.margin.oco.MarginOCOResponse;
import com.binance4j.margin.order.MarginOrderResponse;
import com.binance4j.margin.priceindex.PriceIndex;
import com.binance4j.margin.repay.RepayRecord;
import com.binance4j.margin.symbol.MarginSymbol;
import com.binance4j.margin.tier.IsolatedMarginTierData;
import com.binance4j.margin.trade.MarginTrade;
import com.binance4j.margin.transfer.MarginIsolatedTransferHistory;
import com.binance4j.margin.transfer.MarginTransaction;
import com.binance4j.margin.transferhistory.MarginTransferHistoryResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface MarginMapping {
    String BASE = "/sapi/v1/margin/";
    /**
     * The signed http full header
     */
    String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
    /**
     * The API key http full header
     */
    String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

    @Headers({ API_H, SIGNED_H })
    @POST(BASE + "transfer")
    Call<MarginTransaction> transfer(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @POST(BASE + "loan")
    Call<MarginTransaction> borrow(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @POST(BASE + "repay")
    Call<MarginTransaction> repay(@QueryMap Map<String, Object> map);

    @Headers({ API_H })
    @GET(BASE + "asset")
    Call<MarginAsset> getAsset(@QueryMap Map<String, Object> map);

    @Headers({ API_H })
    @GET(BASE + "allAssets")
    Call<List<MarginAsset>> getAllAssets();

    @Headers({ API_H })
    @GET(BASE + "pair")
    Call<MarginSymbol> getSymbol(@QueryMap Map<String, Object> map);

    @Headers({ API_H })
    @GET(BASE + "allPairs")
    Call<List<MarginSymbol>> getAllSymbols();

    @Headers({ API_H })
    @GET(BASE + "priceIndex")
    Call<PriceIndex> getPriceIndex(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @POST(BASE + "order")
    Call<MarginOrderResponse> newOrder(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @DELETE(BASE + "order")
    Call<CancelOrderResponse> cancelOrder(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @DELETE(BASE + "openOrders")
    Call<List<CancelOrderResponse>> cancelOpenOrders(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "transfer")
    Call<MarginTransferHistoryResponse> getTransferHistory(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "loan")
    Call<LoanRecord> getLoanRecord(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "repay")
    Call<RepayRecord> getRepayRecord(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "interestHistory")
    Call<InterestHistory> getInterestHistory(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "forceLiquidationRec")
    Call<ForceLiquidationRecord> getForceLiquidationRecord(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "account")
    Call<MarginAccount> getAccount(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "order")
    Call<OrderInfo> getOrder(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "openOrders")
    Call<List<OrderInfo>> getOpenOrders(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "allOrders")
    Call<List<OrderInfo>> getAllOrders(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @POST(BASE + "order/oco")
    Call<MarginOCOResponse> newOCO(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @DELETE(BASE + "orderList")
    Call<MarginOCOResponse> cancelOCO(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "orderList")
    Call<GetMarginOCOResponse> getOCO(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "allOrderList")
    Call<List<GetMarginOCOResponse>> getAllOCO(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "openOrderList")
    Call<List<GetMarginOCOResponse>> getOpenOCO(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "myTrades")
    Call<List<MarginTrade>> getMyTrades(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "maxBorrowable")
    Call<MaxBorrowableResponse> getMaxBorrowable(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "maxTransferable")
    Call<MaxTransferableResponse> getMaxTransferable(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @POST(BASE + "isolated/transfer")
    Call<MarginTransaction> isolatedTransfer(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "isolated/transfer")
    Call<MarginIsolatedTransferHistory> getIsolatedTransferHistory(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "isolated/account")
    Call<MarginIsolatedAccount> getIsolatedAccount(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @DELETE(BASE + "isolated/account")
    Call<ToogleAccountResponse> disableIsolatedAccount(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @POST(BASE + "isolated/account")
    Call<ToogleAccountResponse> enableIsolatedAccount(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "isolated/accountLimit")
    Call<MarginIsolatedAccountLimit> getEnabledIsolatedAccountLimit(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "isolated/pair")
    Call<MarginSymbol> getIsolatedSymbol(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "isolated/allPairs")
    Call<List<MarginSymbol>> getAllIsolatedSymbols(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @POST("/sapi/v1/bnbBurn")
    Call<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET("/sapi/v1/bnbBurn")
    Call<BNBBurnStatus> getBNBBurnStatus(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "interestRateHistory")
    Call<List<InterestRate>> getInterestRateHistory(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "crossMarginData")
    Call<List<CrossMarginFee>> getMarginFeeData(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "isolatedMarginData")
    Call<List<IsolatedMarginFee>> getIsolatedFeeData(@QueryMap Map<String, Object> map);

    @Headers({ API_H, SIGNED_H })
    @GET(BASE + "isolatedMarginTier")
    Call<List<IsolatedMarginTierData>> getIsolatedMarginTierData(@QueryMap Map<String, Object> map);
}