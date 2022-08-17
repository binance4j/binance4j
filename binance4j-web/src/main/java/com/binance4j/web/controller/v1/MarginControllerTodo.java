package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.Account;
import com.binance4j.margin.dto.Asset;
import com.binance4j.margin.dto.CrossSymbol;
import com.binance4j.margin.dto.ForceLiquidationRecords;
import com.binance4j.margin.dto.InterestHistory;
import com.binance4j.margin.dto.LoanRecord;
import com.binance4j.margin.dto.PriceIndex;
import com.binance4j.margin.dto.RepayRecords;
import com.binance4j.margin.dto.Transaction;
import com.binance4j.margin.dto.TransferRecords;
import com.binance4j.margin.dto.TransferType;
import com.binance4j.margin.param.AssetParams;
import com.binance4j.margin.param.BorrowParams;
import com.binance4j.margin.param.ForceLiquidationRecordParams;
import com.binance4j.margin.param.PairParams;
import com.binance4j.margin.param.PriceIndexParams;
import com.binance4j.margin.param.RepayParams;
import com.binance4j.margin.param.TransactionHistoryParams;
import com.binance4j.margin.param.TransferParams;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Margin endpoints. */
@RestController
@RequestMapping("api/v1/margin")
@Api(value = "Margin", tags = "Margin", produces = "application/json", description = "Margin endpoints")
public class MarginControllerTodo extends BaseController {

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
	 * @return The transaction response.
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
	 * @return The transaction response.
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
	 * @return The transaction response.
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
	 * @return An asset on the platform.
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
	 * @return A Cross margin Asset pair.
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
	 * @param symbol Symbol.
	 * @return All Cross margin Asset pairs.
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
	 * @return All Cross margin Asset pairs.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "price-index")
	@ApiOperation(value = "Get the price index of a symbol.")
	public PriceIndex getPriceIndex(@RequestParam @ApiParam(SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return client().getPriceIndex(new PriceIndexParams(symbol)).sync();
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
	 * @return A list of transfer history records.
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
	 * @return A loan record.
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
	 * @return A repay record.
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
	 * @return A repay record.
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
	 * @param asset          Related asset.
	 * @param isolatedSymbol Isolated symbol.
	 * @param txId           Transaction id in POST /sapi/v1/margin/repay.
	 * @param archived       Set to true for archived data from 6 months ago.
	 * @param startTime      Start time in ms.
	 * @param endTime        End time in ms.
	 * @param page           Result page.
	 * @param limit          Results in the page.
	 * @return A repay record.
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
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "account")
	@ApiOperation(value = "Get current account information.")
	public Account getAccount() throws ApiException {
		return client().getAccount().sync();
	}
}