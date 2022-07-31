package com.binance4j.staking.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.staking.dto.AutoStakingResponse;
import com.binance4j.staking.dto.LeftQuota;
import com.binance4j.staking.dto.Product;
import com.binance4j.staking.dto.ProductPosition;
import com.binance4j.staking.dto.PurchaseResponse;
import com.binance4j.staking.dto.RedeemResponse;
import com.binance4j.staking.dto.StakingRecord;
import com.binance4j.staking.param.AutoStakingParams;
import com.binance4j.staking.param.HistoryParams;
import com.binance4j.staking.param.LeftQuotaParams;
import com.binance4j.staking.param.PositionParams;
import com.binance4j.staking.param.ProductListParams;
import com.binance4j.staking.param.PurchaseParams;
import com.binance4j.staking.param.RedeemParams;

/**
 * Api client for the staking endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#staking-endpoints">Documentation</a>
 */
public class StakingClient extends RestClient<StakingMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public StakingClient(String key, String secret) {
		super(StakingMapping.class, key, secret);
	}

	/**
	 * Get available Staking product list.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<Product>> getProducts(ProductListParams params) {
		return new Request<>(service.getProductList(params.toMap()));
	}

	/**
	 * Get available Staking product list.
	 * 
	 * @param params     The request params.
	 * @param pagination The search pagination.
	 * @return The request to execute.
	 */
	public Request<List<Product>> getProducts(ProductListParams params, Paging pagination) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new Request<>(service.getProductList(Params.merge(params.toMap(), pagination.toMap(replaceMap))));
	}

	/**
	 * Purchase Staking product.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<PurchaseResponse> purchase(PurchaseParams params) {
		return new Request<>(service.purchase(params.toMap()));
	}

	/**
	 * Redeem Staking product.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<RedeemResponse> redeem(RedeemParams params) {
		return new Request<>(service.redeem(params.toMap()));
	}

	/**
	 * Get Staking product position.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<ProductPosition>> getPosition(PositionParams params) {
		return new Request<>(service.getPosition(params.toMap()));
	}

	/**
	 * Get Staking product position.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<ProductPosition>> getPosition(PositionParams params, Paging pagination) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new Request<>(service.getPosition(Params.merge(params.toMap(), pagination.toMap(replaceMap))));
	}

	/**
	 * Get Staking product position.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<List<StakingRecord>> getHistory(HistoryParams params) {
		return new Request<>(service.getHistory(params.toMap()));
	}

	/**
	 * Get Staking product position.
	 * 
	 * @param params   The request params.
	 * @param interval The search interval.
	 * @return The request to execute.
	 */
	public Request<List<StakingRecord>> getHistory(HistoryParams params, FramedPaging interval) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new Request<>(service.getHistory(Params.merge(params.toMap(), interval.toMap(replaceMap))));
	}

	/**
	 * Set auto staking on Locked Staking or Locked DeFi Staking.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<AutoStakingResponse> setAutoStaking(AutoStakingParams params) {
		return new Request<>(service.setAutoStaking(params.toMap()));
	}

	/**
	 * Get personal left quota of Staking product.
	 * 
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<LeftQuota> getLeftQuota(LeftQuotaParams params) {
		return new Request<>(service.getLeftQuota(params.toMap()));
	}
}
