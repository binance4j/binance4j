package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.dto.AssetHistory;
import com.binance4j.nft.dto.DepositHistory;
import com.binance4j.nft.dto.OrderType;
import com.binance4j.nft.dto.TransactionHistory;
import com.binance4j.nft.dto.WithdrawHistory;
import com.binance4j.nft.param.TransactionHistoryParams;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.configuration.Binance4jConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for NFT endpoints. */
@RestController
@RequestMapping(Binance4jConfiguration.CONNECTORS_BASE_URI + "nft")
@Api(value = "NFT", tags = "NFT", produces = "application/json", description = "NFT endpoints")
public class NFTController extends BaseController {
	/**
	 * Creates instance.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	public NFTController(Connectors connectors) {
		super(connectors);
	}

	/**
	 * @return NFT client.
	 */
	private NFTClient client() {
		return connectors.rest().nft();
	}

	/**
	 * @param orderType Order type.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Result page.
	 * @param limit     Results in the page.
	 * @return NFT Transaction History.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "transactions")
	@ApiOperation(value = "Get NFT Transaction History.")
	public TransactionHistory getTransactions(
			@RequestParam @ApiParam("Order type.") OrderType orderType,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getTransactions(new TransactionHistoryParams(orderType),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Result page.
	 * @param limit     Results in the page.
	 * @return NFT deposit History.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "deposits")
	@ApiOperation(value = "Get NFT deposit History.")

	public DepositHistory getDeposits(
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getDeposits(new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Result page.
	 * @param limit     Results in the page.
	 * @return NFT withdraw History.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "withdraws")
	@ApiOperation(value = "Get NFT withdraw History.")

	public WithdrawHistory getWithdraws(
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getWithdraws(new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param page  Result page.
	 * @param limit Results in the page.
	 * @return NFT assets.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "assets")
	@ApiOperation(value = "Get NFT assets.")

	public AssetHistory getAssets(
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getAssets(new Paging(page, limit)).sync();
	}
}