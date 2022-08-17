package com.binance4j.web.controller.v1;

import java.util.List;

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
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.annotation.JsonPostMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	@JsonGetMapping(path = "flexible-products")
	@ApiOperation(value = "Get flexible product list.")
	public List<FlexibleProduct> getFlexibleProducts(
			@RequestParam(required = false, name = "Product status.") FlexibleProductStatus status,
			@RequestParam(required = false, name = "Freatured.") Featured featured,
			@RequestParam(required = false, name = "Results page.") Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().savings()
				.getFlexibleProducts(new FlexibleProductsParams(status, featured), new Paging(page, limit)).sync();
	}

	/**
	 * @param status   Product status.
	 * @param featured Featured.
	 * @return Left daily purchase quota of flexible product.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "left-purchase-quota")
	@ApiOperation(value = "Get left daily purchase quota of flexible product.")
	public PurchaseQuota getLeftDailyFlexiblePurchaseQuota(
			@RequestParam(name = "Product id.") String productId) throws ApiException {
		return connectors.rest().savings().getLeftDailyFlexiblePurchaseQuota(new PurchaseQuotaParams(productId)).sync();
	}

	/**
	 * @param status   Product status.
	 * @param featured Featured.
	 * @return Left daily redemption quota of flexible product.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "left-redemption-quota")
	@ApiOperation(value = "Get left daily redemption quota of flexible product.")
	public RedemptionQuota getLeftDailyRedemptionQuota(
			@RequestParam(name = "Product id.") String productId,
			@RequestParam(name = "Product type.") ProductType productType)
			throws ApiException {
		return connectors.rest().savings()
				.getLeftDailyRedemptionQuota(new RedemptionQuotaParams(productId, productType))
				.sync();
	}

	/**
	 * Purchase Flexible Product.
	 * 
	 * @param productId Product id.
	 * @param amount    Amount.
	 * @return Flexible purchase response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonPostMapping(path = "purchase-flexible")
	@ApiOperation(value = "Purchase Flexible Product.")
	public PurchaseResponse purchaseFlexible(
			@RequestParam(name = "Product id.") String productId,
			@RequestParam(name = "Amount.") String amount) throws ApiException {
		return connectors.rest().savings().purchaseFlexible(new FlexiblePurchaseParams(productId, amount)).sync();
	}

	/**
	 * Redeem Flexible Product.
	 * 
	 * @param productId Product id.
	 * @param amount    Amount.
	 * @return Flexible redemption response.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonPostMapping(path = "redeem-flexible")
	@ApiOperation(value = "Redeem Flexible Product.")
	public Void redeemFlexible(@RequestParam(name = "Product id.") String productId,
			@RequestParam(name = "Amount.") String amount,
			@RequestParam(name = "Product type.") ProductType type) throws ApiException {
		return connectors.rest().savings().redeemFlexible(new RedemptionParams(productId, amount, type)).sync();
	}

	/**
	 * @param asset Asset.
	 * @return Flexible product position.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "flexible-position")
	@ApiOperation(value = "Get flexible product position.")
	public List<FlexibleProductPosition> getFlexibleProductPosition(
			@RequestParam(required = false, name = "Asset.") String asset)
			throws ApiException {
		return connectors.rest().savings().getFlexibleProductPosition(new FlexibleProductPositionParams(asset)).sync();
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
	@JsonGetMapping(path = "fixed-projects")
	@ApiOperation(value = "Get fixed and activity project list.")
	public List<FixedProject> getFixedProjects(
			@RequestParam(name = "Project type.") FixedProjectType type,
			@RequestParam(required = false, name = "Asset.") String asset,
			@RequestParam(required = false, name = "Project status.") FixedProjectStatus status,
			@RequestParam(required = false, name = "Results page.") Integer page,
			@RequestParam(required = false, name = "Results limit.") Integer limit,
			@RequestParam(required = false, name = "Project sorting.") FixedProjectSorting sortBy,
			@RequestParam(required = false, name = "Sort ascending. Default: true.") Boolean isSortAsc)
			throws ApiException {
		return connectors.rest().savings()
				.getFixedProjects(new FixedProjectListParams(type, asset, status), new Paging(page, limit),
						new Sorting(sortBy, isSortAsc))
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
	@JsonPostMapping(path = "purchase-fixed")
	@ApiOperation(value = "Purchase fixed projet.")
	public PurchaseResponse purchaseFixed(
			@RequestParam(name = "Product id.") String productId,
			@RequestParam(name = "Lot size.") Long lot) throws ApiException {
		return connectors.rest().savings().purchaseFixed(new FixedPurchaseParams(productId, lot)).sync();
	}

	/**
	 * @param asset     Asset.
	 * @param projectId Project id.
	 * @param status    Project status.
	 * @return Flexible product position.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "fixed-position")
	@ApiOperation(value = "Get fixed projet position.")
	public List<FixedProjectPosition> getFixedProjectPosition(
			@RequestParam(required = false, name = "Asset.") String asset,
			@RequestParam(required = false, name = "Project id.") String projectId,
			@RequestParam(required = false, name = "Project status.") FixedProjectPositionStatus status)
			throws ApiException {
		return connectors.rest().savings()
				.getFixedProjectPosition(new FixedProjectPositionParams(asset, projectId, status))
				.sync();
	}

	/**
	 * @return Lending account.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "account")
	@ApiOperation(value = "Get lending account.")
	public LendingAccount getAccount() throws ApiException {
		return connectors.rest().savings().getAccount().sync();
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
	@JsonGetMapping(path = "purchases")
	@ApiOperation(value = "Get purchase record.")
	public List<Purchase> getPurchases(
			@RequestParam(name = "Lending type.") LendingType lendingType,
			@RequestParam(required = false, name = "Asset.") String asset,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().savings()
				.getPurchases(new LendingParams(lendingType, asset), new FramedPaging(startTime, endTime, page, limit))
				.sync();
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
	@JsonGetMapping(path = "redemptions")
	@ApiOperation(value = "Get redemption record.")
	public List<Redemption> getRedemptions(
			@RequestParam(name = "Lending type.") LendingType lendingType,
			@RequestParam(required = false, name = "Asset.") String asset,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().savings().getRedemptions(new LendingParams(lendingType, asset),
				new FramedPaging(startTime, endTime, page, limit)).sync();
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
	@JsonGetMapping(path = "interests")
	@ApiOperation(value = "Get interest record.")
	public List<Interest> getInterests(
			@RequestParam(name = "Lending type.") LendingType lendingType,
			@RequestParam(required = false, name = "Asset.") String asset,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().savings()
				.getInterests(new LendingParams(lendingType, asset), new FramedPaging(startTime, endTime, page, limit))
				.sync();
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
	@JsonPostMapping(path = "change-position")
	@ApiOperation(value = "Change fixed/activity position to daily position.")
	public PositionChangedResponse fixedToDailyPosition(
			@RequestParam(name = "Lending type.") String projectId,
			@RequestParam(name = "Lot size.") Long lot,
			@RequestParam(required = false, name = "Position id.") Long positionId) throws ApiException {
		return connectors.rest().savings().fixedToDailyPosition(new ChangePositionParams(projectId, lot, positionId))
				.sync();
	}
}