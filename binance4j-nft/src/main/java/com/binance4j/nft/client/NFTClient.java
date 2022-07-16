package com.binance4j.nft.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.nft.dto.NFTAssetHistory;
import com.binance4j.nft.dto.NFTDepositHistory;
import com.binance4j.nft.dto.NFTTransactionHistory;
import com.binance4j.nft.dto.NFTWithdrawHistory;
import com.binance4j.nft.param.NFTAssetParams;
import com.binance4j.nft.param.NFTDepositHistoryParams;
import com.binance4j.nft.param.NFTTransactionHistoryParams;
import com.binance4j.nft.param.NFTWithdrawParams;

/**
 * Api client for the NFT endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#nft-endpoints">Documentation</a>
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

	/** Get NFT Transaction History. */
	public Request<NFTTransactionHistory> getTransactions(NFTTransactionHistoryParams params) {
		return new Request<>(service.getTransactions(params.toMap()));
	}

	/** Get NFT deposit History. */
	public Request<NFTDepositHistory> getDeposits(NFTDepositHistoryParams params) {
		return new Request<>(service.getDeposits(params.toMap()));
	}

	/** Get NFT withdraw History. */
	public Request<NFTWithdrawHistory> getWithdraws(NFTWithdrawParams params) {
		return new Request<>(service.getWithdraws(params.toMap()));
	}

	/** Get NFT assets. */
	public Request<NFTAssetHistory> getAssets(NFTAssetParams params) {
		return new Request<>(service.getAssets(params.toMap()));
	}
}
