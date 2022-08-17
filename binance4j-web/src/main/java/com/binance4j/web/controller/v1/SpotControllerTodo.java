package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.spot.dto.CancelOrderResponse;
import com.binance4j.spot.dto.NewOrderResponse;
import com.binance4j.spot.dto.OCOResponse;
import com.binance4j.spot.dto.OrderInfo;
import com.binance4j.spot.param.AllOrdersParams;
import com.binance4j.spot.param.CancelOpenOrdersParams;
import com.binance4j.spot.param.CancelOrderParams;
import com.binance4j.spot.param.LimitMakerOrder;
import com.binance4j.spot.param.LimitOrder;
import com.binance4j.spot.param.MarketOrder;
import com.binance4j.spot.param.MarketQuoteOrder;
import com.binance4j.spot.param.NewOCOOrderParams;
import com.binance4j.spot.param.OpenOrdersStatusParams;
import com.binance4j.spot.param.OrderStatusParams;
import com.binance4j.spot.param.StopLossLimitOrder;
import com.binance4j.spot.param.StopLossOrder;
import com.binance4j.spot.param.TakeProfitLimitOrder;
import com.binance4j.spot.param.TakeProfitOrder;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Spot endpoints. */
@RestController
@RequestMapping("api/v1/spot")
@Api(value = "Spot", tags = "Spot", produces = "application/json", description = "Spot endpoints")
public class SpotControllerTodo extends BaseController {

	/**
	 * Cancel an open order.
	 * 
	 * @param symbol            Trade symbol.
	 * @param orderId           Order id.
	 * @param origClientOrderId Original client order id.
	 * @param newClientOrderId  New client order id.
	 * @return The cancellation response.
	 * @throws ApiException
	 */
	@DeleteMapping(path = "cancel-order")
	@ApiOperation(value = "Cancel an open order.")
	public CancelOrderResponse cancelOrder(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = "The order id") Long orderId,
			@RequestParam(required = false) @ApiParam(value = "The origClientOrderId") String origClientOrderId,
			@RequestParam(required = false) @ApiParam(value = "The newClientOrderId") String newClientOrderId)
			throws ApiException {
		return connectors.rest().spot()
				.cancelOrder(new CancelOrderParams(symbol, orderId, origClientOrderId, newClientOrderId)).sync();
	}

	/**
	 * Cancel open orders.
	 * 
	 * @param symbol Symbol.
	 * @return The cancellation responses.
	 * @throws ApiException
	 */
	@DeleteMapping(path = "cancel-orders")
	@ApiOperation(value = "Cancel open orders.")
	public List<CancelOrderResponse> cancelOpenOrders(@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return connectors.rest().spot().cancelOpenOrders(new CancelOpenOrdersParams(symbol)).sync();
	}

	/**
	 * Check an order's status.
	 * 
	 * @param symbol            Trade symbol.
	 * @param orderId           Order id.
	 * @param origClientOrderId Original client order id.
	 * 
	 * @return Trade order information.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "order-status")
	@ApiOperation(value = "Check an order's status.")
	public OrderInfo getOrderStatus(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam(value = "The order id") Long orderId,
			@RequestParam(required = false) @ApiParam(value = "The origClientOrderId") String origClientOrderId)
			throws ApiException {
		return connectors.rest().spot().getOrderStatus(new OrderStatusParams(symbol, origClientOrderId, orderId))
				.sync();
	}

	/**
	 * Get all open orders on a symbol.
	 * 
	 * @param symbol            Trade symbol.
	 * @param orderId           Order id.
	 * @param origClientOrderId Original client order id.
	 * 
	 * @return Trade order information.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "open-orders")
	@ApiOperation(value = "Get all open orders on a symbol.")
	public List<OrderInfo> getOpenOrders(
			@RequestParam(required = false) @ApiParam(value = SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return connectors.rest().spot().getOpenOrders(new OpenOrdersStatusParams(symbol))
				.sync();
	}

	/**
	 * Get all orders on a symbol.
	 * 
	 * @param symbol    Trade symbol.
	 * @param orderId   Order id.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * 
	 * @return Trade order information.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "all-orders")
	@ApiOperation(value = "Get all orders on a symbol.")
	public List<OrderInfo> getAllOrders(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam(value = "The order id") Long orderId,
			@RequestParam(required = false) @ApiParam(value = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(value = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(value = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().spot()
				.getAllOrders(new AllOrdersParams(symbol, orderId), new TimeFrame(startTime, endTime, limit)).sync();
	}

	// ORDERS

	// OCO

	/**
	 * Send in an OCO order.
	 * 
	 * @param params The OCO order.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/oco")
	@ApiOperation(value = "Send in an OCO order.")
	public OCOResponse oco(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = "The order side") OrderSide side,
			@RequestParam @ApiParam(value = "The order quantity") String quantity,
			@RequestParam @ApiParam(value = "The order price") String price,
			@RequestParam @ApiParam(value = "The stop price") String stopPrice,
			@RequestParam @ApiParam(value = "The order response type.", defaultValue = "RESULT") NewOrderResponseType newOrderRespType,
			@RequestParam @ApiParam(value = "A unique Id for the entire orderList") String listClientOrderId,
			@RequestParam @ApiParam(value = "A unique Id for the limit order") String limitClientOrderId,
			@RequestParam @ApiParam(value = "Used to make the LIMIT_MAKER leg an iceberg order.") String limitIcebergQuantity,
			@RequestParam @ApiParam(value = "A unique Id for the stop loss/stop loss limit leg") String stopClientOrderId,
			@RequestParam @ApiParam(value = "If provided, stopLimitTimeInForce is required.") String stopLimitPrice,
			@RequestParam @ApiParam(value = "Used with STOP_LOSS_LIMIT leg to make an iceberg order.") String stopIcebergQuantity,
			@RequestParam @ApiParam(value = TIF_DESCRIPTION) TimeInForce stopLimitTimeInForce)
			throws ApiException {
		return connectors.rest().spot().newOCO(
				new NewOCOOrderParams(symbol, side, quantity, price, stopPrice, stopLimitPrice, stopLimitTimeInForce))
				.sync();
	}

	// MARKET ORDER

	/**
	 * Tests a market order.
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @param side     Side.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order-test/market")

	@ApiOperation(value = "Tests a market order.")
	public Void marketTest(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return connectors.rest().spot().newOrderTest(new MarketOrder(symbol, side, quantity)).sync();
	}

	/**
	 * Submits a market order.
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @param side     Side.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/market")
	@ApiOperation(value = "Submits a market order.")
	public NewOrderResponse market(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return connectors.rest().spot().newOrder(new MarketOrder(symbol, side, quantity)).sync();
	}

	// MARKET QUOTE ORDER

	/**
	 * Tests a market quote order.
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @param side     Side.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order-test/quote")
	@ApiOperation(value = "Tests a market order with the wuote asset quantity.")
	public Void quoteTest(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return connectors.rest().spot().newOrderTest(new MarketQuoteOrder(symbol, side, quantity)).sync();
	}

	/**
	 * Submits a market order with the wuote asset quantity
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @param side     Side.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/quote")
	@ApiOperation(value = "Submits a market order with the wuote asset quantity.")
	public NewOrderResponse quote(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return connectors.rest().spot().newOrder(new MarketQuoteOrder(symbol, side, quantity)).sync();
	}

	// LIMIT ORDER

	/**
	 * Tests a limit order.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param side        Side.
	 * @param price       Price.
	 * @param timeInForce Time in force.
	 * @param icebergQty  Iceber quantity.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order-test/limit")
	@ApiOperation(value = "Tests a limit order.")
	public Void limitTest(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce,
			@RequestParam(required = false) @ApiParam(value = ICEBERG_DESCRIPTION) String icebergQty)
			throws ApiException {
		return connectors.rest().spot().newOrderTest(new LimitOrder(symbol, side, quantity, price, icebergQty,
				handleNullTimeInForce(timeInForce))).sync();
	}

	/**
	 * Submits a limit order.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param side        Side.
	 * @param price       Price.
	 * @param timeInForce Time in force.
	 * @param icebergQty  Iceber quantity.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/limit")
	@ApiOperation(value = "Submits a limit order.")
	public NewOrderResponse limit(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce,
			@RequestParam(required = false) @ApiParam(value = ICEBERG_DESCRIPTION) String icebergQty)
			throws ApiException {
		return connectors.rest().spot().newOrder(new LimitOrder(symbol, side, quantity, price, icebergQty,
				handleNullTimeInForce(timeInForce))).sync();
	}

	// LIMIT MAKER ORDER

	/**
	 * Tests a limit maker order.
	 * 
	 * @param symbol   Symbol.
	 * @param side     Side.
	 * @param quantity Quantity.
	 * @param price    Price.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order-test/limit-maker")
	@ApiOperation(value = "Tests a limit maker order.")
	public Void limitMakerTest(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return connectors.rest().spot().newOrderTest(new LimitMakerOrder(symbol, side, quantity, price)).sync();
	}

	/**
	 * Submits a limit maker order.
	 * 
	 * @param symbol   Symbol.
	 * @param side     Side.
	 * @param quantity Quantity.
	 * @param price    Price.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/limit-maker")
	@ApiOperation(value = "Submits a limit maker order.")
	public NewOrderResponse limitMaker(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return connectors.rest().spot().newOrder(new LimitMakerOrder(symbol, side, quantity, price)).sync();
	}

	// STOP LOSS LIMIT ORDER

	/**
	 * Tests a stop loss limit order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @param timeInForce   Time in force.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order-test/stop-loss-limit")
	@ApiOperation(value = "Tests a stop loss limit order.", notes = "trailingDelta or stopPrice must be sent.")
	public Void stopLossLimitTest(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(value = PRICE_DESCRIPTION) String price,
			@RequestParam(required = false) @ApiParam(value = DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(value = STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam(required = false, value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce)
			throws ApiException {
		StopLossLimitOrder order = createStopLossLimitOrder(symbol, side, quantity, price, trailingDelta, stopPrice,
				timeInForce);
		return connectors.rest().spot().newOrderTest(order).sync();
	}

	/**
	 * Submits a stop loss limit order.
	 * 
	 * @param symbol      Symbol.
	 * @param side        Side.
	 * @param quantity    Quantity.
	 * @param price       Price.
	 * @param stopPrice   Stop price.
	 * @param timeInForce Time in force.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/stop-loss-limit")
	@ApiOperation(value = "Submits a stop loss limit order.")
	public NewOrderResponse stopLossLimit(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(value = PRICE_DESCRIPTION) String price,
			@RequestParam(required = false) @ApiParam(value = DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(value = STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam(required = false, value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce)
			throws ApiException {
		StopLossLimitOrder order = createStopLossLimitOrder(symbol, side, quantity, price, trailingDelta, stopPrice,
				timeInForce);

		return connectors.rest().spot().newOrder(order).sync();
	}

	/**
	 * Creates a stop loss limit order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @param timeInForce   Time in force.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	private StopLossLimitOrder createStopLossLimitOrder(String symbol, OrderSide side, String quantity, String price,
			Long trailingDelta, String stopPrice, TimeInForce timeInForce) throws ApiException {
		// handle null values
		handleNullTrailingDeltaAndStopPrice(trailingDelta, stopPrice);
		timeInForce = handleNullTimeInForce(timeInForce);

		if (stopPrice != null) {
			return new StopLossLimitOrder(symbol, side, quantity, price, stopPrice, timeInForce);
		} else {
			return new StopLossLimitOrder(symbol, side, quantity, price, trailingDelta, timeInForce);
		}
	}

	// STOP LOSS ORDER

	/**
	 * Tests a stop loss order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * 
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order-test/stop-loss")
	@ApiOperation(value = "Tests a stop loss limit order.", notes = "trailingDelta or stopPrice must be sent.")
	public Void stopLossTest(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(value = STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(value = DELTA_DESCRIPTION) Long trailingDelta)
			throws ApiException {
		StopLossOrder order = createStopLossOrder(symbol, side, quantity, stopPrice, trailingDelta);
		return connectors.rest().spot().newOrderTest(order).sync();
	}

	/**
	 * Submits a stop loss order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/stop-loss")
	@ApiOperation(value = "Submits a stop loss limit order.")
	public NewOrderResponse stopLoss(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(value = STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(value = DELTA_DESCRIPTION) Long trailingDelta)
			throws ApiException {
		StopLossOrder order = createStopLossOrder(symbol, side, quantity, stopPrice, trailingDelta);
		return connectors.rest().spot().newOrder(order).sync();
	}

	/**
	 * Creates a stop loss order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	private StopLossOrder createStopLossOrder(String symbol, OrderSide side, String quantity, String stopPrice,
			Long trailingDelta) throws ApiException {
		// handle null values
		handleNullTrailingDeltaAndStopPrice(trailingDelta, stopPrice);

		if (stopPrice != null) {
			return new StopLossOrder(symbol, side, quantity, stopPrice);
		} else {
			return new StopLossOrder(symbol, side, quantity, trailingDelta);
		}
	}

	// TAKE PROFIT ORDER

	/**
	 * Tests a take profit limit order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @param icebergQty    Iceber quantity.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @param timeInForce   Time in force.
	 * 
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order-test/take-profit-limit")
	@ApiOperation(value = "Tests a take profit limit order.", notes = "trailingDelta or stopPrice must be sent.")
	public Void takeProfitLimitTest(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(value = PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(value = STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(value = DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(value = ICEBERG_DESCRIPTION) String icebergQty,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce)
			throws ApiException {
		TakeProfitLimitOrder order = createTakeProfitLimitOrder(symbol, side, quantity, price, trailingDelta, stopPrice,
				timeInForce, icebergQty);
		return connectors.rest().spot().newOrderTest(order).sync();
	}

	/**
	 * Submits a take profit limit order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @param icebergQty    Iceber quantity.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @param timeInForce   Time in force.
	 * 
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/take-profit-limit")
	@ApiOperation(value = "Submits a take profit limit order.")
	public NewOrderResponse takeProfitLimit(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(value = PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(value = STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(value = DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(value = ICEBERG_DESCRIPTION) String icebergQty,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce)
			throws ApiException {
		TakeProfitLimitOrder order = createTakeProfitLimitOrder(symbol, side, quantity, price, trailingDelta, stopPrice,
				timeInForce, icebergQty);
		return connectors.rest().spot().newOrder(order).sync();
	}

	/**
	 * Ctreates a take profit limit order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @param icebergQty    Iceber quantity.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * @param timeInForce   Time in force.
	 * 
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	private TakeProfitLimitOrder createTakeProfitLimitOrder(String symbol, OrderSide side, String quantity,
			String price, Long trailingDelta, String stopPrice, TimeInForce timeInForce, String icebergQty)
			throws ApiException {
		handleNullTrailingDeltaAndStopPrice(trailingDelta, stopPrice);
		timeInForce = handleNullTimeInForce(timeInForce);

		if (stopPrice != null) {
			return new TakeProfitLimitOrder(symbol, side, quantity, price, stopPrice, icebergQty, timeInForce);
		} else {
			return new TakeProfitLimitOrder(symbol, side, quantity, price, trailingDelta, icebergQty, timeInForce);
		}
	}

	// TAKE PROFIT ORDER

	/**
	 * Tests a take profit order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 * 
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order-test/take-profit")
	@ApiOperation(value = "Tests a take profit order.")
	public Void takeProfitTest(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(value = STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(value = DELTA_DESCRIPTION) Long trailingDelta)
			throws ApiException {
		TakeProfitOrder order = createTakeProfitOrder(symbol, side, quantity, trailingDelta, stopPrice);
		return connectors.rest().spot().newOrderTest(order).sync();
	}

	/**
	 * Submits a take profit order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @param stopPrice     Stop price.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/take-profit")
	@ApiOperation(value = "Submits a take profit order.")
	public NewOrderResponse takeProfit(
			@RequestParam @ApiParam(value = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(value = SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(value = QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(value = DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam @ApiParam(value = STOP_PRICE_DESCRIPTION) String stopPrice)
			throws ApiException {
		TakeProfitOrder order = createTakeProfitOrder(symbol, side, quantity, trailingDelta, stopPrice);
		return connectors.rest().spot().newOrder(order).sync();
	}

	/**
	 * Creates a take profit order.
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @param stopPrice     Stop price.
	 * @return The order response.
	 * @throws ApiException Something went wrong.
	 */
	private TakeProfitOrder createTakeProfitOrder(String symbol, OrderSide side, String quantity, Long trailingDelta,
			String stopPrice) throws ApiException {
		handleNullTrailingDeltaAndStopPrice(trailingDelta, stopPrice);

		if (stopPrice != null) {
			return new TakeProfitOrder(symbol, side, quantity, stopPrice);
		} else {
			return new TakeProfitOrder(symbol, side, quantity, trailingDelta);
		}
	}

	// Handle Null values

	/**
	 * Will thow an Api Exception if trailingDelta and stopPrice are null
	 * 
	 * @param trailingDelta trailingDelta.
	 * @param stopPrice     stopPrice.
	 * @throws ApiException Exception sent if both null.
	 */
	private void handleNullTrailingDeltaAndStopPrice(Long trailingDelta, String stopPrice) throws ApiException {
		if (trailingDelta == null && stopPrice == null) {
			throw new ApiException(400, "Missing trailingDelta or stopPrice");
		}
	}

	/**
	 * @param timeInForce input time in force
	 * @return a default Time in force if input is null
	 */
	private TimeInForce handleNullTimeInForce(TimeInForce timeInForce) {
		return timeInForce != null ? timeInForce : TimeInForce.GTC;
	}
}