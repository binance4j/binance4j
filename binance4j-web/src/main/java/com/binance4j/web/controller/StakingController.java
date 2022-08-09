package com.binance4j.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.staking.dto.LeftQuota;
import com.binance4j.staking.dto.Product;
import com.binance4j.staking.dto.ProductPosition;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.dto.PurchaseResponse;
import com.binance4j.staking.dto.RedeemResponse;
import com.binance4j.staking.dto.StakingRecord;
import com.binance4j.staking.dto.TransactionType;
import com.binance4j.staking.param.HistoryParams;
import com.binance4j.staking.param.LeftQuotaParams;
import com.binance4j.staking.param.PositionParams;
import com.binance4j.staking.param.ProductListParams;
import com.binance4j.staking.param.PurchaseParams;
import com.binance4j.staking.param.RedeemParams;
import com.binance4j.web.annotation.BaseApiResponses;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Staking endpoints. */
@RestController
@RequestMapping("api/v1/staking")
@Api(value = "Staking", tags = "Staking", produces = "application/json", description = "Staking endpoints")
public class StakingController extends BaseController {

	/**
	 * @param product Product type.
	 * @param asset   Product name.
	 * @param page    Results page.
	 * @param limit   Results limit.
	 * @return Available Staking product list.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "products", produces = "application/json", params = {
			"product"
	})
	@ApiOperation(value = "Get available Staking product list.")
	@BaseApiResponses
	public List<Product> getProducts(
			@RequestParam(required = true) @ApiParam(example = "STAKING", value = "Product type.") ProductType product,
			@RequestParam(required = false) @ApiParam(example = "BNB", value = "Product name.") String asset,
			@RequestParam(required = false) @ApiParam(example = "1", value = "Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.staking().getProducts(new ProductListParams(product, asset), new Paging(page, limit)).sync();
	}

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
	@GetMapping(path = "trades", produces = "application/json", params = {
			"product", "txnType"
	})
	@ApiOperation(value = "Get staking history.")
	@BaseApiResponses
	public List<StakingRecord> getTrades(
			@RequestParam(required = true) @ApiParam(example = "STAKING", value = "Product type.") ProductType product,
			@RequestParam(required = true) @ApiParam(example = "SUBSCRIPTION", value = "Transaction type.") TransactionType txnType,
			@RequestParam(required = true) @ApiParam(example = "BNB", value = "Product name.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.staking().getHistory(new HistoryParams(product, txnType, asset),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return Personal left quota of Staking product.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "left-quota", produces = "application/json", params = {
			"product", "productId"
	})
	@ApiOperation(value = "Get personal left quota of Staking product.")
	@BaseApiResponses
	public LeftQuota getLeftQuota(
			@RequestParam(required = true) @ApiParam(example = "STAKING", value = "Product type.") ProductType product,
			@RequestParam(required = true) @ApiParam(example = "Bnb*120", value = "Product id.") String productId)
			throws ApiException {
		return connectors.staking().getLeftQuota(new LeftQuotaParams(product, productId)).sync();
	}

	/**
	 * @param asset     Product name.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return Staking product position.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "position", produces = "application/json", params = {
			"product"
	})
	@ApiOperation(value = "Get Staking product position.")
	@BaseApiResponses
	public List<ProductPosition> getPosition(
			@RequestParam(required = true) @ApiParam(example = "STAKING", value = "Product type.") ProductType product,
			@RequestParam(required = false) @ApiParam(example = "CAKE", value = "Product name.") String asset,
			@RequestParam(required = false) @ApiParam(example = "Cake*120", value = "Product id.") String productId,
			@RequestParam(required = false) @ApiParam(example = "1", value = "Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.staking().getPosition(new PositionParams(product, productId, asset), new Paging(page, limit))
				.sync();
	}

	/**
	 * Purchase Staking product.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 * @param amount    Amount to purchase.
	 * @return A staking purchase response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "purchase", produces = "application/json", params = {
			"product", "productId", "amount"
	})
	@ApiOperation(value = "Purchase Staking product.")
	@BaseApiResponses
	public PurchaseResponse purchase(
			@RequestParam @ApiParam(example = "STAKING", value = "Product type.") ProductType product,
			@RequestParam @ApiParam(example = "Cake*120", value = "Product id.") String productId,
			@RequestParam @ApiParam(example = "CAKE", value = "Product name.") String amount) throws ApiException {
		return connectors.staking().purchase(new PurchaseParams(product, productId, amount)).sync();
	}

	/**
	 * Redeem Staking product.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return A staking redeem response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "redeem", produces = "application/json", params = {
			"product", "productId"
	})
	@ApiOperation(value = "Redeem Staking product.")
	@BaseApiResponses
	public RedeemResponse redeem(
			@RequestParam @ApiParam(example = "STAKING", value = "Product type.") ProductType product,
			@RequestParam @ApiParam(example = "Cake*120", value = "Product id.") String productId) throws ApiException {
		return connectors.staking().redeem(new RedeemParams(product, productId)).sync();
	}
}