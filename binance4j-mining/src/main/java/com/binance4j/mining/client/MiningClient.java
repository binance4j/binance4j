package com.binance4j.mining.client;

import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.mining.dto.AccountListResponse;
import com.binance4j.mining.dto.AccountProfitsResponse;
import com.binance4j.mining.dto.AlgorithmsResponse;
import com.binance4j.mining.dto.CoinsResponse;
import com.binance4j.mining.dto.HashrateResaleCancellationResponse;
import com.binance4j.mining.dto.HashrateResaleDetailResponse;
import com.binance4j.mining.dto.HashrateResaleListResponse;
import com.binance4j.mining.dto.HashrateResaleResponse;
import com.binance4j.mining.dto.MinerDetailsResponse;
import com.binance4j.mining.dto.OtherProfitsResponse;
import com.binance4j.mining.dto.ProfitResponse;
import com.binance4j.mining.dto.StatisticsResponse;
import com.binance4j.mining.dto.WorkersResponse;
import com.binance4j.mining.param.AccountListParams;
import com.binance4j.mining.param.AccountProfitsParams;
import com.binance4j.mining.param.AlgorithmsAquisitionParams;
import com.binance4j.mining.param.CoinsAquisitionParams;
import com.binance4j.mining.param.HashrateResaleCancellationParams;
import com.binance4j.mining.param.HashrateResaleDetailParam;
import com.binance4j.mining.param.HashrateResaleListParams;
import com.binance4j.mining.param.HashrateResaleParams;
import com.binance4j.mining.param.MinerDetailsParams;
import com.binance4j.mining.param.MinersParams;
import com.binance4j.mining.param.ProfitsParams;
import com.binance4j.mining.param.StatisticsParams;

/**
 * Api client for the NFT endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#mining-endpoints">Documentation</a>
 */
public class MiningClient extends RestClient<MiningMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public MiningClient(String key, String secret) {
		super(MiningMapping.class, key, secret);
	}

	/**
	 * Acquiring algorithms.
	 *
	 * @return The request to execute.
	 */
	public Request<AlgorithmsResponse> getAlgorithms() {
		return new Request<>(service.getAlgorithms(new AlgorithmsAquisitionParams().toMap()));
	}

	/**
	 * Acquiring coin name.
	 *
	 * @return The request to execute.
	 */
	public Request<CoinsResponse> getCoins() {
		return new Request<>(service.getCoins(new CoinsAquisitionParams().toMap()));
	}

	/**
	 * Request for detail miner list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<MinerDetailsResponse> getMinersDetails(MinerDetailsParams params) {
		return new Request<>(service.getMinersDetails(params.toMap()));
	}

	/**
	 * Request for miner list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<WorkersResponse> getMiners(MinersParams params) {
		return new Request<>(service.getMiners(params.toMap()));
	}

	/**
	 * Get earnings list.
	 *
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<ProfitResponse> getProfits(ProfitsParams params, FramedPaging paging) {
		var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
		return new Request<>(service.getProfits(Params.merge(params.toMap(), paging.toMap(replace))));
	}

	/**
	 * Get extra bonus list.
	 *
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<OtherProfitsResponse> getOtherProfits(ProfitsParams params, FramedPaging paging) {
		var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
		return new Request<>(service.getOtherProfits(Params.merge(params.toMap(), paging.toMap(replace))));
	}

	/**
	 * Get mining account earning.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<AccountProfitsResponse> getAccountProfits(AccountProfitsParams params) {
		return new Request<>(service.getAccountProfits(params.toMap()));
	}

	/**
	 * Get mining account earning.
	 *
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<AccountProfitsResponse> getAccountProfits(AccountProfitsParams params, FramedPaging paging) {
		var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
		return new Request<>(service.getAccountProfits(Params.merge(params.toMap(), paging.toMap(replace))));
	}

	/**
	 * Get hashrate resale list.
	 * 
	 * @return The request to execute.
	 */
	public Request<HashrateResaleListResponse> getHashrateResales() {
		return new Request<>(service.getHashrateResales(new HashrateResaleListParams().toMap()));
	}

	/**
	 * Get hashrate resale list.
	 *
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<HashrateResaleListResponse> getHashrateResales(Paging paging) {
		var replace = Map.of("page", "pageIndex", "limit", "pageSize");
		return new Request<>(service
				.getHashrateResales(Params.merge(new HashrateResaleListParams().toMap(), paging.toMap(replace))));
	}

	/**
	 * Get hashrate resale detail.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<HashrateResaleDetailResponse> getHashrateResalesDetails(HashrateResaleDetailParam params) {
		return new Request<>(service.getHashrateResalesDetails(params.toMap()));
	}

	/**
	 * Get hashrate resale detail.
	 *
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<HashrateResaleDetailResponse> getHashrateResalesDetails(HashrateResaleDetailParam params,
			Paging paging) {
		var replace = Map.of("page", "pageIndex", "limit", "pageSize");
		return new Request<>(service.getHashrateResalesDetails(Params.merge(params.toMap(), paging.toMap(replace))));
	}

	/**
	 * Hashrate resale request.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<HashrateResaleResponse> resellHashrate(HashrateResaleParams params) {
		return new Request<>(service.resellHashrate(params.toMap()));
	}

	/**
	 * Cancel hashrate resale configuration.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<HashrateResaleCancellationResponse> cancelHashrateResaleConfiguration(
			HashrateResaleCancellationParams params) {
		return new Request<>(service.cancelHashrateResaleConfiguration(params.toMap()));
	}

	/**
	 * Get Statistic list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<StatisticsResponse> getStatistics(StatisticsParams params) {
		return new Request<>(service.getStatistics(params.toMap()));
	}

	/**
	 * Get Account list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<AccountListResponse> getAccounts(AccountListParams params) {
		return new Request<>(service.getAccounts(params.toMap()));
	}
}
