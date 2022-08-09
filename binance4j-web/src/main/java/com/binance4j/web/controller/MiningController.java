package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
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
import com.binance4j.web.annotation.BaseApiResponses;
import com.binance4j.web.annotation.MyGetMapping;
import com.binance4j.web.annotation.MyPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Mining endpoints. */
@RestController
@RequestMapping("api/v1/mining")
@Api(value = "Mining", tags = "Mining", produces = "application/json", description = "Mining endpoints")
public class MiningController extends BaseController {

	/**
	 * @param algo     Algorithm.
	 * @param userName Username.
	 * @return Account list.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "accounts", produces = "application/json", params = {
			"algo", "userName"
	})
	@ApiOperation(value = "Get Account list.")
	@BaseApiResponses
	public AccountListResponse getAccounts(
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Algorithm.") String algo,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName)
			throws ApiException {
		return connectors.mining().getAccounts(new AccountListParams(algo, userName)).sync();
	}

	/**
	 * @return algorithms.
	 * @throws ApiException Something went wrong with the API.
	 */
	@MyGetMapping(path = "algorithms")
	@ApiOperation(value = "Get algorithms.")
	@BaseApiResponses
	public AlgorithmsResponse getAlgorithms() throws ApiException {
		return connectors.mining().getAlgorithms().sync();
	}

	/**
	 * @return Coins.
	 * @throws ApiException Something went wrong with the API.
	 */
	@MyGetMapping(path = "coins")
	@ApiOperation(value = "Get coins.")
	@BaseApiResponses
	public CoinsResponse getCoins() throws ApiException {
		return connectors.mining().getCoins().sync();
	}

	/**
	 * @param algo     Algorithm.
	 * @param userName Username.
	 * @return Statistic list.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "statistics", produces = "application/json", params = {
			"algo", "userName"
	})
	@ApiOperation(value = "Get Statistic list.")
	@BaseApiResponses
	public StatisticsResponse getStatistics(
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Algorithm.") String algo,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName)
			throws ApiException {
		return connectors.mining().getStatistics(new StatisticsParams(algo, userName)).sync();
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
	 * @throws ApiException Something went wrong with the API.
	 */
	@MyPostMapping(path = "resell")
	@ApiOperation(value = "Resell hashRate.")
	@BaseApiResponses
	public HashrateResaleResponse resellHashrate(
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Algorithm.") String algo,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName,
			@RequestParam(required = true) @ApiParam(value = "Start time in ms.") Long startDate,
			@RequestParam(required = true) @ApiParam(value = "End time in ms.") Long endDate,
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Mining Account.") String toPoolUser,
			@RequestParam(required = true) @ApiParam(example = "500000", value = "Resale hashrate h/s must be transferred (BTC is greater than 500000000000 ETH is greater than 500000).") Long hashRate)
			throws ApiException {
		return connectors.mining()
				.resellHashrate(new HashrateResaleParams(userName, algo, startDate, endDate, toPoolUser, hashRate))
				.sync();
	}

	/**
	 * Cancel hashrate resale configuration.
	 * 
	 * @param configId Config id.
	 * @param userName User name.
	 * @return Hahsrate cancellation response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "cancel-resale-config", produces = "application/json", params = {
			"configId", "userName"
	})
	@ApiOperation(value = "Cancel hashrate resale configuration.")
	@BaseApiResponses
	public HashrateResaleCancellationResponse cancelHashrateResaleConfiguration(
			@RequestParam(required = true) @ApiParam(example = "12345", value = "configId.") Integer configId,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName)
			throws ApiException {
		return connectors.mining()
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
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "profits", produces = "application/json", params = {
			"algo", "userName"
	})
	@ApiOperation(value = "Get earnings list.")
	@BaseApiResponses
	public ProfitResponse getProfits(
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Algorithm.") String algo,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.mining()
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
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "other-profits", produces = "application/json", params = {
			"algo", "userName"
	})
	@ApiOperation(value = "Get extra bonus list.")
	@BaseApiResponses
	public OtherProfitsResponse getOtherProfits(
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Algorithm.") String algo,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.mining()
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
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "account-profits", produces = "application/json", params = {
			"algo", "userName"
	})
	@ApiOperation(value = "Get mining account earning.")
	@BaseApiResponses
	public AccountProfitsResponse getAccountProfits(
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Algorithm.") String algo,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.mining().getAccountProfits(new AccountProfitsParams(algo, userName),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @return hashrate resale list.
	 * @throws ApiException Something went wrong with the API.
	 */
	@MyGetMapping(path = "resales")
	@ApiOperation(value = "Get hashrate resale list.")
	@BaseApiResponses
	public HashrateResaleListResponse getHashrateResales(
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.mining().getHashrateResales(new Paging(page, limit)).sync();
	}

	/**
	 * @param configId Config id.
	 * @param userName User name.
	 * @param page     Results page.
	 * @param limit    Results limit.
	 * @return Hashrate resale detail.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "resales-details", produces = "application/json", params = {
			"configId", "userName"
	})
	@ApiOperation(value = "Get hashrate resale detail.")
	@BaseApiResponses
	public HashrateResaleDetailResponse getHashrateResalesDetails(
			@RequestParam(required = true) @ApiParam(example = "12345", value = "configId.") Integer configId,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.mining()
				.getHashrateResalesDetails(new HashrateResaleDetailParam(configId, userName), new Paging(page, limit))
				.sync();
	}

	/**
	 * @param algo     Algorithm.
	 * @param userName Username.
	 * @return Miner list.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "miners", produces = "application/json", params = {
			"algo", "userName"
	})
	@ApiOperation(value = "Get miner list.")
	@BaseApiResponses
	public WorkersResponse getMiners(
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Algorithm.") String algo,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName)
			throws ApiException {
		return connectors.mining().getMiners(new MinersParams(algo, userName)).sync();
	}

	/**
	 * @param algo       Algorithm.
	 * @param userName   Username.
	 * @param workerName worker name.
	 * @return Detailed miner list.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "miner-details", produces = "application/json", params = {
			"algo", "userName", "workerName"
	})
	@ApiOperation(value = "Get detailed miner list.")
	@BaseApiResponses
	public MinerDetailsResponse getMinersDetails(
			@RequestParam(required = true) @ApiParam(example = "sha256", value = "Algorithm.") String algo,
			@RequestParam(required = true) @ApiParam(example = "userName", value = "Username.") String userName,
			@RequestParam(required = true) @ApiParam(example = "workerName", value = "Worker name.") String workerName)
			throws ApiException {
		return connectors.mining().getMinersDetails(new MinerDetailsParams(algo, userName, workerName)).sync();
	}

}