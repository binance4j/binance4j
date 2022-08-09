package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.pay.dto.TradeHistory;
import com.binance4j.web.annotation.MyGetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Pay endpoints. */
@RestController
@RequestMapping("api/v1/pay")
@Api(value = "Pay", tags = "Pay", produces = "application/json", description = "Pay endpoints")
public class PayController extends BaseController {

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Pay trades.
	 * @throws ApiException Something went wrong with the API.
	 */
	@MyGetMapping(path = "trades")
	@ApiOperation(value = "Get pay trades.")
	public TradeHistory getTrades(@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.pay().getTrades(new TimeFrame(startTime, endTime, limit)).sync();
	}
}