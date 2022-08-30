package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.pay.dto.TradeHistory;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.configuration.Binance4jWeb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Controller for Pay endpoints.
 */
@RestController
@RequestMapping(Binance4jWeb.CONNECTORS_BASE_URI + "pay")
@Api(value = "Pay", tags = "Pay", produces = "application/json", description = "Pay endpoints")
public class PayController extends BaseController {
	/**
	 * Creates instance.
	 *
	 * @param connectors Binance4j connectors.
	 */
	public PayController(Connectors connectors) {
		super(connectors);
	}
	
	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 *
	 * @return Pay trades.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "trades")
	@ApiOperation(value = "Get pay trades.")
	public TradeHistory getTrades(
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().pay().getTrades(new TimeFrame(startTime, endTime, limit)).sync();
	}
}