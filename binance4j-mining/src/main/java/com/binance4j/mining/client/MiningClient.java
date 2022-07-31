package com.binance4j.mining.client;

import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Params;
import com.binance4j.mining.dto.AlgorithmsAquisitionResponse;
import com.binance4j.mining.dto.CoinsAquisitionResponse;
import com.binance4j.mining.dto.MinerDetailsResponse;
import com.binance4j.mining.dto.MinersResponse;
import com.binance4j.mining.param.AlgorithmsAquisitionParams;
import com.binance4j.mining.param.CoinsAquisitionParams;
import com.binance4j.mining.param.MinerDetailsParams;
import com.binance4j.mining.param.MinersParams;
import com.binance4j.mining.param.ProfitsParams;

/**
 * Api client for the NFT endpoints
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#mining-endpoints">Documentation</a>
 */
public class MiningClient extends RestClient<MiningMapping> {
	/**
	 * @param key    The API public key.
	 * @param secret The API secret key.
	 */
	public MiningClient(String key, String secret) {
		super(MiningMapping.class, key, secret);
	}

	/**
	 * Acquiring algorithms.
	 *
	 * @return The request to execute.
	 */
	public Request<AlgorithmsAquisitionResponse> getAlgorithms() {
		return new Request<>(service.getAlgorithms(new AlgorithmsAquisitionParams().toMap()));
	}

	/**
	 * Acquiring coin name.
	 *
	 * @return The request to execute.
	 */
	public Request<CoinsAquisitionResponse> getCoins() {
		return new Request<>(service.getCoins(new CoinsAquisitionParams().toMap()));
	}

	/**
	 * Request for detail miner list.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<MinerDetailsResponse> getMinersDetails(MinerDetailsParams params) {
		return new Request<>(service.getMinersDetails(params.toMap()));
	}

	/**
	 * Request for miner list.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<MinersResponse> getMiners(MinersParams params) {
		return new Request<>(service.getMiners(params.toMap()));
	}

	/**
	 * Earnings list.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> getProfits(ProfitsParams params, FramedPaging interval) {
		var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
		var map = Params.merge(params.toMap(), interval.toMap(replace));
		return new Request<>(service.getProfits(map));
	}

	/**
	 * Extra bonus list.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> getOtherProfits(Params params) {
		return new Request<>(service.getOtherProfits(params.toMap()));
	}

	/**
	 * Mining account earning.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> getAccountProfits(Params params) {
		return new Request<>(service.getAccountProfits(params.toMap()));
	}

	/**
	 * Hashrate resale list.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> getHashrateResales(Params params) {
		return new Request<>(service.getHashrateResales(params.toMap()));
	}

	/**
	 * Hashrate resale detail.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> getHashrateResalesDetails(Params params) {
		return new Request<>(service.getHashrateResalesDetails(params.toMap()));
	}

	/**
	 * Hashrate resale request.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> resellHashrate(Params params) {
		return new Request<>(service.resellHashrate(params.toMap()));
	}

	/**
	 * Cancel hashrate resale configuration.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> CancelHashrateResaleConfiguration(Params params) {
		return new Request<>(service.CancelHashrateResaleConfiguration(params.toMap()));
	}

	/**
	 * Statistic list.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> getStats(Params params) {
		return new Request<>(service.getStats(params.toMap()));
	}

	/**
	 * Account list.
	 *
	 * @param params The request params.
	 * @return The request to execute.
	 */
	public Request<Void> getAccounts(Params params) {
		return new Request<>(service.getAccounts(params.toMap()));
	}

}
