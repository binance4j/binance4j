package com.binance4j.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.blvt.dto.LimitInfo;
import com.binance4j.blvt.dto.Redemption;
import com.binance4j.blvt.dto.RedemptionResponse;
import com.binance4j.blvt.dto.Subscription;
import com.binance4j.blvt.dto.SubscriptionResponse;
import com.binance4j.blvt.dto.Token;
import com.binance4j.blvt.param.LimitInfoParams;
import com.binance4j.blvt.param.RedemptionParams;
import com.binance4j.blvt.param.SubscriptionParams;
import com.binance4j.blvt.param.TokenInfoParams;
import com.binance4j.blvt.param.TransactionRecordParams;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Binance Leverage Token endpoints. */
@RestController
@RequestMapping("api/v1/blvt")
@Api(value = "BLVT", tags = "BLVT", produces = "application/json", description = "Binance Leverage Token endpoints")
public class BLVTController extends BaseController {
	/**
	 * @param tokenName Get BLVT Info.
	 * @return BLVT Info.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "token-info", produces = "application/json")
	@ApiOperation(value = "Get info about one or multiple BLVT tokens")
	public List<Token> getTokenInfo(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName)
			throws ApiException {
		return connectors.blvt().getTokenInfo(new TokenInfoParams(tokenName)).sync();
	}

	/**
	 * @param tokenName Token name.
	 * @param id        Subscription id.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Subscription record.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "subscriptions", produces = "application/json")
	@ApiOperation(value = "Get subscription record.")
	public List<Subscription> getSubscriptions(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName,
			@RequestParam(required = false) @ApiParam(example = "1234", value = "The subscription id") Long id,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.blvt().getSubscriptions(new TransactionRecordParams(tokenName, id), new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @param tokenName Token name.
	 * @param id        Subscription id.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Redemption record.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "redemptions", produces = "application/json")
	@ApiOperation(value = "Get redemption record.")
	public List<Redemption> getRedemptions(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName,
			@RequestParam(required = false) @ApiParam(example = "1234", value = "The subscription id") Long id,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.blvt().getRedemptions(new TransactionRecordParams(tokenName, id), new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @param tokenName Token name.
	 * @return User limit info.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "limit-info", produces = "application/json")
	@ApiOperation(value = "Get user limit info.")
	public List<LimitInfo> getLimitInfo(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName)
			throws ApiException {
		return connectors.blvt().getLimitInfo(new LimitInfoParams(tokenName)).sync();
	}

	/**
	 * Subscribe BLVT.
	 * 
	 * @param tokenName Token name.
	 * @param amount    Amount to redeem.
	 * @return BLVT redemption response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "redeem", produces = "application/json")
	@ApiOperation(value = "Redeem BLVT.")
	public RedemptionResponse redeem(@RequestParam(required = true) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName,
			@RequestParam(required = true) @ApiParam(example = "1000", value = "The amount to redeem") String amount) throws ApiException {
		return connectors.blvt().redeem(new RedemptionParams(tokenName, amount)).sync();
	}

	/**
	 * @param tokenName Token name.
	 * @param cost      Amount to acquire.
	 * @return BVLT subscription response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "subscribe", produces = "application/json")
	@ApiOperation(value = "Subscribe to BLVT.")
	public SubscriptionResponse subscribe(@RequestParam(required = true) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName,
			@RequestParam(required = true) @ApiParam(example = "1000", value = "The amount to acquire") String cost) throws ApiException {
		return connectors.blvt().subscribe(new SubscriptionParams(tokenName, cost)).sync();
	}
}
