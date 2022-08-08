package com.binance4j.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.staking.dto.LeftQuota;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.dto.StakingRecord;
import com.binance4j.staking.dto.TransactionType;
import com.binance4j.staking.param.HistoryParams;
import com.binance4j.staking.param.LeftQuotaParams;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Staking endpoints. */
@RestController
@RequestMapping("api/v1/staking")
@Api(value = "Staking", tags = "Staking", produces = "application/json", description = "Staking endpoints")
public class StakingControllerTodo extends BaseController {

	/**
	 * @param product   Product type.
	 * @param txnType   Transaction type.
	 * @param asset     Product name.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @return Staking history.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "trades", produces = "application/json", params = { "product", "txnType", "asset" })
	@ApiOperation(value = "Get staking history.")
	public List<StakingRecord> getTrades(@RequestParam(required = true) @ApiParam(example = "STAKING", value = "Product type.") ProductType product,
			@RequestParam(required = true) @ApiParam(example = "SUBSCRIPTION", value = "Transaction type.") TransactionType txnType,
			@RequestParam(required = true) @ApiParam(example = "BNB", value = "Product name.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.staking().getHistory(new HistoryParams(product, txnType, asset), new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return Personal left quota of Staking product.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "left-quota", produces = "application/json", params = { "product", "productId" })
	@ApiOperation(value = "Get personal left quota of Staking product.")
	public LeftQuota getLeftQuota(@RequestParam(required = true) @ApiParam(example = "STAKING", value = "Product type.") ProductType product,
			@RequestParam(required = true) @ApiParam(example = "BNB", value = "Product name.") String productId) throws ApiException {
		return connectors.staking().getLeftQuota(new LeftQuotaParams(product, productId)).sync();
	}
}