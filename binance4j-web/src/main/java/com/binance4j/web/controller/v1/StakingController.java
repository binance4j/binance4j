package com.binance4j.web.controller.v1;

import java.util.List;

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
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	@JsonGetMapping(path = "products")
	@ApiOperation(value = "Get available Staking product list.")
	public List<Product> getProducts(
			@RequestParam(name = "Product type.") ProductType product,
			@RequestParam(required = false, name = "Product name.") String asset,
			@RequestParam(required = false, name = "Results page.") Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().staking().getProducts(new ProductListParams(product, asset), new Paging(page, limit))
				.sync();
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
	@JsonGetMapping(path = "trades")
	@ApiOperation(value = "Get staking history.")
	public List<StakingRecord> getTrades(
			@RequestParam(name = "Product type.") ProductType product,
			@RequestParam(name = "Transaction type.") TransactionType txnType,
			@RequestParam(name = "Product name.") String asset,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = "Results page.") Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().staking().getHistory(new HistoryParams(product, txnType, asset),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return Personal left quota of Staking product.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "left-quota")
	@ApiOperation(value = "Get personal left quota of Staking product.")
	public LeftQuota getLeftQuota(
			@RequestParam(name = "Product type.") ProductType product,
			@RequestParam(name = "Product id.") String productId)
			throws ApiException {
		return connectors.rest().staking().getLeftQuota(new LeftQuotaParams(product, productId)).sync();
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
	@JsonGetMapping(path = "position")
	@ApiOperation(value = "Get Staking product position.")
	public List<ProductPosition> getPosition(
			@RequestParam(name = "Product type.") ProductType product,
			@RequestParam(required = false, name = "Product name.") String asset,
			@RequestParam(required = false, name = "Product id.") String productId,
			@RequestParam(required = false, name = "Results page.") Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().staking()
				.getPosition(new PositionParams(product, productId, asset), new Paging(page, limit))
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
	@JsonPostMapping(path = "purchase")
	@ApiOperation(value = "Purchase Staking product.")
	public PurchaseResponse purchase(
			@RequestParam(name = "Product type.") ProductType product,
			@RequestParam(name = "Product id.") String productId,
			@RequestParam(name = "Product name.") String amount) throws ApiException {
		return connectors.rest().staking().purchase(new PurchaseParams(product, productId, amount)).sync();
	}

	/**
	 * Redeem Staking product.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return A staking redeem response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonPostMapping(path = "redeem")
	@ApiOperation(value = "Redeem Staking product.")
	public RedeemResponse redeem(
			@RequestParam(name = "Product type.") ProductType product,
			@RequestParam(name = "Product id.") String productId) throws ApiException {
		return connectors.rest().staking().redeem(new RedeemParams(product, productId)).sync();
	}
}