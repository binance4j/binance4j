package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.staking.client.StakingClient;
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
import com.binance4j.web.configuration.Binance4jConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Staking endpoints. */
@RestController
@RequestMapping(Binance4jConfiguration.CONNECTORS_BASE_URI + "staking")
@Api(value = "Staking", tags = "Staking", produces = "application/json", description = "Staking endpoints")
public class StakingController extends BaseController {
	/**
	 * Creates instance.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	public StakingController(Connectors connectors) {
		super(connectors);
	}

	/**
	 * @return Staking client.
	 */
	private StakingClient client() {
		return connectors.rest().staking();
	}

	/**
	 * @param product Product type.
	 * @param asset   Product name.
	 * @param page    Results page.
	 * @param limit   Results limit.
	 * @return Available Staking product list.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "products")
	@ApiOperation(value = "Get available Staking product list.")
	public List<Product> getProducts(
			@RequestParam @ApiParam("Product type.") ProductType product,
			@RequestParam(required = false) @ApiParam("Product name.") String asset,
			@RequestParam(required = false) @ApiParam("Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getProducts(new ProductListParams(product, asset), new Paging(page, limit))
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
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "trades")
	@ApiOperation(value = "Get staking history.")
	public List<StakingRecord> getTrades(
			@RequestParam @ApiParam("Product type.") ProductType product,
			@RequestParam @ApiParam("Transaction type.") TransactionType txnType,
			@RequestParam @ApiParam("Product name.") String asset,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam("Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getHistory(new HistoryParams(product, txnType, asset),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return Personal left quota of Staking product.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "left-quota")
	@ApiOperation(value = "Get personal left quota of Staking product.")
	public LeftQuota getLeftQuota(
			@RequestParam @ApiParam("Product type.") ProductType product,
			@RequestParam @ApiParam("Product id.") String productId)
			throws ApiException {
		return client().getLeftQuota(new LeftQuotaParams(product, productId)).sync();
	}

	/**
	 * @param asset     Product name.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return Staking product position.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "position")
	@ApiOperation(value = "Get Staking product position.")
	public List<ProductPosition> getPosition(
			@RequestParam @ApiParam("Product type.") ProductType product,
			@RequestParam(required = false) @ApiParam("Product name.") String asset,
			@RequestParam(required = false) @ApiParam("Product id.") String productId,
			@RequestParam(required = false) @ApiParam("Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
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
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "purchase")
	@ApiOperation(value = "Purchase Staking product.")
	public PurchaseResponse purchase(
			@RequestParam @ApiParam("Product type.") ProductType product,
			@RequestParam @ApiParam("Product id.") String productId,
			@RequestParam @ApiParam("Product name.") String amount) throws ApiException {
		return client().purchase(new PurchaseParams(product, productId, amount)).sync();
	}

	/**
	 * Redeem Staking product.
	 * 
	 * @param product   Product type.
	 * @param productId Product id.
	 * @return A staking redeem response.
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "redeem")
	@ApiOperation(value = "Redeem Staking product.")
	public RedeemResponse redeem(
			@RequestParam @ApiParam("Product type.") ProductType product,
			@RequestParam @ApiParam("Product id.") String productId) throws ApiException {
		return client().redeem(new RedeemParams(product, productId)).sync();
	}
}