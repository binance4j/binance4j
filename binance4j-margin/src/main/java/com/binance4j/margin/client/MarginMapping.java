package com.binance4j.margin.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.dto.CancelOrderResponse;
import com.binance4j.core.dto.OrderInfo;
import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.margin.dto.Account;
import com.binance4j.margin.dto.Asset;
import com.binance4j.margin.dto.BNBBurnStatus;
import com.binance4j.margin.dto.CrossFee;
import com.binance4j.margin.dto.CrossSymbol;
import com.binance4j.margin.dto.ForceLiquidationRecords;
import com.binance4j.margin.dto.InterestHistory;
import com.binance4j.margin.dto.InterestRate;
import com.binance4j.margin.dto.IsolatedAccount;
import com.binance4j.margin.dto.IsolatedAccountLimit;
import com.binance4j.margin.dto.IsolatedFee;
import com.binance4j.margin.dto.IsolatedSymbol;
import com.binance4j.margin.dto.IsolatedTierData;
import com.binance4j.margin.dto.IsolatedTransferRecords;
import com.binance4j.margin.dto.LoanRecord;
import com.binance4j.margin.dto.MaxBorrowable;
import com.binance4j.margin.dto.MaxTransferable;
import com.binance4j.margin.dto.NewOCOOrderRecord;
import com.binance4j.margin.dto.NewOrderRecord;
import com.binance4j.margin.dto.OCOOrderRecord;
import com.binance4j.margin.dto.PriceIndex;
import com.binance4j.margin.dto.RepayRecords;
import com.binance4j.margin.dto.ToogleAccountResponse;
import com.binance4j.margin.dto.Trade;
import com.binance4j.margin.dto.Transaction;
import com.binance4j.margin.dto.TransferRecords;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * {@link MarginClient} API mapping
 */
public interface MarginMapping {
	/** The base URI */
	String BASE = "/sapi/v1/margin/";
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "transfer")
	Call<Transaction> transfer(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "loan")
	Call<Transaction> borrow(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "repay")
	Call<Transaction> repay(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H })
	@GET(BASE + "asset")
	Call<Asset> getAsset(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H })
	@GET(BASE + "pair")
	Call<CrossSymbol> getCrossMarginPair(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H })
	@GET(BASE + "allPairs")
	Call<List<CrossSymbol>> getAllCrossMarginPairs(@QueryMap Map<String, Object> map);

	/**
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H })
	@GET(BASE + "allAssets")
	Call<List<Asset>> getAllAssets();

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H })
	@GET(BASE + "priceIndex")
	Call<PriceIndex> getPriceIndex(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "order")
	Call<NewOrderRecord> newOrder(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@DELETE(BASE + "order")
	Call<CancelOrderResponse> cancelOrder(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@DELETE(BASE + "openOrders")
	Call<List<CancelOrderResponse>> cancelOpenOrders(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "transfer")
	Call<TransferRecords> getTransferHistory(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "loan")
	Call<LoanRecord> getLoanRecord(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "repay")
	Call<RepayRecords> getRepayRecord(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "interestHistory")
	Call<InterestHistory> getInterestHistory(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "forceLiquidationRec")
	Call<ForceLiquidationRecords> getForceLiquidationRecord(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "account")
	Call<Account> getAccount(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "order")
	Call<OrderInfo> getOrder(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "openOrders")
	Call<List<OrderInfo>> getOpenOrders(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "allOrders")
	Call<List<OrderInfo>> getAllOrders(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "order/oco")
	Call<NewOCOOrderRecord> newOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@DELETE(BASE + "orderList")
	Call<NewOCOOrderRecord> cancelOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "orderList")
	Call<OCOOrderRecord> getOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "allOrderList")
	Call<List<OCOOrderRecord>> getAllOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "openOrderList")
	Call<List<OCOOrderRecord>> getOpenOCO(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "myTrades")
	Call<List<Trade>> getMyTrades(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "maxBorrowable")
	Call<MaxBorrowable> getMaxBorrowable(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "maxTransferable")
	Call<MaxTransferable> getMaxTransferable(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "isolated/transfer")
	Call<Transaction> isolatedTransfer(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "isolated/transfer")
	Call<IsolatedTransferRecords> getIsolatedTransferHistory(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "isolated/account")
	Call<IsolatedAccount> getIsolatedAccount(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@DELETE(BASE + "isolated/account")
	Call<ToogleAccountResponse> disableIsolatedAccount(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@POST(BASE + "isolated/account")
	Call<ToogleAccountResponse> enableIsolatedAccount(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "isolated/accountLimit")
	Call<IsolatedAccountLimit> getEnabledIsolatedAccountLimit(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "isolated/pair")
	Call<IsolatedSymbol> getIsolatedSymbol(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "isolated/allPairs")
	Call<List<IsolatedSymbol>> getAllIsolatedSymbols(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@POST("/sapi/v1/bnbBurn")
	Call<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET("/sapi/v1/bnbBurn")
	Call<BNBBurnStatus> getBNBBurnStatus(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "interestRateHistory")
	Call<List<InterestRate>> getInterestRateHistory(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "crossMarginData")
	Call<List<CrossFee>> getMarginFeeData(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "isolatedMarginData")
	Call<List<IsolatedFee>> getIsolatedFeeData(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, SIGNED_H })
	@GET(BASE + "isolatedMarginTier")
	Call<List<IsolatedTierData>> getIsolatedMarginTierData(@QueryMap Map<String, Object> map);
}