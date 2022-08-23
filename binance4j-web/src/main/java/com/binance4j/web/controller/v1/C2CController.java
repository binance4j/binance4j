package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.c2c.dto.TradeHistory;
import com.binance4j.c2c.dto.TradeType;
import com.binance4j.c2c.param.TradeHistoryParams;
import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.configuration.Binance4jConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for C2C endpoints. */
@RestController
@RequestMapping(Binance4jConfiguration.CONNECTORS_BASE_URI + "c2c")
@Api(value = "C2C", tags = "C2C", produces = "application/json", description = "Peer to Peer endpoints")
public class C2CController extends BaseController {

	/**
	 * Creates instance.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	public C2CController(Connectors connectors) {
		super(connectors);
	}

	/**
	 * @param tradeType Trade type.
	 * @return C2C trades.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "trades")
	@ApiOperation(value = "Get trades.")
	public TradeHistory getTrades(
			@RequestParam @ApiParam("The trade type") TradeType tradeType)
			throws ApiException {
		return connectors.rest().c2c().getTrades(new TradeHistoryParams(tradeType)).sync();
	}
}