package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.c2c.dto.TradeHistory;
import com.binance4j.c2c.dto.TradeType;
import com.binance4j.c2c.param.TradeHistoryParams;
import com.binance4j.core.exception.ApiException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("api/v1/c2c")
@Api(value = "C2C Controller", tags = "C2C Controller", produces = "application/json", description = "Peer to Peer endpoints")
public class C2CController extends BaseController {

	@GetMapping(path = "trades", produces = "application/json")
	@ApiOperation(value = "Get trades.")
	public TradeHistory getTrades(@RequestParam(required = true) @ApiParam(example = "BUY", value = "The trade type") TradeType tradeType) throws ApiException {
		return connectors.c2c().getTrades(new TradeHistoryParams(tradeType)).sync();
	}
}