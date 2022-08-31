package com.binance4j.margin.client;

;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.margin.dto.Account;
import com.binance4j.margin.dto.Asset;
import com.binance4j.margin.dto.BNBBurnStatus;
import com.binance4j.margin.dto.CancelOrderResponse;
import com.binance4j.margin.dto.CrossFee;
import com.binance4j.margin.dto.CrossSymbol;
import com.binance4j.margin.dto.DustLogRecord;
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
import com.binance4j.margin.dto.OrderInfo;
import com.binance4j.margin.dto.OrderRateLimit;
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
public interface MarginMapping extends RestMapping {
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 600"})
	@POST("/sapi/v1/margin/transfer")
	Call<Transaction> transfer(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, UID_H, "X-WEIGHT: 3000"})
	@POST("/sapi/v1/margin/loan")
	Call<Transaction> borrow(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, UID_H, "X-WEIGHT: 3000"})
	@POST("/sapi/v1/margin/repay")
	Call<Transaction> repay(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({API_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/asset")
	Call<Asset> getAsset(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({API_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/pair")
	Call<CrossSymbol> getCrossMarginPair(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({API_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/allPairs")
	Call<List<CrossSymbol>> getAllCrossMarginPairs(@QueryMap Map<String, Object> map);
	
	/**
	 * @return The generated Retrofit call.
	 */
	@Headers({API_H, IP_H, WEIGHT_ONE_H})
	@GET("/sapi/v1/margin/allAssets")
	Call<List<Asset>> getAllAssets();
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({API_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/priceIndex")
	Call<PriceIndex> getPriceIndex(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, UID_H, "X-WEIGHT: 6", IS_ORDER_H})
	@POST("/sapi/v1/margin/order")
	Call<NewOrderRecord> newOrder(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@DELETE("/sapi/v1/margin/order")
	Call<CancelOrderResponse> cancelOrder(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, WEIGHT_ONE_H})
	@DELETE("/sapi/v1/margin/openOrders")
	Call<List<CancelOrderResponse>> cancelOpenOrders(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, WEIGHT_ONE_H})
	@GET("/sapi/v1/margin/transfer")
	Call<TransferRecords> getTransferHistory(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/loan")
	Call<LoanRecord> getLoanRecord(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/repay")
	Call<RepayRecords> getRepayRecord(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, WEIGHT_ONE_H})
	@GET("/sapi/v1/margin/interestHistory")
	Call<InterestHistory> getInterestHistory(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, WEIGHT_ONE_H})
	@GET("/sapi/v1/margin/forceLiquidationRec")
	Call<ForceLiquidationRecords> getForceLiquidationRecord(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/account")
	Call<Account> getAccount(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/order")
	Call<OrderInfo> getOrder(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/openOrders")
	Call<List<OrderInfo>> getOpenOrders(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 200"})
	@GET("/sapi/v1/margin/allOrders")
	Call<List<OrderInfo>> getAllOrders(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, UID_H, IS_ORDER_H, "X-WEIGHT: 6"})
	@POST("/sapi/v1/margin/order/oco")
	Call<NewOCOOrderRecord> newOCO(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, UID_H, WEIGHT_ONE_H})
	@DELETE("/sapi/v1/margin/orderList")
	Call<NewOCOOrderRecord> cancelOCO(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/orderList")
	Call<OCOOrderRecord> getOCO(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 200"})
	@GET("/sapi/v1/margin/allOrderList")
	Call<List<OCOOrderRecord>> getAllOCO(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/openOrderList")
	Call<List<OCOOrderRecord>> getOpenOCO(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/myTrades")
	Call<List<Trade>> getTrades(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 50"})
	@GET("/sapi/v1/margin/maxBorrowable")
	Call<MaxBorrowable> getMaxBorrowable(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 50"})
	@GET("/sapi/v1/margin/maxTransferable")
	Call<MaxTransferable> getMaxTransferable(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, UID_H, "X-WEIGHT: 600"})
	@POST("/sapi/v1/margin/isolated/transfer")
	Call<Transaction> isolatedTransfer(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, WEIGHT_ONE_H})
	@GET("/sapi/v1/margin/isolated/transfer")
	Call<IsolatedTransferRecords> getIsolatedTransferHistory(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/isolated/account")
	Call<IsolatedAccount> getIsolatedAccount(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, UID_H, "X-WEIGHT: 300"})
	@DELETE("/sapi/v1/margin/isolated/account")
	Call<ToogleAccountResponse> disableIsolatedAccount(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, UID_H, "X-WEIGHT: 300"})
	@POST("/sapi/v1/margin/isolated/account")
	Call<ToogleAccountResponse> enableIsolatedAccount(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 1"})
	@GET("/sapi/v1/margin/isolated/accountLimit")
	Call<IsolatedAccountLimit> getEnabledIsolatedAccountLimit(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/isolated/pair")
	Call<IsolatedSymbol> getIsolatedSymbol(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/isolated/allPairs")
	Call<List<IsolatedSymbol>> getAllIsolatedSymbols(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, WEIGHT_ONE_H})
	@POST("/sapi/v1/bnbBurn")
	Call<BNBBurnStatus> toggleBNBBurnOnSpotTradeAndMarginInterest(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, WEIGHT_ONE_H})
	@GET("/sapi/v1/bnbBurn")
	Call<BNBBurnStatus> getBNBBurnStatus(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, WEIGHT_ONE_H})
	@GET("/sapi/v1/margin/interestRateHistory")
	Call<List<InterestRate>> getInterestRateHistory(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 5"})
	@GET("/sapi/v1/margin/crossMarginData")
	Call<List<CrossFee>> getMarginFeeData(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 10"})
	@GET("/sapi/v1/margin/isolatedMarginData")
	Call<List<IsolatedFee>> getIsolatedFeeData(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 1"})
	@GET("/sapi/v1/margin/isolatedMarginTier")
	Call<List<IsolatedTierData>> getIsolatedMarginTierData(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 20"})
	@GET("/sapi/v1/margin/rateLimit/order")
	Call<List<OrderRateLimit>> getRateLimit(@QueryMap Map<String, Object> map);
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers({SIGNED_H, IP_H, "X-WEIGHT: 1"})
	@GET("/sapi/v1/margin/dribblet")
	// TODO watch headers in response to get weight since not in doc.
	Call<DustLogRecord> getDustLog(@QueryMap Map<String, Object> map);
}