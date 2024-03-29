package com.binance4j.web.controller.v1;

import java.util.List;

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
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Binance Leverage Token endpoints. */
@RestController
@RequestMapping("api/v1/blvt")
@Api(value = "BLVT", tags = "BLVT", produces = "application/json", description = "Binance Leverage Token endpoints")
public class BLVTController extends BaseController {

	/**
	 * @return BLVT client.
	 */
	private BLVTClient client() {
		return connectors.rest().blvt();
	}

	/**
	 * @param tokenName Get BLVT Info.
	 * @return BLVT Info.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "token-info")
	@ApiOperation(value = "Get info about one or multiple BLVT tokens")
	public List<Token> getTokenInfo(
			@RequestParam(required = false) @ApiParam(TOKEN_DESCRIPTION) String tokenName)
			throws ApiException {
		return client().getTokenInfo(new TokenInfoParams(tokenName)).sync();
	}

	/**
	 * @param tokenName Token name.
	 * @param id        Subscription id.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Subscription record.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "subscriptions")
	@ApiOperation(value = "Get subscription record.")
	public List<Subscription> getSubscriptions(
			@RequestParam(required = false) @ApiParam(TOKEN_DESCRIPTION) String tokenName,
			@RequestParam(required = false) @ApiParam("The subscription id") Long id,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getSubscriptions(new TransactionRecordParams(tokenName, id), new TimeFrame(startTime, endTime, limit))
				.sync();
	}

	/**
	 * @param tokenName Token name.
	 * @param id        Subscription id.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Redemption record.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "redemptions")
	@ApiOperation(value = "Get redemption record.")
	public List<Redemption> getRedemptions(
			@RequestParam(required = false) @ApiParam(TOKEN_DESCRIPTION) String tokenName,
			@RequestParam(required = false) @ApiParam("The subscription id") Long id,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getRedemptions(new TransactionRecordParams(tokenName, id), new TimeFrame(startTime, endTime, limit))
				.sync();
	}

	/**
	 * @param tokenName Token name.
	 * @return User limit info.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "limit-info")
	@ApiOperation(value = "Get user limit info.")
	public List<LimitInfo> getLimitInfo(
			@RequestParam(required = false) @ApiParam(TOKEN_DESCRIPTION) String tokenName)
			throws ApiException {
		return client().getLimitInfo(new LimitInfoParams(tokenName)).sync();
	}

	/**
	 * Subscribe BLVT.
	 * 
	 * @param tokenName Token name.
	 * @param amount    Amount to redeem.
	 * @return BLVT redemption response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "redeem")
	@ApiOperation(value = "Redeem BLVT.")
	public RedemptionResponse redeem(
			@RequestParam @ApiParam(TOKEN_DESCRIPTION) String tokenName,
			@RequestParam @ApiParam("The amount to redeem") String amount)
			throws ApiException {
		return client().redeem(new RedemptionParams(tokenName, amount)).sync();
	}

	/**
	 * @param tokenName Token name.
	 * @param cost      Amount to acquire.
	 * @return BVLT subscription response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "subscribe")
	@ApiOperation(value = "Subscribe to BLVT.")
	public SubscriptionResponse subscribe(
			@RequestParam @ApiParam(TOKEN_DESCRIPTION) String tokenName,
			@RequestParam @ApiParam("The amount to acquire") String cost)
			throws ApiException {
		return client().subscribe(new SubscriptionParams(tokenName, cost)).sync();
	}
}
