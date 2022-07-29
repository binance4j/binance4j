package com.binance4j.nft.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Page;
import com.binance4j.core.param.Pagination;
import com.binance4j.core.param.TimeIntervalParams;
import com.binance4j.nft.dto.AssetHistory;
import com.binance4j.nft.dto.DepositHistory;
import com.binance4j.nft.dto.TransactionHistory;
import com.binance4j.nft.dto.WithdrawHistory;
import com.binance4j.nft.param.AssetParams;
import com.binance4j.nft.param.OperationParams;
import com.binance4j.nft.param.TransactionHistoryParams;

/**
 * Api client for the NFT endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#nft-endpoints">Documentation</a>
 */
public class NFTClient extends RestClient<NFTMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public NFTClient(String key, String secret) {
		super(NFTMapping.class, key, secret);
	}

	/**
	 * Get NFT Transaction History.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<TransactionHistory> getTransactions(TransactionHistoryParams params) {
		return new Request<>(service.getTransactions(params.toMap()));
	}

	/**
	 * Get NFT Transaction History.
	 * 
	 * @param params         The request params.
	 * @param intervalParams The time interval search.
	 * @return The request to execute.
	 */
	public Request<TransactionHistory> getTransactions(TransactionHistoryParams params, TimeIntervalParams intervalParams) {
		return new Request<>(service.getTransactions(params.toMap(List.of(intervalParams.toMap()))));
	}

	/**
	 * Get NFT Transaction History.
	 * 
	 * @param params The request params.
	 * @param page   The result page.
	 * @return The request to execute.
	 */
	public Request<TransactionHistory> getTransactions(TransactionHistoryParams params, Page page) {
		return new Request<>(service.getTransactions(params.toMap(List.of(page.toMap()))));
	}

	/**
	 * Get NFT Transaction History.
	 * 
	 * @param params         The request params.
	 * @param intervalParams The time interval search.
	 * @param page           The result page.
	 * @return The request to execute.
	 */
	public Request<TransactionHistory> getTransactions(TransactionHistoryParams params, TimeIntervalParams intervalParams, Page page) {
		return new Request<>(service.getTransactions(params.toMap(List.of(intervalParams.toMap(), page.toMap()))));
	}

	/**
	 * Get NFT deposit History.
	 * <p>
	 * The max interval between startTime and endTime is 90 days.
	 * <p>
	 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
	 * 
	 * @param intervalParams The time interval search.
	 * @param page           The result page.
	 * @return The request to execute.
	 */
	public Request<DepositHistory> getDeposits(TimeIntervalParams intervalParams, Page page) {
		var searchMap = List.of(intervalParams.toMap(), page.toMap());
		return new Request<>(service.getDeposits(new OperationParams().toMap(searchMap)));
	}

	/**
	 * Get NFT deposit History.
	 * <p>
	 * The max interval between startTime and endTime is 90 days.
	 * <p>
	 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
	 * 
	 * @param intervalParams The time interval search.
	 * @return The request to execute.
	 */
	public Request<DepositHistory> getDeposits(TimeIntervalParams intervalParams) {
		return new Request<>(service.getDeposits(new OperationParams().toMap(intervalParams)));
	}

	/**
	 * Get NFT deposit History.
	 * <p>
	 * The max interval between startTime and endTime is 90 days.
	 * <p>
	 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
	 * 
	 * @param page The result pagination.
	 * @return The request to execute.
	 */
	public Request<DepositHistory> getDeposits(Page page) {
		return new Request<>(service.getDeposits(new OperationParams().toMap(page)));
	}

	/**
	 * Get NFT deposit History.
	 * <p>
	 * The max interval between startTime and endTime is 90 days.
	 * <p>
	 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
	 * 
	 * @return The request to execute.
	 */
	public Request<DepositHistory> getDeposits() {
		return new Request<>(service.getDeposits(new OperationParams().toMap()));
	}

	/**
	 * Get NFT withdraw History.
	 * <p>
	 * The max interval between startTime and endTime is 90 days.
	 * <p>
	 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
	 * 
	 * @param intervalParams The time interval search.
	 * @param page           The result page.
	 * @return The request to execute.
	 */
	public Request<WithdrawHistory> getWithdraws(TimeIntervalParams intervalParams, Page page) {
		var searchMap = List.of(intervalParams.toMap(), page.toMap());
		return new Request<>(service.getWithdraws(new OperationParams().toMap(searchMap)));
	}

	/**
	 * Get NFT withdraw History.
	 * <p>
	 * The max interval between startTime and endTime is 90 days.
	 * <p>
	 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
	 * 
	 * @param intervalParams The time interval search.
	 * @return The request to execute.
	 */
	public Request<WithdrawHistory> getWithdraws(TimeIntervalParams intervalParams) {
		return new Request<>(service.getWithdraws(new OperationParams().toMap(intervalParams)));
	}

	/**
	 * Get NFT withdraw History.
	 * <p>
	 * The max interval between startTime and endTime is 90 days.
	 * <p>
	 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
	 * 
	 * @param page The result pagination.
	 * @return The request to execute.
	 */
	public Request<WithdrawHistory> getWithdraws(Page page) {
		return new Request<>(service.getWithdraws(new OperationParams().toMap(page)));
	}

	/**
	 * Get NFT withdraw History.
	 * <p>
	 * The max interval between startTime and endTime is 90 days.
	 * <p>
	 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
	 * 
	 * @return The request to execute.
	 */
	public Request<WithdrawHistory> getWithdraws() {
		return new Request<>(service.getWithdraws(new OperationParams().toMap()));
	}

	/**
	 * Get NFT assets.
	 * 
	 * @param intervalParams The time interval search.
	 * @param pagination     The result pagination.
	 * @return The request to execute.
	 */
	public Request<AssetHistory> getAssets(Pagination pagination) {
		Map<String, String> replaceMap = new HashMap<>() {
			{
				put("rows", "limit");
			}
		};
		return new Request<>(service.getAssets(new AssetParams().toMap(pagination, replaceMap)));
	}

	/**
	 * Get NFT assets.
	 * 
	 * @return The request to execute.
	 */
	public Request<AssetHistory> getAssets() {
		return new Request<>(service.getAssets(new AssetParams().toMap()));
	}
}
