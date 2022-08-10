package com.binance4j.nft.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.nft.param.AssetParams;
import com.binance4j.nft.param.OperationParams;
import com.binance4j.nft.param.TransactionHistoryParams;
import com.binance4j.nft.request.GetAssetsRequest;
import com.binance4j.nft.request.GetDepositsRequest;
import com.binance4j.nft.request.GetTransactionsRequest;
import com.binance4j.nft.request.GetWithdrawsRequest;

/**
 * Api client for the NFT endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#nft-endpoints">Documentation</a>
 */
public class NFTClient extends RestClient<NFTMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public NFTClient(String key, String secret) {
		super(NFTMapping.class, key, secret);
	}

	/**
	 * Get NFT Transaction History.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTransactionsRequest getTransactions(TransactionHistoryParams params) {
		return new GetTransactionsRequest(service.getTransactions(params.toMap()));
	}

	/**
	 * Get NFT Transaction History.
	 * 
	 * @param params       Request params.
	 * @param framedPaging Paging.
	 * @return The request to execute.
	 */
	public GetTransactionsRequest getTransactions(TransactionHistoryParams params, FramedPaging framedPaging) {
		return new GetTransactionsRequest(service.getTransactions(Params.merge(params, framedPaging)));
	}

	/**
	 * Get NFT deposit History.
	 * 
	 * @param interval Time interval search.
	 * @return The request to execute.
	 */
	public GetDepositsRequest getDeposits(FramedPaging interval) {
		return new GetDepositsRequest(service.getDeposits(Params.merge(new OperationParams(), interval)));
	}

	/**
	 * Get NFT deposit History.
	 * 
	 * @return The request to execute.
	 */
	public GetDepositsRequest getDeposits() {
		return new GetDepositsRequest(service.getDeposits(new OperationParams().toMap()));
	}

	/**
	 * Get NFT withdraw History.
	 * 
	 * @param interval Time interval search.
	 * @return The request to execute.
	 */
	public GetWithdrawsRequest getWithdraws(FramedPaging interval) {
		return new GetWithdrawsRequest(service.getWithdraws(Params.merge(new OperationParams(), interval)));
	}

	/**
	 * Get NFT withdraw History.
	 * 
	 * @return The request to execute.
	 */
	public GetWithdrawsRequest getWithdraws() {
		return new GetWithdrawsRequest(service.getWithdraws(new OperationParams().toMap()));
	}

	/**
	 * Get NFT assets.
	 * 
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetAssetsRequest getAssets(Paging paging) {
		return new GetAssetsRequest(service.getAssets(Params.merge(new AssetParams().toMap(), paging.toMap())));
	}

	/**
	 * Get NFT assets.
	 * 
	 * @return The request to execute.
	 */
	public GetAssetsRequest getAssets() {
		return new GetAssetsRequest(service.getAssets(new AssetParams().toMap()));
	}
}
