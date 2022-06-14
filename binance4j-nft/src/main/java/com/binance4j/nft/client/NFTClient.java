package com.binance4j.nft.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.nft.asset.NFTAssetHistory;
import com.binance4j.nft.asset.NFTAssetRequest;
import com.binance4j.nft.deposit.NFTDepositHistory;
import com.binance4j.nft.deposit.NFTDepositHistoryRequest;
import com.binance4j.nft.transaction.NFTTransactionHistory;
import com.binance4j.nft.transaction.NFTTransactionHistoryRequest;
import com.binance4j.nft.withdraw.NFTWithdrawHistory;
import com.binance4j.nft.withdraw.NFTWithdrawRequest;

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
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#get-nft-transaction-history-user_data">Documentation</a>
	 */
	public RequestExecutor<NFTTransactionHistory> getTransactions(NFTTransactionHistoryRequest req) {
		return new RequestExecutor<>(service.getTransactions(req.toMap()));
	}

	/**
	 * Get NFT deposit History.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#get-nft-deposit-history-user_data">Documentation</a>
	 */
	public RequestExecutor<NFTDepositHistory> getDeposits(NFTDepositHistoryRequest req) {
		return new RequestExecutor<>(service.getDeposits(req.toMap()));
	}

	/**
	 * Get NFT withdraw History.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#get-nft-withdraw-history-user_data">Documentation</a>
	 */
	public RequestExecutor<NFTWithdrawHistory> getWithdraws(NFTWithdrawRequest req) {
		return new RequestExecutor<>(service.getWithdraws(req.toMap()));
	}

	/**
	 * Get NFT assets.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#get-nft-asset-user_data">Documentation</a>
	 */
	public RequestExecutor<NFTAssetHistory> getAssets(NFTAssetRequest req) {
		return new RequestExecutor<>(service.getAssets(req.toMap()));
	}
}
