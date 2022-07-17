package com.binance4j.nft.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.nft.dto.AssetHistory;
import com.binance4j.nft.dto.DepositHistory;
import com.binance4j.nft.dto.TransactionHistory;
import com.binance4j.nft.dto.WithdrawHistory;
import com.binance4j.nft.param.AssetParams;
import com.binance4j.nft.param.DepositHistoryParams;
import com.binance4j.nft.param.TransactionHistoryParams;
import com.binance4j.nft.param.WithdrawParams;

/**
 * Api client for the NFT endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#nft-endpoints">Documentation</a>
 */
public class NFTClient extends RestClient<NFTMapping> {
	/**
	 * Instantiates a client for the market data endpoints.
	 *
	 * @param key    The API public key
	 * @param secret The API secret key
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
	 * Get NFT deposit History.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<DepositHistory> getDeposits(DepositHistoryParams params) {
		return new Request<>(service.getDeposits(params.toMap()));
	}

	/**
	 * Get NFT deposit History.
	 * 
	 * @return The request to execute.
	 */
	public Request<DepositHistory> getDeposits() {
		return getDeposits(new DepositHistoryParams());
	}

	/**
	 * Get NFT withdraw History.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<WithdrawHistory> getWithdraws(WithdrawParams params) {
		return new Request<>(service.getWithdraws(params.toMap()));
	}

	/**
	 * Get NFT withdraw History.
	 * 
	 * @return The request to execute.
	 */
	public Request<WithdrawHistory> getWithdraws() {
		return getWithdraws(new WithdrawParams());
	}

	/**
	 * Get NFT assets.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<AssetHistory> getAssets(AssetParams params) {
		return new Request<>(service.getAssets(params.toMap()));
	}

	/**
	 * Get NFT assets.
	 * 
	 * @return The request to execute.
	 */
	public Request<AssetHistory> getAssets() {
		return getAssets(new AssetParams());
	}
}
