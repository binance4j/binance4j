package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.StopLossLimitOrder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Spot endpoints. */
@RestController
@RequestMapping("api/v1/spot")
@Api(value = "Spot", tags = "Spot", produces = "application/json", description = "Spot endpoints")
public class SpotControllerTodo extends BaseController {

	/**
	 * TODO
	 * Tests an order.
	 * 
	 * @param order Order to submit.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "order-test")
	@ApiOperation(value = "Tests an order.")
	@ApiImplicitParams({
	})
	public Void newOrderTest(
			@RequestParam(required = true) @ApiParam(required = true, value = "The order symbol") String symbol,
			@RequestParam(required = true) @ApiParam(required = true, value = "The order side") OrderSide side,
			@RequestParam(required = true) @ApiParam(required = true, value = "The order quantity") String quantity,
			@RequestParam(required = true) @ApiParam(required = true, value = "The order type") OrderType type,
			@RequestParam(required = false) @ApiParam(required = false, value = "The order price") String price,
			@RequestParam(required = false) @ApiParam(required = false, value = "Le order lifetime") TimeInForce timeInForce,
			@RequestParam(required = false) @ApiParam(required = false, value = "The stop price") String stopPrice,
			@RequestParam(required = false) @ApiParam(required = false, value = "The order response type Default: RESULT.") NewOrderResponseType newOrderRespType,
			@RequestParam(required = false) @ApiParam(required = false, value = "The quote order quantity") String quoteOrderQuantity,
			@RequestParam(required = false) @ApiParam(required = false, value = "The iceberg quantity") String icebergQuantity,
			@RequestParam(required = false) @ApiParam(required = false, value = "The order unique id. Else is produced automatically.") String newClientOrderId,
			@RequestParam(required = false) @ApiParam(required = false, value = "Stop Limit price.") String stopLimitPrice)
			throws ApiException {
		return connectors.spot().newOrderTest(StopLossLimitOrder.buy(symbol, quantity, price, stopPrice)).sync();
	}

	/**
	 * Tests an order.
	 * 
	 * @param order Order to submit.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "foo")
	@ApiOperation(value = "Tests an order.")
	public void foo() throws ApiException {
		System.out.println(connectors.getKey());
		System.out.println(connectors.getSecret());
	}
}