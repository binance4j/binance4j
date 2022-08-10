package com.binance4j.mining.client;

import java.util.Map;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
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
import com.binance4j.mining.request.CancelHashrateResaleConfigurationRequest;
import com.binance4j.mining.request.GetAccountProfitstRequest;
import com.binance4j.mining.request.GetAccountsRequest;
import com.binance4j.mining.request.GetAlgorithmsRequest;
import com.binance4j.mining.request.GetCoinsRequest;
import com.binance4j.mining.request.GetHashrateResalesDetailsRequest;
import com.binance4j.mining.request.GetHashrateResalesRequest;
import com.binance4j.mining.request.GetMinersDetailsRequest;
import com.binance4j.mining.request.GetMinersRequest;
import com.binance4j.mining.request.GetOtherProfitsRequest;
import com.binance4j.mining.request.GetProfitsRequest;
import com.binance4j.mining.request.GetStatisticsRequest;
import com.binance4j.mining.request.ResellHashrateRequest;

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
	public GetAlgorithmsRequest getAlgorithms() {
		return new GetAlgorithmsRequest(service.getAlgorithms(new AlgorithmsAquisitionParams().toMap()));
	}

	/**
	 * Acquiring coin name.
	 *
	 * @return The request to execute.
	 */
	public GetCoinsRequest getCoins() {
		return new GetCoinsRequest(service.getCoins(new CoinsAquisitionParams().toMap()));
	}

	/**
	 * Request for detail miner list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetMinersDetailsRequest getMinersDetails(MinerDetailsParams params) {
		return new GetMinersDetailsRequest(service.getMinersDetails(params.toMap()));
	}

	/**
	 * Request for miner list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetMinersRequest getMiners(MinersParams params) {
		return new GetMinersRequest(service.getMiners(params.toMap()));
	}

	/**
	 * Get earnings list.
	 *
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetProfitsRequest getProfits(ProfitsParams params, FramedPaging paging) {
		var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
		return new GetProfitsRequest(service.getProfits(Params.merge(params.toMap(), paging.toMap(replace))));
	}

	/**
	 * Get extra bonus list.
	 *
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetOtherProfitsRequest getOtherProfits(ProfitsParams params, FramedPaging paging) {
		var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
		return new GetOtherProfitsRequest(service.getOtherProfits(Params.merge(params.toMap(), paging.toMap(replace))));
	}

	/**
	 * Get mining account earning.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAccountProfitstRequest getAccountProfits(AccountProfitsParams params) {
		return new GetAccountProfitstRequest(service.getAccountProfits(params.toMap()));
	}

	/**
	 * Get mining account earning.
	 *
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetAccountProfitstRequest getAccountProfits(AccountProfitsParams params, FramedPaging paging) {
		var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
		return new GetAccountProfitstRequest(
				service.getAccountProfits(Params.merge(params.toMap(), paging.toMap(replace))));
	}

	/**
	 * Get hashrate resale list.
	 * 
	 * @return The request to execute.
	 */
	public GetHashrateResalesRequest getHashrateResales() {
		return new GetHashrateResalesRequest(service.getHashrateResales(new HashrateResaleListParams().toMap()));
	}

	/**
	 * Get hashrate resale list.
	 *
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetHashrateResalesRequest getHashrateResales(Paging paging) {
		var replace = Map.of("page", "pageIndex", "limit", "pageSize");
		return new GetHashrateResalesRequest(service
				.getHashrateResales(Params.merge(new HashrateResaleListParams().toMap(), paging.toMap(replace))));
	}

	/**
	 * Get hashrate resale detail.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetHashrateResalesDetailsRequest getHashrateResalesDetails(HashrateResaleDetailParam params) {
		return new GetHashrateResalesDetailsRequest(service.getHashrateResalesDetails(params.toMap()));
	}

	/**
	 * Get hashrate resale detail.
	 *
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetHashrateResalesDetailsRequest getHashrateResalesDetails(HashrateResaleDetailParam params,
			Paging paging) {
		var replace = Map.of("page", "pageIndex", "limit", "pageSize");
		return new GetHashrateResalesDetailsRequest(
				service.getHashrateResalesDetails(Params.merge(params.toMap(), paging.toMap(replace))));
	}

	/**
	 * Hashrate resale request.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public ResellHashrateRequest resellHashrate(HashrateResaleParams params) {
		return new ResellHashrateRequest(service.resellHashrate(params.toMap()));
	}

	/**
	 * Cancel hashrate resale configuration.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public CancelHashrateResaleConfigurationRequest cancelHashrateResaleConfiguration(
			HashrateResaleCancellationParams params) {
		return new CancelHashrateResaleConfigurationRequest(service.cancelHashrateResaleConfiguration(params.toMap()));
	}

	/**
	 * Get Statistic list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetStatisticsRequest getStatistics(StatisticsParams params) {
		return new GetStatisticsRequest(service.getStatistics(params.toMap()));
	}

	/**
	 * Get Account list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAccountsRequest getAccounts(AccountListParams params) {
		return new GetAccountsRequest(service.getAccounts(params.toMap()));
	}
}
