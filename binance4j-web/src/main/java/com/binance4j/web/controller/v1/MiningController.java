package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.mining.client.MiningClient;
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
import com.binance4j.mining.param.HashrateResaleCancellationParams;
import com.binance4j.mining.param.HashrateResaleDetailParam;
import com.binance4j.mining.param.HashrateResaleParams;
import com.binance4j.mining.param.MinerDetailsParams;
import com.binance4j.mining.param.MinersParams;
import com.binance4j.mining.param.ProfitsParams;
import com.binance4j.mining.param.StatisticsParams;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Mining endpoints. */
@RestController
@RequestMapping(path = "api/v1/mining")
@Api(value = "Mining", tags = "Mining", produces = "application/json", description = "Mining endpoints")
public class MiningController extends BaseController {

	/**
	 * @return Mining client.
	 */
	private MiningClient client() {
		return connectors.rest().mining();
	}

	/**
	 * @param algo     Algorithm.
	 * @param userName Username.
	 * @return Account list.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "accounts")
	@ApiOperation(value = "Get Account list.")
	public AccountListResponse getAccounts(
			@RequestParam @ApiParam(ALGO_DESCRIPTION) String algo,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName)
			throws ApiException {
		return client().getAccounts(new AccountListParams(algo, userName)).sync();
	}

	/**
	 * @return algorithms.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "algorithms")
	@ApiOperation(value = "Get algorithms.")
	public AlgorithmsResponse getAlgorithms() throws ApiException {
		return client().getAlgorithms().sync();
	}

	/**
	 * @return Coins.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "coins")
	@ApiOperation(value = "Get coins.")
	public CoinsResponse getCoins() throws ApiException {
		return client().getCoins().sync();
	}

	/**
	 * @param algo     Algorithm.
	 * @param userName Username.
	 * @return Statistic list.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "statistics")
	@ApiOperation(value = "Get Statistic list.")
	public StatisticsResponse getStatistics(
			@RequestParam @ApiParam(ALGO_DESCRIPTION) String algo,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName)
			throws ApiException {
		return client().getStatistics(new StatisticsParams(algo, userName)).sync();
	}

	/**
	 * Resell Hashrate.
	 * 
	 * @param userName   Mining Account test.
	 * @param algo       Transfer algorithm.
	 * @param endDate    Resale End Time in ms.
	 * @param startDate  Resale Start Time in ms.
	 * @param toPoolUser Mining Account.
	 * @param hashRate   Resale hashrate h/s must be transferred (BTC is greater
	 *                   than 500000000000 ETH is greater than
	 *                   500000).
	 * @return Hashrate Resale response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "resell")
	@ApiOperation(value = "Resell hashRate.")
	public HashrateResaleResponse resellHashrate(
			@RequestParam @ApiParam(ALGO_DESCRIPTION) String algo,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName,
			@RequestParam @ApiParam(START_TIME_DESCRIPTION) Long startDate,
			@RequestParam @ApiParam(END_TIME_DESCRIPTION) Long endDate,
			@RequestParam @ApiParam("Mining Account.") String toPoolUser,
			@RequestParam @ApiParam("Resale hashrate h/s must be transferred (BTC is greater than 500000000000 ETH is greater than 500000).") Long hashRate)
			throws ApiException {
		return client()
				.resellHashrate(new HashrateResaleParams(userName, algo, startDate, endDate, toPoolUser, hashRate))
				.sync();
	}

	/**
	 * Cancel hashrate resale configuration.
	 * 
	 * @param configId Config id.
	 * @param userName User name.
	 * @return Hahsrate cancellation response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "cancel-resale-config")
	@ApiOperation(value = "Cancel hashrate resale configuration.")
	public HashrateResaleCancellationResponse cancelHashrateResaleConfiguration(
			@RequestParam @ApiParam(CONFIG_ID_DESCRIPTION) Integer configId,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName)
			throws ApiException {
		return client()
				.cancelHashrateResaleConfiguration(new HashrateResaleCancellationParams(configId, userName)).sync();
	}

	/**
	 * @param algo      Algorithm.
	 * @param userName  Username.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @return Earnings list.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "profits")
	@ApiOperation(value = "Get earnings list.")
	public ProfitResponse getProfits(
			@RequestParam @ApiParam(ALGO_DESCRIPTION) String algo,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getProfits(new ProfitsParams(algo, userName), new FramedPaging(startTime, endTime, page, limit))
				.sync();
	}

	/**
	 * @param algo      Algorithm.
	 * @param userName  Username.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @return Extra bonus list.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "other-profits")
	@ApiOperation(value = "Get extra bonus list.")
	public OtherProfitsResponse getOtherProfits(
			@RequestParam @ApiParam(ALGO_DESCRIPTION) String algo,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getOtherProfits(new ProfitsParams(algo, userName), new FramedPaging(startTime, endTime, page, limit))
				.sync();
	}

	/**
	 * @param algo      Algorithm.
	 * @param userName  Username.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @return Mining account earning.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "account-profits")
	@ApiOperation(value = "Get mining account earning.")
	public AccountProfitsResponse getAccountProfits(
			@RequestParam @ApiParam(ALGO_DESCRIPTION) String algo,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getAccountProfits(new AccountProfitsParams(algo, userName),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @return hashrate resale list.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "resales")
	@ApiOperation(value = "Get hashrate resale list.")
	public HashrateResaleListResponse getHashrateResales(
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getHashrateResales(new Paging(page, limit)).sync();
	}

	/**
	 * @param configId Config id.
	 * @param userName User name.
	 * @param page     Results page.
	 * @param limit    Results limit.
	 * @return Hashrate resale detail.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "resales-details")
	@ApiOperation(value = "Get hashrate resale detail.")
	public HashrateResaleDetailResponse getHashrateResalesDetails(
			@RequestParam @ApiParam(CONFIG_ID_DESCRIPTION) Integer configId,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getHashrateResalesDetails(new HashrateResaleDetailParam(configId, userName), new Paging(page, limit))
				.sync();
	}

	/**
	 * @param algo     Algorithm.
	 * @param userName Username.
	 * @return Miner list.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "miners")
	@ApiOperation(value = "Get miner list.")
	public WorkersResponse getMiners(
			@RequestParam @ApiParam(ALGO_DESCRIPTION) String algo,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName)
			throws ApiException {
		return client().getMiners(new MinersParams(algo, userName)).sync();
	}

	/**
	 * @param algo       Algorithm.
	 * @param userName   Username.
	 * @param workerName worker name.
	 * @return Detailed miner list.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "miner-details")
	@ApiOperation(value = "Get detailed miner list.")
	public MinerDetailsResponse getMinersDetails(
			@RequestParam @ApiParam(ALGO_DESCRIPTION) String algo,
			@RequestParam @ApiParam(USERNAME_DESCRIPTION) String userName,
			@RequestParam @ApiParam(WORKER_DESCRIPTION) String workerName)
			throws ApiException {
		return client().getMinersDetails(new MinerDetailsParams(algo, userName, workerName)).sync();
	}

}