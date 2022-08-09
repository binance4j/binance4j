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
import com.binance4j.savings.dto.Featured;
import com.binance4j.savings.dto.FixedProject;
import com.binance4j.savings.dto.FixedProjectPosition;
import com.binance4j.savings.dto.FixedProjectPositionStatus;
import com.binance4j.savings.dto.FixedProjectSorting;
import com.binance4j.savings.dto.FixedProjectStatus;
import com.binance4j.savings.dto.FixedProjectType;
import com.binance4j.savings.dto.FlexibleProduct;
import com.binance4j.savings.dto.FlexibleProductPosition;
import com.binance4j.savings.dto.FlexibleProductStatus;
import com.binance4j.savings.dto.Interest;
import com.binance4j.savings.dto.LendingAccount;
import com.binance4j.savings.dto.LendingType;
import com.binance4j.savings.dto.PositionChangedResponse;
import com.binance4j.savings.dto.ProductType;
import com.binance4j.savings.dto.Purchase;
import com.binance4j.savings.dto.PurchaseQuota;
import com.binance4j.savings.dto.PurchaseResponse;
import com.binance4j.savings.dto.Redemption;
import com.binance4j.savings.dto.RedemptionQuota;
import com.binance4j.savings.dto.Sorting;
import com.binance4j.savings.param.ChangePositionParams;
import com.binance4j.savings.param.FixedProjectListParams;
import com.binance4j.savings.param.FixedProjectPositionParams;
import com.binance4j.savings.param.FixedPurchaseParams;
import com.binance4j.savings.param.FlexibleProductPositionParams;
import com.binance4j.savings.param.FlexibleProductsParams;
import com.binance4j.savings.param.FlexiblePurchaseParams;
import com.binance4j.savings.param.LendingParams;
import com.binance4j.savings.param.PurchaseQuotaParams;
import com.binance4j.savings.param.RedemptionParams;
import com.binance4j.savings.param.RedemptionQuotaParams;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Savings endpoints. */
@RestController
@RequestMapping("api/v1/savings")
@Api(value = "Savings", tags = "Savings", produces = "application/json", description = "Savings endpoints")
public class SavingsController extends BaseController {

	/**
	 * @param status   Product status.
	 * @param featured Featured.
	 * @param page     Results page.
	 * @param limit    Results limit.
	 * @return Flexible product list.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "flexible-products", produces = "application/json")
	@ApiOperation(value = "Get flexible product list.")
	public List<FlexibleProduct> getFlexibleProducts(@RequestParam(required = false) @ApiParam(value = "Product status.") FlexibleProductStatus status,
			@RequestParam(required = false) @ApiParam(value = "Freatured.") Featured featured,
			@RequestParam(required = false) @ApiParam(example = "1", value = "Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.savings().getFlexibleProducts(new FlexibleProductsParams(status, featured), new Paging(page, limit)).sync();
	}

	/**
	 * @param status   Product status.
	 * @param featured Featured.
	 * @return Left daily purchase quota of flexible product.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "left-purchase-quota", produces = "application/json", params = { "productId" })
	@ApiOperation(value = "Get left daily purchase quota of flexible product.")
	public PurchaseQuota getLeftDailyFlexiblePurchaseQuota(@RequestParam(required = true) @ApiParam(value = "Product id.") String productId)
			throws ApiException {
		return connectors.savings().getLeftDailyFlexiblePurchaseQuota(new PurchaseQuotaParams(productId)).sync();
	}

	/**
	 * @param status   Product status.
	 * @param featured Featured.
	 * @return Left daily redemption quota of flexible product.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "left-redemption-quota", produces = "application/json", params = { "productId", "productType" })
	@ApiOperation(value = "Get left daily redemption quota of flexible product.")
	public RedemptionQuota getLeftDailyRedemptionQuota(@RequestParam(required = true) @ApiParam(value = "Product id.") String productId,
			@RequestParam(required = true) @ApiParam(value = "Product type.") ProductType productType) throws ApiException {
		return connectors.savings().getLeftDailyRedemptionQuota(new RedemptionQuotaParams(productId, productType)).sync();
	}

	/**
	 * Purchase Flexible Product.
	 * 
	 * @param productId Product id.
	 * @param amount    Amount.
	 * @return Flexible purchase response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "purchase-flexible", produces = "application/json", params = { "productId", "amount" })
	@ApiOperation(value = "Purchase Flexible Product.")
	public PurchaseResponse purchaseFlexible(@RequestParam(required = true) @ApiParam(value = "Product id.") String productId,
			@RequestParam(required = true) @ApiParam(value = "Amount.") String amount) throws ApiException {
		return connectors.savings().purchaseFlexible(new FlexiblePurchaseParams(productId, amount)).sync();
	}

	/**
	 * Redeem Flexible Product.
	 * 
	 * @param productId Product id.
	 * @param amount    Amount.
	 * @return Flexible redemption response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "redeem-flexible", produces = "application/json", params = { "productId", "amount", "type" })
	@ApiOperation(value = "Redeem Flexible Product.")
	public Void redeemFlexible(@RequestParam(required = true) @ApiParam(value = "Product id.") String productId,
			@RequestParam(required = true) @ApiParam(value = "Amount.") String amount,
			@RequestParam(required = true) @ApiParam(value = "Product type.") ProductType type) throws ApiException {
		return connectors.savings().redeemFlexible(new RedemptionParams(productId, amount, type)).sync();
	}

	/**
	 * @param asset Asset.
	 * @return Flexible product position.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "flexible-position", produces = "application/json")
	@ApiOperation(value = "Get flexible product position.")
	public List<FlexibleProductPosition> getFlexibleProductPosition(@RequestParam(required = false) @ApiParam(example = "BUSD", value = "Asset.") String asset)
			throws ApiException {
		return connectors.savings().getFlexibleProductPosition(new FlexibleProductPositionParams(asset)).sync();
	}

	/**
	 * @param type      Project type.
	 * @param asset     Asset.
	 * @param status    Project status. default: {@code START_TIME}.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @param sortBy    Project sorting.
	 * @param isSortAsc Sort ascending. Default: true.
	 * @return Tixed and activity project list.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "fixed-projects", produces = "application/json")
	@ApiOperation(value = "Get fixed and activity project list.")
	public List<FixedProject> getFixedProjects(@RequestParam(required = true) @ApiParam(value = "Project type.") FixedProjectType type,
			@RequestParam(required = false) @ApiParam(example = "BUSD", value = "Asset.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Project status.") FixedProjectStatus status,
			@RequestParam(required = false) @ApiParam(example = "1", value = "Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "Results limit.") Integer limit,
			@RequestParam(required = false) @ApiParam(value = "Project sorting.") FixedProjectSorting sortBy,
			@RequestParam(required = false) @ApiParam(value = "Sort ascending. Default: true.") Boolean isSortAsc) throws ApiException {
		return connectors.savings().getFixedProjects(new FixedProjectListParams(type, asset, status), new Paging(page, limit), new Sorting(sortBy, isSortAsc))
				.sync();
	}

	/**
	 * Purchase fixed projet.
	 * 
	 * @param productId Product id.
	 * @param lot       Lot size.
	 * @return Fixed purchase response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "purchase-fixed", produces = "application/json", params = { "productId", "lot" })
	@ApiOperation(value = "Purchase fixed projet.")
	public PurchaseResponse purchaseFixed(@RequestParam(required = true) @ApiParam(value = "Product id.") String productId,
			@RequestParam(required = true) @ApiParam(value = "Lot size.") Long lot) throws ApiException {
		return connectors.savings().purchaseFixed(new FixedPurchaseParams(productId, lot)).sync();
	}

	/**
	 * @param asset     Asset.
	 * @param projectId Project id.
	 * @param status    Project status.
	 * @return Flexible product position.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "fixed-position", produces = "application/json")
	@ApiOperation(value = "Get fixed projet position.")
	public List<FixedProjectPosition> getFixedProjectPosition(@RequestParam(required = false) @ApiParam(example = "BUSD", value = "Asset.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Project id.") String projectId,
			@RequestParam(required = false) @ApiParam(value = "Project status.") FixedProjectPositionStatus status) throws ApiException {
		return connectors.savings().getFixedProjectPosition(new FixedProjectPositionParams(asset, projectId, status)).sync();
	}

	/**
	 * @return Lending account.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "account", produces = "application/json")
	@ApiOperation(value = "Get lending account.")
	public LendingAccount getAccount() throws ApiException {
		return connectors.savings().getAccount().sync();
	}

	/**
	 * @param lendingType Lending type.
	 * @param asset       Asset name.
	 * @param startTime   Start time in ms.
	 * @param endTime     End time in ms.
	 * @param page        Results page.
	 * @param limit       Results limit.
	 * @return Purchase record.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "purchases", produces = "application/json", params = { "lendingType" })
	@ApiOperation(value = "Get purchase record.")
	public List<Purchase> getPurchases(@RequestParam(required = true) @ApiParam(value = "Lending type.") LendingType lendingType,
			@RequestParam(required = false) @ApiParam(example = "BNB", value = "Asset.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.savings().getPurchases(new LendingParams(lendingType, asset), new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param lendingType Lending type.
	 * @param asset       Asset name.
	 * @param startTime   Start time in ms.
	 * @param endTime     End time in ms.
	 * @param page        Results page.
	 * @param limit       Results limit.
	 * @return Redemption record.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "redemptions", produces = "application/json", params = { "lendingType" })
	@ApiOperation(value = "Get redemption record.")
	public List<Redemption> getRedemptions(@RequestParam(required = true) @ApiParam(value = "Lending type.") LendingType lendingType,
			@RequestParam(required = false) @ApiParam(example = "BNB", value = "Asset.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.savings().getRedemptions(new LendingParams(lendingType, asset), new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * @param lendingType Lending type.
	 * @param asset       Asset name.
	 * @param startTime   Start time in ms.
	 * @param endTime     End time in ms.
	 * @param page        Results page.
	 * @param limit       Results limit.
	 * @return Interest record.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "interests", produces = "application/json", params = { "lendingType" })
	@ApiOperation(value = "Get interest record.")
	public List<Interest> getInterests(@RequestParam(required = true) @ApiParam(value = "Lending type.") LendingType lendingType,
			@RequestParam(required = false) @ApiParam(example = "BNB", value = "Asset.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.savings().getInterests(new LendingParams(lendingType, asset), new FramedPaging(startTime, endTime, page, limit)).sync();
	}

	/**
	 * Change fixed/activity position to daily position.
	 * 
	 * @param projectId  Project id.
	 * @param lot        Lot size.
	 * @param positionId Position id for fixed position.
	 * @return Change response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@PostMapping(path = "change-position", produces = "application/json", params = { "projectId", "lot" })
	@ApiOperation(value = "Change fixed/activity position to daily position.")
	public PositionChangedResponse fixedToDailyPosition(@RequestParam(required = true) @ApiParam(value = "Lending type.") String projectId,
			@RequestParam(required = true) @ApiParam(value = "Lot size.") Long lot,
			@RequestParam(required = false) @ApiParam(value = "Position id.") Long positionId) throws ApiException {
		return connectors.savings().fixedToDailyPosition(new ChangePositionParams(projectId, lot, positionId)).sync();
	}
}