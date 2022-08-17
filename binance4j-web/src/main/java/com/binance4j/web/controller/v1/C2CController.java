package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.c2c.dto.TradeHistory;
import com.binance4j.c2c.dto.TradeType;
import com.binance4j.c2c.param.TradeHistoryParams;
import com.binance4j.core.exception.ApiException;
import com.binance4j.web.annotation.JsonGetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/** Controller for C2C endpoints. */
@RestController
@RequestMapping("api/v1/c2c")
@Api(value = "C2C", tags = "C2C", produces = "application/json", description = "Peer to Peer endpoints")
public class C2CController extends BaseController {

	/**
	 * @param tradeType Trade type.
	 * @return C2C trades.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "trades")
	@ApiOperation(value = "Get trades.")
	public TradeHistory getTrades(
			@RequestParam(name = "The trade type") TradeType tradeType)
			throws ApiException {
		return connectors.rest().c2c().getTrades(new TradeHistoryParams(tradeType)).sync();
	}
}