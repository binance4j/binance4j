package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.Account;
import com.binance4j.margin.dto.Asset;
import com.binance4j.margin.dto.BNBBurnStatus;
import com.binance4j.margin.dto.CancelOrderResponse;
import com.binance4j.margin.dto.CrossFee;
import com.binance4j.margin.dto.CrossSymbol;
import com.binance4j.margin.dto.DustLogRecord;
import com.binance4j.margin.dto.ForceLiquidationRecords;
import com.binance4j.margin.dto.InterestHistory;
import com.binance4j.margin.dto.InterestRate;
import com.binance4j.margin.dto.IsolatedAccount;
import com.binance4j.margin.dto.IsolatedAccountLimit;
import com.binance4j.margin.dto.IsolatedFee;
import com.binance4j.margin.dto.IsolatedSymbol;
import com.binance4j.margin.dto.IsolatedTierData;
import com.binance4j.margin.dto.IsolatedTransferAccount;
import com.binance4j.margin.dto.IsolatedTransferRecords;
import com.binance4j.margin.dto.LoanRecord;
import com.binance4j.margin.dto.MaxBorrowable;
import com.binance4j.margin.dto.MaxTransferable;
import com.binance4j.margin.dto.NewOCOOrderRecord;
import com.binance4j.margin.dto.NewOrderRecord;
import com.binance4j.margin.dto.OCOOrderRecord;
import com.binance4j.margin.dto.OrderInfo;
import com.binance4j.margin.dto.OrderRateLimit;
import com.binance4j.margin.dto.PriceIndex;
import com.binance4j.margin.dto.RepayRecords;
import com.binance4j.margin.dto.SideEffectType;
import com.binance4j.margin.dto.ToogleAccountResponse;
import com.binance4j.margin.dto.Trade;
import com.binance4j.margin.dto.Transaction;
import com.binance4j.margin.dto.TransferRecords;
import com.binance4j.margin.dto.TransferType;
import com.binance4j.margin.param.AllOrdersParams;
import com.binance4j.margin.param.AssetParams;
import com.binance4j.margin.param.BorrowParams;
import com.binance4j.margin.param.CancelOCOParams;
import com.binance4j.margin.param.CancelOpenOrdersParams;
import com.binance4j.margin.param.CancelOrderParams;
import com.binance4j.margin.param.CrossFeeParams;
import com.binance4j.margin.param.ForceLiquidationRecordParams;
import com.binance4j.margin.param.GetAllOCOParams;
import com.binance4j.margin.param.GetOCOParams;
import com.binance4j.margin.param.GetOpenOCOParams;
import com.binance4j.margin.param.InterestRateHistoryParams;
import com.binance4j.margin.param.IsolatedAccountParams;
import com.binance4j.margin.param.IsolatedFeeParams;
import com.binance4j.margin.param.IsolatedTierDataParams;
import com.binance4j.margin.param.IsolatedTransferHistoryParams;
import com.binance4j.margin.param.LimitMakerOrder;
import com.binance4j.margin.param.LimitOrder;
import com.binance4j.margin.param.MarketOrder;
import com.binance4j.margin.param.MarketQuoteOrder;
import com.binance4j.margin.param.MaxBorrowableParams;
import com.binance4j.margin.param.MaxTransferableParams;
import com.binance4j.margin.param.NewIsolatedTransferParams;
import com.binance4j.margin.param.NewOCOOrderParams;
import com.binance4j.margin.param.OpenOrdersParams;
import com.binance4j.margin.param.OrderParams;
import com.binance4j.margin.param.PairParams;
import com.binance4j.margin.param.PriceIndexParams;
import com.binance4j.margin.param.RateLimitParams;
import com.binance4j.margin.param.RepayParams;
import com.binance4j.margin.param.StopLossLimitOrder;
import com.binance4j.margin.param.StopLossOrder;
import com.binance4j.margin.param.TakeProfitLimitOrder;
import com.binance4j.margin.param.TakeProfitOrder;
import com.binance4j.margin.param.ToggleBurnParams;
import com.binance4j.margin.param.ToogleAccountParams;
import com.binance4j.margin.param.TradeParams;
import com.binance4j.margin.param.TransactionHistoryParams;
import com.binance4j.margin.param.TransferParams;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;
import com.binance4j.web.configuration.Binance4jWeb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Controller for Margin endpoints.
 */
@RestController
@RequestMapping(Binance4jWeb.CONNECTORS_BASE_URI + "margin")
@Api(value = "Margin", tags = "Margin", produces = "application/json", description = "Margin endpoints")
public class MarginController extends BaseController {
	/**
	 * Creates instance.
	 *
	 * @param connectors Binance4j connectors.
	 */
	public MarginController(Connectors connectors) {
		super(connectors);
	}
	
	/**
	 * @return Margin client.
	 */
	private MarginClient client() {
		return connectors.rest().margin();
	}
	
	/**
	 * Execute transfer between spot account and cross margin account.
	 *
	 * @param asset  Asset being transferred.
	 * @param amount Amount to be transferred.
	 * @param type   Transfer type.
	 *
	 * @return The transaction response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "transfer")
	@ApiOperation(value = "Execute transfer between spot account and cross margin account.")
	public Transaction transfer(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String amount,
			@RequestParam @ApiParam("Transfer type.") TransferType type)
			throws ApiException {
		return client().transfer(new TransferParams(asset, amount, type)).sync();
	}
	
	/**
	 * Apply for a loan.
	 *
	 * @param asset      Asset to borrow.
	 * @param amount     Amount to borrow.
	 * @param symbol     Isolated symbol.
	 * @param isIsolated For isolated margin or not. Default: false.
	 *
	 * @return The transaction response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "borrow")
	@ApiOperation(value = "Apply for a loan.")
	public Transaction borrow(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String amount,
			@RequestParam(required = false) @ApiParam("Isolated symbol.") String symbol,
			@RequestParam(required = false) @ApiParam("Is the transaction for isolated symbol?") Boolean isIsolated)
			throws ApiException {
		return client().borrow(new BorrowParams(asset, amount, symbol, isIsolated)).sync();
	}
	
	/**
	 * Repay loan for margin account.
	 *
	 * @param asset      Asset to repay.
	 * @param amount     Amount to repay.
	 * @param symbol     Isolated symbol.
	 * @param isIsolated For isolated margin or not. Default: false.
	 *
	 * @return The transaction response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "repay")
	@ApiOperation(value = "Apply Repay loan for margin account.")
	public Transaction repay(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String amount,
			@RequestParam(required = false) @ApiParam("Isolated symbol.") String symbol,
			@RequestParam(required = false) @ApiParam("Is the transaction for isolated symbol?") Boolean isIsolated)
			throws ApiException {
		return client().repay(new RepayParams(asset, amount, symbol, isIsolated)).sync();
	}
	
	/**
	 * Get info about an asset.
	 *
	 * @param asset Asset.
	 *
	 * @return An asset on the platform.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "asset")
	@ApiOperation(value = "Get info about an asset.")
	public Asset getAsset(@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset) throws ApiException {
		return client().getAsset(new AssetParams(asset)).sync();
	}
	
	/**
	 * Get info about all assets.
	 *
	 * @return All assets on the platform.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "all-assets")
	@ApiOperation(value = "Get info about all assets.")
	public List<Asset> getAllAssets() throws ApiException {
		return client().getAllAssets().sync();
	}
	
	/**
	 * Get info about a cross margin pair.
	 *
	 * @param symbol Symbols.
	 *
	 * @return A Cross margin Asset pair.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "margin-pair")
	@ApiOperation(value = "Get info about a cross margin pair.")
	public CrossSymbol getCrossMarginPair(@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return client().getCrossMarginPair(new PairParams(symbol)).sync();
	}
	
	/**
	 * Get info about all cross margin pairs.
	 *
	 * @return All Cross margin Asset pairs.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "margin-pairs")
	@ApiOperation(value = "Get info about all cross margin pairs.")
	public List<CrossSymbol> getAllCrossMarginPairs() throws ApiException {
		return client().getAllCrossMarginPairs().sync();
	}
	
	/**
	 * Get the price index of a symbol.
	 *
	 * @param symbol Symbol.
	 *
	 * @return All Cross margin Asset pairs.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "price-index")
	@ApiOperation(value = "Get the price index of a symbol.")
	public PriceIndex getPriceIndex(@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return client().getPriceIndex(new PriceIndexParams(symbol)).sync();
	}
	
	/**
	 * Cancel an open order.
	 *
	 * @param symbol            Trade symbol.
	 * @param orderId           Order id.
	 * @param origClientOrderId Original client order id.
	 * @param newClientOrderId  New client order id.
	 *
	 * @return The cancellation response.
	 *
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
	 *
	 * @return The cancellation responses.
	 *
	 * @throws ApiException
	 */
	@DeleteMapping(path = "cancel-orders")
	@ApiOperation(value = "Cancel open orders.")
	public List<CancelOrderResponse> cancelOpenOrders(@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
	                                                  @RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated) throws ApiException {
		return client().cancelOpenOrders(new CancelOpenOrdersParams(symbol, isIsolated)).sync();
	}
	
	/**
	 * Get Cross Margin Transfer History.
	 *
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 * @param txId           Transaction id in POST /sapi/v1/margin/repay.
	 * @param archived       Set to true for archived data from 6 months ago.
	 * @param startTime      Start time in ms.
	 * @param endTime        End time in ms.
	 * @param page           Result page.
	 * @param limit          Results in the page.
	 *
	 * @return A list of transfer history records.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "transfers")
	@ApiOperation(value = "Get Cross Margin Transfer History.")
	public TransferRecords getTransferHistory(
			@RequestParam(required = false) @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam(required = false) @ApiParam("Isolated symbol.") String isolatedSymbol,
			@RequestParam(required = false) @ApiParam("Transaction id in POST /sapi/v1/margin/repay.") Long txId,
			@RequestParam(required = false) @ApiParam("Set to true for archived data from 6 months ago.") Boolean archived,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getTransferHistory(new TransactionHistoryParams(asset, isolatedSymbol, txId, archived),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}
	
	/**
	 * Query Loan Record.
	 *
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 * @param txId           Transaction id in POST /sapi/v1/margin/repay.
	 * @param archived       Set to true for archived data from 6 months ago.
	 * @param startTime      Start time in ms.
	 * @param endTime        End time in ms.
	 * @param page           Result page.
	 * @param limit          Results in the page.
	 *
	 * @return A loan record.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "loans")
	@ApiOperation(value = "Query Loan Record.")
	public LoanRecord getLoanRecord(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam(required = false) @ApiParam("Isolated symbol.") String isolatedSymbol,
			@RequestParam(required = false) @ApiParam("Transaction id in POST /sapi/v1/margin/repay.") Long txId,
			@RequestParam(required = false) @ApiParam("Set to true for archived data from 6 months ago.") Boolean archived,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getLoanRecord(new TransactionHistoryParams(asset, isolatedSymbol, txId, archived),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}
	
	/**
	 * Query repay Record.
	 *
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 * @param txId           Transaction id in POST /sapi/v1/margin/repay.
	 * @param archived       Set to true for archived data from 6 months ago.
	 * @param startTime      Start time in ms.
	 * @param endTime        End time in ms.
	 * @param page           Result page.
	 * @param limit          Results in the page.
	 *
	 * @return A repay record.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "repays")
	@ApiOperation(value = "Query repay Record.")
	public RepayRecords getRepayRecord(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam(required = false) @ApiParam("Isolated symbol.") String isolatedSymbol,
			@RequestParam(required = false) @ApiParam("Transaction id in POST /sapi/v1/margin/repay.") Long txId,
			@RequestParam(required = false) @ApiParam("Set to true for archived data from 6 months ago.") Boolean archived,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getRepayRecord(new TransactionHistoryParams(asset, isolatedSymbol, txId, archived),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}
	
	/**
	 * Query interest Record.
	 *
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 * @param txId           Transaction id in POST /sapi/v1/margin/repay.
	 * @param archived       Set to true for archived data from 6 months ago.
	 * @param startTime      Start time in ms.
	 * @param endTime        End time in ms.
	 * @param page           Result page.
	 * @param limit          Results in the page.
	 *
	 * @return A repay record.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "interests")
	@ApiOperation(value = "Query interest Record.")
	public InterestHistory getInterestHistory(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam(required = false) @ApiParam("Isolated symbol.") String isolatedSymbol,
			@RequestParam(required = false) @ApiParam("Transaction id in POST /sapi/v1/margin/repay.") Long txId,
			@RequestParam(required = false) @ApiParam("Set to true for archived data from 6 months ago.") Boolean archived,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getInterestHistory(new TransactionHistoryParams(asset, isolatedSymbol, txId, archived),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}
	
	/**
	 * Get Force Liquidation Record.
	 *
	 * @param isolatedSymbol Isolated symbol.
	 * @param startTime      Start time in ms.
	 * @param endTime        End time in ms.
	 * @param page           Result page.
	 * @param limit          Results in the page.
	 *
	 * @return A repay record.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "liquidations")
	@ApiOperation(value = "Get Force Liquidation Record.")
	public ForceLiquidationRecords getForceLiquidationRecord(
			@RequestParam @ApiParam("Isolated symbol.") String isolatedSymbol,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getForceLiquidationRecord(new ForceLiquidationRecordParams(isolatedSymbol),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}
	
	/**
	 * Get current account information.
	 *
	 * @return SPOT account information.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "account")
	@ApiOperation(value = "Get current account information.")
	public Account getAccount() throws ApiException {
		return client().getAccount().sync();
	}
	
	/**
	 * Check an order's status.
	 *
	 * @param symbol            Trade symbol.
	 * @param orderId           Order id.
	 * @param origClientOrderId Original client order id.
	 *
	 * @return Trade order information.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "order-status")
	@ApiOperation(value = "Check an order's status.")
	public OrderInfo getOrderStatus(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("The order id") Long orderId,
			@RequestParam(required = false) @ApiParam("The origClientOrderId.") String origClientOrderId,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated)
			throws ApiException {
		return client().getOrder(new OrderParams(symbol, orderId, isIsolated, origClientOrderId)).sync();
	}
	
	/**
	 * Get all open orders on a symbol.
	 *
	 * @param symbol Trade symbol.
	 *
	 * @return Trade order information.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "open-orders")
	@ApiOperation(value = "Get all open orders on a symbol.")
	public List<OrderInfo> getOpenOrders(
			@RequestParam(required = false) @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated)
			throws ApiException {
		return client().getOpenOrders(new OpenOrdersParams(symbol, isIsolated)).sync();
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
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "all-orders")
	@ApiOperation(value = "Get all orders on a symbol.")
	public List<OrderInfo> getAllOrders(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("The order id") Long orderId,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getAllOrders(new AllOrdersParams(symbol, orderId, isIsolated),
						new TimeFrame(startTime, endTime, limit))
				.sync();
	}
	
	/**
	 * Cancel an entire Order List. Canceling an individual leg will cancel the
	 * entire OCO
	 *
	 * @param symbol            Symbol to cancel the order.
	 * @param orderListId       Either `orderListId` or
	 *                          `listClientOrderId` must be provided.
	 * @param listClientOrderId Either `orderListId` or
	 *                          `listClientOrderId` must be provided.
	 * @param newClientOrderId  Used to uniquely identify this cancel. Automatically
	 *                          generated by default
	 *
	 * @return An OCO Order details.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@DeleteMapping(path = "cancel-oco")
	@ApiOperation(value = "Cancel an entire Order List. Canceling an individual leg will cancel the entire OCO")
	public NewOCOOrderRecord cancelOCO(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("Either orderListId or listClientOrderId must be provided.") Long orderListId,
			@RequestParam(required = false) @ApiParam("Either orderListId or listClientOrderId must be provided.") String listClientOrderId,
			@RequestParam(required = false) @ApiParam("Used to uniquely identify this cancel. Automatically generated by default") String newClientOrderId,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated)
			throws ApiException {
		return client()
				.cancelOCO(new CancelOCOParams(symbol, orderListId, listClientOrderId, isIsolated, newClientOrderId))
				.sync();
	}
	
	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 *
	 * @param symbol            Trade symbol.
	 * @param orderListId       Either `orderListId` or
	 *                          `origClientOrderId` must be provided.
	 * @param origClientOrderId Either `orderListId` or
	 *                          `origClientOrderId` must be provided.
	 *
	 * @return An OCO Order details.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "oco")
	@ApiOperation(value = "Retrieves a specific OCO based on provided optional parameters.")
	public OCOOrderRecord getOCO(
			@RequestParam(required = false) @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("Either orderListId or origClientOrderId must be provided.") Long orderListId,
			@RequestParam(required = false) @ApiParam("Either orderListId or origClientOrderId must be provided.") String origClientOrderId,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated)
			throws ApiException {
		return client().getOCO(new GetOCOParams(symbol, isIsolated, orderListId, origClientOrderId)).sync();
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
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "all-oco")
	@ApiOperation(value = "Retrieves all OCO based on provided optional parameters.")
	public List<OCOOrderRecord> getAllOCO(
			@RequestParam(required = false) @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("Id to search from.") Long fromId,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated)
			throws ApiException {
		return client()
				.getAllOCO(new GetAllOCOParams(symbol, fromId, isIsolated), new TimeFrame(startTime, endTime, limit))
				.sync();
	}
	
	/**
	 * Retrieves all open OCO.
	 *
	 * @return List of OCO Order details.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "open-oco")
	@ApiOperation(value = "Retrieves all open OCO.")
	public List<OCOOrderRecord> getOpenOCO(
			@RequestParam(required = false) @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated) throws ApiException {
		return client().getOpenOCO(new GetOpenOCOParams(symbol, isIsolated)).sync();
	}
	
	/**
	 * Get trades for a specific account and symbol. If fromId is set, it will get
	 * id &gt;= fromId. Otherwise most recent trades are returned.
	 *
	 * @return List of OCO Order details.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "trades")
	@ApiOperation(value = "Get trades for a specific account and symbol. If fromId is set, it will get id >= fromId. Otherwise most recent trades are returned.")
	public List<Trade> getTrades(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("Id to search from.") Long fromId,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit) throws ApiException {
		return client().getTrades(new TradeParams(symbol, fromId, isIsolated), new TimeFrame(startTime, endTime, limit))
				.sync();
	}
	
	/**
	 * Query Max Borrow.
	 *
	 * @return Max Borrowable amount.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "max-borrowable")
	@ApiOperation(value = "Query Max Borrow.")
	public MaxBorrowable getMaxBorrowable(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam(required = false) @ApiParam("Isolated symbol.") String isolatedSymbol) throws ApiException {
		return client().getMaxBorrowable(new MaxBorrowableParams(asset, isolatedSymbol)).sync();
	}
	
	/**
	 * Query Max Transfer-Out Amount.
	 *
	 * @return Max Borrowable amount.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "max-transferable")
	@ApiOperation(value = "Query Max Transfer-Out Amount.")
	public MaxTransferable getMaxTransferable(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam(required = false) @ApiParam("Isolated symbol.") String isolatedSymbol) throws ApiException {
		return client().getMaxTransferable(new MaxTransferableParams(asset, isolatedSymbol)).sync();
	}
	
	/**
	 * Make an Isolated Margin Account Transfer.
	 *
	 * @param asset     Asset to transfer.
	 * @param symbol    Symbol to transfer from.
	 * @param amount    Amount to transfer.
	 * @param transFrom Transfer origin.
	 * @param transTo   Transfer destination.
	 *
	 * @return The transaction.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "isolated-transfer")
	@ApiOperation(value = "Make an Isolated Margin Account Transfer.")
	public Transaction newIsolatedTransfer(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String symbol,
			@RequestParam @ApiParam("Amount to transfer.") String amount,
			@RequestParam @ApiParam("Transfer origin.") IsolatedTransferAccount transFrom,
			@RequestParam @ApiParam("Transfer destination.") IsolatedTransferAccount transTo)
			throws ApiException {
		return client().newIsolatedTransfer(new NewIsolatedTransferParams(asset, symbol, amount, transFrom, transTo))
				.sync();
	}
	
	/**
	 * Get Isolated Margin Transfer History.
	 *
	 * @param asset     Asset.
	 * @param symbol    Symbol.
	 * @param transFrom Transfer origin.
	 * @param transTo   Transfer destination.
	 * @param archived  Set to true for archived data from 6 months ago.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Result page.
	 * @param limit     Results in the page.
	 *
	 * @return Isolated margin transfer records.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "isolated-transfers")
	@ApiOperation(value = "Get Isolated Margin Transfer History.")
	public IsolatedTransferRecords getIsolatedTransferHistory(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam("Transfer origin.") IsolatedTransferAccount transFrom,
			@RequestParam @ApiParam("Transfer destination.") IsolatedTransferAccount transTo,
			@RequestParam @ApiParam("Is archived?") Boolean archived,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit) throws ApiException {
		return client().getIsolatedTransferHistory(new IsolatedTransferHistoryParams(symbol, asset, transFrom,
				transTo, archived), new FramedPaging(startTime, endTime, page, limit)).sync();
	}
	
	/**
	 * @param symbols Max 5 symbols can be sent; separated by ",".
	 *
	 * @return Isolated margin account info.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "isolated-account")
	@ApiOperation(value = "Query Isolated Margin Account Info.")
	public IsolatedAccount getIsolatedAccount(
			@RequestParam(required = false) @ApiParam(SYMBOLS_DESCRIPTION) String symbols) throws ApiException {
		return client().getIsolatedAccount(new IsolatedAccountParams(symbols)).sync();
	}
	
	/**
	 * Disable isolated margin account for a specific symbol. Each trading pair can
	 * only be deactivated once every 24 hours.
	 *
	 * @param symbol Symbol.
	 *
	 * @return Response after enabling/disabling isolated margin account.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "disable-isolated-account")
	@ApiOperation(value = "Disable isolated margin account for a specific symbol. Each trading pair can only be deactivated once every 24 hours.")
	public ToogleAccountResponse disableIsolatedAccount(@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return client().disableIsolatedAccount(new ToogleAccountParams(symbol)).sync();
	}
	
	/**
	 * Enable isolated margin account for a specific symbol(Only supports activation
	 * of previously disabled accounts).
	 *
	 * @param symbol Symbol.
	 *
	 * @return Response after enabling/disabling isolated margin account.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "enable-isolated-account")
	@ApiOperation(value = "Enable isolated margin account for a specific symbol(Only supports activation of previously disabled accounts).")
	public ToogleAccountResponse enableIsolatedAccount(@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return client().enableIsolatedAccount(new ToogleAccountParams(symbol)).sync();
	}
	
	/**
	 * @return enabled isolated margin account limit.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "isolated-account-limit")
	@ApiOperation(value = "Get enabled isolated margin account limit.")
	public IsolatedAccountLimit getEnabledIsolatedAccountLimit() throws ApiException {
		return client().getEnabledIsolatedAccountLimit().sync();
	}
	
	/**
	 * @return info about an isolated symbol.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "isolated-symbol")
	@ApiOperation(value = "Get info about an isolated symbol.")
	public IsolatedSymbol getIsolatedSymbol(@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return client().getIsolatedSymbol(new PairParams(symbol)).sync();
	}
	
	/**
	 * @return info about all isolated symbols.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "isolated-symbols")
	@ApiOperation(value = "Get info about all isolated symbols.")
	public List<IsolatedSymbol> getAllIsolatedSymbols() throws ApiException {
		return client().getAllIsolatedSymbols().sync();
	}
	
	/**
	 * Toggle BNB Burn On Spot Trade And Margin Interest.
	 *
	 * @param spotBNBBurn     Use BNB to pay for trading fees on SPOT?
	 * @param interestBNBBurn Use BNB to pay for margin loan's interest?
	 *
	 * @return BNB burn status.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "toggle-bnb-burn")
	@ApiOperation(value = "Toggle BNB Burn On Spot Trade And Margin Interest.")
	public BNBBurnStatus toggleBNBBurnOnSpotTradeAndMarginInterest(
			@RequestParam(required = false) @ApiParam("Use BNB to pay for trading fees on SPOT?") Boolean spotBNBBurn,
			@RequestParam(required = false) @ApiParam("Use BNB to pay for margin loan's interest?") Boolean interestBNBBurn)
			throws ApiException {
		return client().toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(spotBNBBurn, interestBNBBurn))
				.sync();
	}
	
	/**
	 * @return BNB Burn Status.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "bnb-burn-status")
	@ApiOperation(value = "Get BNB Burn Status.")
	public BNBBurnStatus getBNBBurnStatus() throws ApiException {
		return client().getBNBBurnStatus().sync();
	}
	
	/**
	 * @param asset    Asset.
	 * @param vipLevel VIP level.
	 *
	 * @return Query Margin Interest Rate History.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "interest-rates")
	@ApiOperation(value = "Query Margin Interest Rate History.")
	public List<InterestRate> getInterestRateHistory(
			@RequestParam @ApiParam(ASSET_DESCRIPTION) String asset,
			@RequestParam @ApiParam("VIP level") Integer vipLevel) throws ApiException {
		return client().getInterestRateHistory(new InterestRateHistoryParams(asset, vipLevel)).sync();
	}
	
	/**
	 * @param coin     Coin.
	 * @param vipLevel VIP level.
	 *
	 * @return cross margin fee data collection with any vip level or user's current
	 * specific data
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "margin-fee")
	@ApiOperation(value = "Get cross margin fee data collection with any vip level or user's current specific data.")
	public List<CrossFee> getMarginFeeData(
			@RequestParam(required = false) @ApiParam("Coin.") String coin,
			@RequestParam(required = false) @ApiParam("VIP level") Integer vipLevel) throws ApiException {
		return client().getMarginFeeData(new CrossFeeParams(coin, vipLevel)).sync();
	}
	
	/**
	 * @param coin     Coin.
	 * @param vipLevel VIP level.
	 *
	 * @return Get isolated margin fee data collection with any vip level or user's
	 * current specific data.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "isolated-fee")
	@ApiOperation(value = "Get isolated margin fee data collection with any vip level or user's current specific data.")
	public List<IsolatedFee> getIsolatedFeeData(
			@RequestParam(required = false) @ApiParam("Coin.") String coin,
			@RequestParam(required = false) @ApiParam("VIP level") Integer vipLevel) throws ApiException {
		return client().getIsolatedFeeData(new IsolatedFeeParams(coin, vipLevel)).sync();
	}
	
	/**
	 * @param symbol Symbol.
	 * @param tier   Tier.
	 *
	 * @return isolated margin tier data collection with any tier .
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "isolated-tier")
	@ApiOperation(value = "Get isolated margin tier data collection with any tier .")
	public List<IsolatedTierData> getIsolatedMarginTierData(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("Tier.") String tier) throws ApiException {
		return client().getIsolatedMarginTierData(new IsolatedTierDataParams(symbol, tier)).sync();
	}
	
	/**
	 * @param symbol     Symbol.
	 * @param isIsolated Is it isolated?
	 *
	 * @return the user's current margin order count usage for all intervals.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "rate-limit")
	@ApiOperation(value = "Displays the user's current margin order count usage for all intervals.")
	public List<OrderRateLimit> getRateLimit(
			@RequestParam(required = false) @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated) throws ApiException {
		return client().getRateLimit(new RateLimitParams(symbol, isIsolated)).sync();
	}
	
	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results in the page.
	 *
	 * @return A record of asset conversions to BNB.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "dust-log")
	@ApiOperation(value = "Query the historical information of user's margin account small-value asset conversion BNB.")
	public DustLogRecord getDustLog(
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit) throws ApiException {
		return client().getDustLog(new TimeFrame(startTime, endTime, limit)).sync();
	}
	
	// ORDERS
	
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
	 *
	 * @return Response of an OCO order.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/oco")
	@ApiOperation(value = "Send in an OCO order.")
	public NewOCOOrderRecord oco(
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
			@RequestParam(required = false) @ApiParam("Used with STOP_LOSS_LIMIT leg to make an iceberg order.") String stopIcebergQuantity,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated)
			throws ApiException {
		var oco = new NewOCOOrderParams(symbol, side, quantity, price, stopPrice, stopLimitPrice, stopLimitTimeInForce);
		oco.setNewOrderRespType(newOrderRespType);
		oco.setListClientOrderId(listClientOrderId);
		oco.setLimitClientOrderId(limitClientOrderId);
		oco.setLimitIcebergQty(limitIcebergQuantity);
		oco.setStopClientOrderId(stopClientOrderId);
		oco.setStopIcebergQty(stopIcebergQuantity);
		oco.setIsIsolated(isIsolated);
		return client().newOCO(oco).sync();
	}
	
	// MARKET ORDER
	
	/**
	 * Submits a market order.
	 *
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @param side     Side.
	 *
	 * @return The order response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/market")
	@ApiOperation(value = "Submits a market order.")
	public NewOrderRecord market(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(value = "Side effect type.", defaultValue = "NO_SIDE_EFFECT") SideEffectType sideEffectType)
			throws ApiException {
		var order = new MarketOrder(symbol, side, quantity);
		order.setIsIsolated(isIsolated);
		order.setSideEffectType(sideEffectType);
		return client().newOrder(order).sync();
	}
	
	/**
	 * Submits a market order with the wuote asset quantity
	 *
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @param side     Side.
	 *
	 * @return The order response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/quote")
	@ApiOperation(value = "Submits a market order with the wuote asset quantity.")
	public NewOrderRecord quote(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(value = "Side effect type.", defaultValue = "NO_SIDE_EFFECT") SideEffectType sideEffectType)
			throws ApiException {
		var order = new MarketQuoteOrder(symbol, side, quantity);
		order.setIsIsolated(isIsolated);
		order.setSideEffectType(sideEffectType);
		return client().newOrder(order).sync();
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
	 *
	 * @return The order response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/limit")
	@ApiOperation(value = "Submits a limit order.")
	public NewOrderRecord limit(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce,
			@RequestParam(required = false) @ApiParam(ICEBERG_DESCRIPTION) String icebergQty,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(value = "Side effect type.", defaultValue = "NO_SIDE_EFFECT") SideEffectType sideEffectType)
			throws ApiException {
		var order = new LimitOrder(symbol, side, quantity, price, icebergQty, handleNullTimeInForce(timeInForce));
		order.setIsIsolated(isIsolated);
		order.setSideEffectType(sideEffectType);
		return client().newOrder(order).sync();
	}
	
	/**
	 * Submits a limit maker order.
	 *
	 * @param symbol   Symbol.
	 * @param side     Side.
	 * @param quantity Quantity.
	 * @param price    Price.
	 *
	 * @return The order response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/limit-maker")
	@ApiOperation(value = "Submits a limit maker order.")
	public NewOrderRecord limitMaker(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(value = "Side effect type.", defaultValue = "NO_SIDE_EFFECT") SideEffectType sideEffectType)
			throws ApiException {
		var order = new LimitMakerOrder(symbol, side, quantity, price);
		order.setIsIsolated(isIsolated);
		order.setSideEffectType(sideEffectType);
		return client().newOrder(order).sync();
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
	 *
	 * @return The order response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/stop-loss-limit")
	@ApiOperation(value = "Submits a stop loss limit order.")
	public NewOrderRecord stopLossLimit(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam(required = false) @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam(required = false, value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(value = "Side effect type.", defaultValue = "NO_SIDE_EFFECT") SideEffectType sideEffectType)
			throws ApiException {
		StopLossLimitOrder order;
		// handle null values
		handleNullTrailingDeltaAndStopPrice(trailingDelta, stopPrice);
		timeInForce = handleNullTimeInForce(timeInForce);
		
		if (stopPrice != null) {
			order = new StopLossLimitOrder(symbol, side, quantity, price, stopPrice, timeInForce);
		} else {
			order = new StopLossLimitOrder(symbol, side, quantity, price, trailingDelta, timeInForce);
		}
		order.setIsIsolated(isIsolated);
		order.setSideEffectType(sideEffectType);
		return client().newOrder(order).sync();
	}
	
	/**
	 * Submits a stop loss order.
	 *
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param stopPrice     Stop price.
	 * @param trailingDelta Trailing delta.
	 *
	 * @return The order response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/stop-loss")
	@ApiOperation(value = "Submits a stop loss limit order.")
	public NewOrderRecord stopLoss(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(value = "Side effect type.", defaultValue = "NO_SIDE_EFFECT") SideEffectType sideEffectType)
			throws ApiException {
		StopLossOrder order;
		// handle null values
		handleNullTrailingDeltaAndStopPrice(trailingDelta, stopPrice);
		
		if (stopPrice != null) {
			order = new StopLossOrder(symbol, side, quantity, stopPrice);
		} else {
			order = new StopLossOrder(symbol, side, quantity, trailingDelta);
		}
		order.setIsIsolated(isIsolated);
		order.setSideEffectType(sideEffectType);
		return client().newOrder(order).sync();
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
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/take-profit-limit")
	@ApiOperation(value = "Submits a take profit limit order.")
	public NewOrderRecord takeProfitLimit(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(PRICE_DESCRIPTION) String price,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam(required = false) @ApiParam(ICEBERG_DESCRIPTION) String icebergQty,
			@RequestParam(required = false) @ApiParam(value = TIF_DESCRIPTION, defaultValue = DEFAULT_TIF) TimeInForce timeInForce,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(value = "Side effect type.", defaultValue = "NO_SIDE_EFFECT") SideEffectType sideEffectType)
			throws ApiException {
		handleNullTrailingDeltaAndStopPrice(trailingDelta, stopPrice);
		timeInForce = handleNullTimeInForce(timeInForce);
		TakeProfitLimitOrder order;
		if (stopPrice != null) {
			order = new TakeProfitLimitOrder(symbol, side, quantity, price, stopPrice, icebergQty, timeInForce);
		} else {
			order = new TakeProfitLimitOrder(symbol, side, quantity, price, trailingDelta, icebergQty, timeInForce);
		}
		order.setIsIsolated(isIsolated);
		order.setSideEffectType(sideEffectType);
		return client().newOrder(order).sync();
	}
	
	/**
	 * Submits a take profit order.
	 *
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @param stopPrice     Stop price.
	 *
	 * @return The order response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "order/take-profit")
	@ApiOperation(value = "Submits a take profit order.")
	public NewOrderRecord takeProfit(
			@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol,
			@RequestParam @ApiParam(SIDE_DESCRIPTION) OrderSide side,
			@RequestParam @ApiParam(QUANTITY_DESCRIPTION) String quantity,
			@RequestParam @ApiParam(DELTA_DESCRIPTION) Long trailingDelta,
			@RequestParam @ApiParam(STOP_PRICE_DESCRIPTION) String stopPrice,
			@RequestParam(required = false) @ApiParam("For isolated symbol.") Boolean isIsolated,
			@RequestParam(required = false) @ApiParam(value = "Side effect type.", defaultValue = "NO_SIDE_EFFECT") SideEffectType sideEffectType)
			throws ApiException {
		TakeProfitOrder order;
		handleNullTrailingDeltaAndStopPrice(trailingDelta, stopPrice);
		
		if (stopPrice != null) {
			order = new TakeProfitOrder(symbol, side, quantity, stopPrice);
		} else {
			order = new TakeProfitOrder(symbol, side, quantity, trailingDelta);
		}
		order.setIsIsolated(isIsolated);
		order.setSideEffectType(sideEffectType);
		return client().newOrder(order).sync();
	}
	
	// Handle Null values
	
	/**
	 * Will thow an Api Exception if trailingDelta and stopPrice are null
	 *
	 * @param trailingDelta trailingDelta.
	 * @param stopPrice     stopPrice.
	 *
	 * @throws ApiException Exception sent if both null.
	 */
	private void handleNullTrailingDeltaAndStopPrice(Long trailingDelta, String stopPrice) throws ApiException {
		if (trailingDelta == null && stopPrice == null) {
			throw new ApiException(400, "Missing trailingDelta or stopPrice");
		}
	}
	
	/**
	 * @param timeInForce input time in force
	 *
	 * @return a default Time in force if input is null
	 */
	private TimeInForce handleNullTimeInForce(TimeInForce timeInForce) {
		return timeInForce != null ? timeInForce : TimeInForce.GTC;
	}
}