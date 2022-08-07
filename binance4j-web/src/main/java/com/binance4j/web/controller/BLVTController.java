package com.binance4j.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.blvt.client.BLVTClient;
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
import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("api/v1/blvt")
@Api(value = "BLVT Controller", tags = "BLVT Controller", produces = "application/json", description = "Binance Leverage Token endpoints")
public class BLVTController {

	BLVTClient client;

	public BLVTController(Connectors connectors) {
		this.client = connectors.blvt();
	}

	/**
	 * @param tokenName Get BLVT Info.
	 * @return BLVT Info.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "tokenInfo", produces = "application/json")
	@ApiOperation(value = "Returns info about one or multiple BLVT tokens")
	public List<Token> getTokenInfo(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName)
			throws ApiException {
		return client.getTokenInfo(new TokenInfoParams(tokenName)).sync();
	}

	@GetMapping(path = "subscriptions", produces = "application/json")
	@ApiOperation(value = "Get subscription record.")
	public List<Subscription> getSubscriptions(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName,
			@RequestParam(required = false) @ApiParam(example = "1234", value = "The subscription id") Long id,
			@RequestParam(required = false) @ApiParam(example = "1659824617000", value = "Start time in ms") Long startTime,
			@RequestParam(required = false) @ApiParam(example = "1659824617000", value = "End time in ms") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit") Integer limit) throws ApiException {
		return client.getSubscriptions(new TransactionRecordParams(tokenName, id), new TimeFrame(startTime, endTime, limit)).sync();
	}

	@GetMapping(path = "redemptions", produces = "application/json")
	@ApiOperation(value = "Get redemption record.")
	public List<Redemption> getRedemptions(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName,
			@RequestParam(required = false) @ApiParam(example = "1234", value = "The subscription id") Long id,
			@RequestParam(required = false) @ApiParam(example = "1659824617000", value = "Start time in ms") Long startTime,
			@RequestParam(required = false) @ApiParam(example = "1659824617000", value = "End time in ms") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit") Integer limit) throws ApiException {
		return client.getRedemptions(new TransactionRecordParams(tokenName, id), new TimeFrame(startTime, endTime, limit)).sync();
	}

	@GetMapping(path = "limitInfo", produces = "application/json")
	@ApiOperation(value = "Get user limit info.")
	public List<LimitInfo> getLimitInfo(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName)
			throws ApiException {
		return client.getLimitInfo(new LimitInfoParams(tokenName)).sync();
	}

	@PostMapping(path = "redeem", produces = "application/json")
	@ApiOperation(value = "Redeem BLVT.")
	public RedemptionResponse redeem(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName,
			@RequestParam(required = false) @ApiParam(example = "1000", value = "The amount to redeem") String amount) throws ApiException {
		return client.redeem(new RedemptionParams(tokenName, amount)).sync();
	}

	@PostMapping(path = "subscribe", produces = "application/json")
	@ApiOperation(value = "Subscribe BLVT.")
	public SubscriptionResponse subscribe(@RequestParam(required = false) @ApiParam(example = "1INCHUP", value = "The token name") String tokenName,
			@RequestParam(required = false) @ApiParam(example = "1000", value = "The amount to acquire") String cost) throws ApiException {
		return client.subscribe(new SubscriptionParams(tokenName, cost)).sync();
	}
}
