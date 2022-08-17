package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.dto.Trade;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.Account;
import com.binance4j.spot.dto.CancelOrderResponse;
import com.binance4j.spot.dto.NewOrderResponse;
import com.binance4j.spot.dto.OCOInfo;
import com.binance4j.spot.dto.OCOResponse;
import com.binance4j.spot.dto.OrderCount;
import com.binance4j.spot.dto.OrderInfo;
import com.binance4j.spot.param.AllOCOInfoParams;
import com.binance4j.spot.param.AllOrdersParams;
import com.binance4j.spot.param.CancelOCOParams;
import com.binance4j.spot.param.CancelOpenOrdersParams;
import com.binance4j.spot.param.CancelOrderParams;
import com.binance4j.spot.param.LimitMakerOrder;
import com.binance4j.spot.param.LimitOrder;
import com.binance4j.spot.param.MarketOrder;
import com.binance4j.spot.param.MarketQuoteOrder;
import com.binance4j.spot.param.NewOCOOrderParams;
import com.binance4j.spot.param.OCOInfoParams;
import com.binance4j.spot.param.OpenOrdersStatusParams;
import com.binance4j.spot.param.OrderStatusParams;
import com.binance4j.spot.param.StopLossLimitOrder;
import com.binance4j.spot.param.StopLossOrder;
import com.binance4j.spot.param.TakeProfitLimitOrder;
import com.binance4j.spot.param.TakeProfitOrder;
import com.binance4j.spot.param.TradesParams;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Spot endpoints. */
@RestController
@RequestMapping("api/v1/spot")
@Api(value = "Spot", tags = "Spot", produces = "application/json", description = "Spot endpoints")
public class SpotController extends BaseController {

	/**
	 * @return Spot client.
	 */
	private SpotClient client() {
		return connectors.rest().spot();
	}

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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam("The order id") Long orderId,
			@RequestParam(required = false) @ApiParam("The origClientOrderId") String origClientOrderId,
			@RequestParam(required = false) @ApiParam("The newClientOrderId") String newClientOrderId)
			throws ApiException {
		return client()
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
	public List<CancelOrderResponse> cancelOpenOrders(@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return client().cancelOpenOrders(new CancelOpenOrdersParams(symbol)).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("The order id") Long orderId,
			@RequestParam(required = false) @ApiParam("The origClientOrderId") String origClientOrderId)
			throws ApiException {
		return client().getOrderStatus(new OrderStatusParams(symbol, origClientOrderId, orderId)).sync();
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
			@RequestParam(required = false) @ApiParam(SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return client().getOpenOrders(new OpenOrdersStatusParams(symbol)).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("The order id") Long orderId,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getAllOrders(new AllOrdersParams(symbol, orderId), new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * Cancel an entire Order List. Canceling an individual leg will cancel the
	 * entire OCO
	 * 
	 * @param symbol            Symbol to cancel the order.
	 * @param orderListId       Either {@code orderListId} or
	 *                          {@code listClientOrderId} must be provided.
	 * @param listClientOrderId Either {@code orderListId} or
	 *                          {@code listClientOrderId} must be provided.
	 * @param newClientOrderId  Used to uniquely identify this cancel. Automatically
	 *                          generated by default
	 * @return An OCO Order details.
	 * @throws ApiException Something went wrong.
	 */
	@DeleteMapping(path = "cancel-oco")
	@ApiOperation(value = "Cancel an entire Order List. Canceling an individual leg will cancel the entire OCO")
	public OCOResponse cancelOCO(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("Either orderListId or listClientOrderId must be provided.") Long orderListId,
			@RequestParam(required = false) @ApiParam("Either orderListId or listClientOrderId must be provided.") String listClientOrderId,
			@RequestParam(required = false) @ApiParam("Used to uniquely identify this cancel. Automatically generated by default") String newClientOrderId)
			throws ApiException {
		return client()
				.cancelOCO(new CancelOCOParams(symbol, orderListId, listClientOrderId, newClientOrderId)).sync();
	}

	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 * 
	 * @param symbol            Trade symbol.
	 * @param orderListId       Either {@code orderListId} or
	 *                          {@code origClientOrderId} must be provided.
	 * @param origClientOrderId Either {@code orderListId} or
	 *                          {@code origClientOrderId} must be provided.
	 * 
	 * @return An OCO Order details.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "oco")
	@ApiOperation(value = "Retrieves a specific OCO based on provided optional parameters.")
	public OCOInfo getOCO(
			@RequestParam(required = false) @ApiParam("Either orderListId or origClientOrderId must be provided.") Long orderListId,
			@RequestParam(required = false) @ApiParam("Either orderListId or origClientOrderId must be provided.") String origClientOrderId)
			throws ApiException {
		return client().getOCO(new OCOInfoParams(orderListId, origClientOrderId)).sync();
	}

	/**
	 * Retrieves all OCO based on provided optional parameters.
	 * 
	 * @param fromId    Id to search from.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * 
	 * @return List of OCO Order details.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "all-oco")
	@ApiOperation(value = "Retrieves all OCO based on provided optional parameters.")
	public List<OCOInfo> getAllOCO(
			@RequestParam(required = false) @ApiParam("Id to search from.") Long fromId,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getAllOCO(new AllOCOInfoParams(fromId), new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * Retrieves all open OCO.
	 * 
	 * @return List of OCO Order details.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "open-oco")
	@ApiOperation(value = "Retrieves all open OCO.")
	public List<OCOInfo> getOpenOCO() throws ApiException {
		return client().getOpenOCO().sync();
	}

	/**
	 * Get trades for a specific account and symbol. If fromId is set, it will get
	 * id &gt;= fromId. Otherwise most recent trades are returned.
	 * 
	 * @return List of OCO Order details.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "trades")
	@ApiOperation(value = "Get trades for a specific account and symbol. If fromId is set, it will get id >= fromId. Otherwise most recent trades are returned.")
	public List<Trade> getTrades(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("The order id") Long orderId,
			@RequestParam(required = false) @ApiParam("Id to search from.") Long fromId,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit) throws ApiException {
		return client().getTrades(new TradesParams(symbol, orderId, fromId), new TimeFrame(startTime, endTime, limit))
				.sync();
	}

	/**
	 * Get current account information.
	 * 
	 * @return SPOT account information.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "account")
	@ApiOperation(value = "Get current account information.")
	public Account getAccount() throws ApiException {
		return client().getAccount().sync();
	}

	/**
	 * Displays the user's current order count usage for all intervals with default
	 * request
	 * 
	 * @return The user's current order count usage for all intervals.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "order-count")
	@ApiOperation(value = "Displays the user's current order count usage for all intervals with default request")
	public List<OrderCount> getOrderCount() throws ApiException {
		return client().getOrderCount().sync();
	}

	// ORDERS

	// OCO

	/**
	 * Send in an OCO order.
	 * 
	 * @param symbol               The order symbol.
	 * @param side                 The order side.
	 * @param quantity             The order quantity.
	 * @param price                The order price.
	 * @param stopPrice            The stop price.
	 * @param stopLimitPrice       If provided, stopLimitTimeInForce is required.
	 * @param stopLimitTimeInForce If provided, stopLimitTimeInForce is required.
	 * @param newOrderRespType     The order response type.
	 * @param listClientOrderId    A unique Id for the entire orderList.
	 * @param limitClientOrderId   A unique Id for the limit order.
	 * @param limitIcebergQuantity Used to make the LIMIT_MAKER leg an iceberg
	 *                             order.
	 * @param stopClientOrderId    A unique Id for the stop loss/stop loss limit
	 *                             leg.
	 * @param stopIcebergQuantity  Used with STOP_LOSS_LIMIT leg to make an iceberg
	 *                             order.
	 * @return Response of an OCO order.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/oco")
	@ApiOperation(value = "Send in an OCO order.")
	public OCOResponse oco(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam(required = false) @ApiParam("If provided, stopLimitTimeInForce is required.") String stopLimitPrice,
			@RequestParam(required = false) @ApiParam(TIF_DESCRIPTION) TimeInForce stopLimitTimeInForce,
			@RequestParam(required = false) @ApiParam(value = "The order response type.", defaultValue = "RESULT") NewOrderResponseType newOrderRespType,
			@RequestParam(required = false) @ApiParam("A unique Id for the entire orderList") String listClientOrderId,
			@RequestParam(required = false) @ApiParam("A unique Id for the limit order") String limitClientOrderId,
			@RequestParam(required = false) @ApiParam("Used to make the LIMIT_MAKER leg an iceberg order.") String limitIcebergQuantity,
			@RequestParam(required = false) @ApiParam("A unique Id for the stop loss/stop loss limit leg") String stopClientOrderId,
			@RequestParam(required = false) @ApiParam("Used with STOP_LOSS_LIMIT leg to make an iceberg order.") String stopIcebergQuantity)
			throws ApiException {
		var oco = new NewOCOOrderParams(symbol, side, quantity, price, stopPrice, stopLimitPrice, stopLimitTimeInForce);
		oco.setNewOrderRespType(newOrderRespType);
		oco.setListClientOrderId(listClientOrderId);
		oco.setLimitClientOrderId(limitClientOrderId);
		oco.setLimitIcebergQuantity(limitIcebergQuantity);
		oco.setStopClientOrderId(stopClientOrderId);
		oco.setStopIcebergQuantity(stopIcebergQuantity);
		return client().newOCO(oco).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return client().newOrderTest(new MarketOrder(symbol, side, quantity)).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return client().newOrder(new MarketOrder(symbol, side, quantity)).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return client().newOrderTest(new MarketQuoteOrder(symbol, side, quantity)).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return client().newOrder(new MarketQuoteOrder(symbol, side, quantity)).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce,
			@RequestParam(required = false) @ApiParam(ICEBERG_DESCRIPTION) String icebergQty)
			throws ApiException {
		return client()
				.newOrderTest(
						new LimitOrder(symbol, side, quantity, price, icebergQty, handleNullTimeInForce(timeInForce)))
				.sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce,
			@RequestParam(required = false) @ApiParam(ICEBERG_DESCRIPTION) String icebergQty)
			throws ApiException {
		return client()
				.newOrder(new LimitOrder(symbol, side, quantity, price, icebergQty, handleNullTimeInForce(timeInForce)))
				.sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return client().newOrderTest(new LimitMakerOrder(symbol, side, quantity, price)).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity)
			throws ApiException {
		return client().newOrder(new LimitMakerOrder(symbol, side, quantity, price)).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam(required = false) @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam(required = false, value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce)
			throws ApiException {
		StopLossLimitOrder order = createStopLossLimitOrder(symbol, side, quantity, price, trailingDelta, stopPrice,
				timeInForce);
		return client().newOrderTest(order).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam(required = false) @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam(required = false, value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce)
			throws ApiException {
		StopLossLimitOrder order = createStopLossLimitOrder(symbol, side, quantity, price, trailingDelta, stopPrice,
				timeInForce);
		return client().newOrder(order).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta)
			throws ApiException {
		StopLossOrder order = createStopLossOrder(symbol, side, quantity, stopPrice, trailingDelta);
		return client().newOrderTest(order).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta)
			throws ApiException {
		StopLossOrder order = createStopLossOrder(symbol, side, quantity, stopPrice, trailingDelta);
		return client().newOrder(order).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(ICEBERG_DESCRIPTION) String icebergQty,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce)
			throws ApiException {
		TakeProfitLimitOrder order = createTakeProfitLimitOrder(symbol, side, quantity, price, trailingDelta, stopPrice,
				timeInForce, icebergQty);
		return client().newOrderTest(order).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(ICEBERG_DESCRIPTION) String icebergQty,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce)
			throws ApiException {
		TakeProfitLimitOrder order = createTakeProfitLimitOrder(symbol, side, quantity, price, trailingDelta, stopPrice,
				timeInForce, icebergQty);
		return client().newOrder(order).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta)
			throws ApiException {
		TakeProfitOrder order = createTakeProfitOrder(symbol, side, quantity, trailingDelta, stopPrice);
		return client().newOrderTest(order).sync();
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
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice)
			throws ApiException {
		TakeProfitOrder order = createTakeProfitOrder(symbol, side, quantity, trailingDelta, stopPrice);
		return client().newOrder(order).sync();
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