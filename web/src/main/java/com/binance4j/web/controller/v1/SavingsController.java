package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.savings.client.SavingsClient;
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
import com.binance4j.web.configuration.Binance4jWeb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Controller for Savings endpoints.
 */
@RestController
@RequestMapping(Binance4jWeb.CONNECTORS_BASE_URI + "savings")
@Api(value = "Savings", tags = "Savings", produces = "application/json", description = "Savings endpoints")
public class SavingsController extends BaseController {
	/**
	 * Creates instance.
	 *
	 * @param connectors Binance4j connectors.
	 */
	public SavingsController(Connectors connectors) {
		super(connectors);
	}
	
	/**
	 * @return Savings client.
	 */
	private SavingsClient client() {
		return connectors.rest().savings();
	}
	
	/**
	 * @param status   Product status.
	 * @param featured Featured.
	 * @param page     Results page.
	 * @param limit    Results limit.
	 *
	 * @return Flexible product list.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "flexible-products")
	@ApiOperation(value = "Get flexible product list.")
	public List<FlexibleProduct> getFlexibleProducts(
			@RequestParam(required = false) @ApiParam("Product status.") FlexibleProductStatus status,
			@RequestParam(required = false) @ApiParam("Freatured.") Featured featured,
			@RequestParam(required = false) @ApiParam("Results page.") Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getFlexibleProducts(new FlexibleProductsParams(status, featured), new Paging(page, limit)).sync();
	}
	
	/**
	 * @return Left daily purchase quota of flexible product.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "left-purchase-quota")
	@ApiOperation(value = "Get left daily purchase quota of flexible product.")
	public PurchaseQuota getLeftDailyFlexiblePurchaseQuota(
			@RequestParam @ApiParam("Product id.") String productId) throws ApiException {
		return client().getLeftDailyFlexiblePurchaseQuota(new PurchaseQuotaParams(productId)).sync();
	}
	
	/**
	 * @param productId   Product id.
	 * @param productType Product type.
	 *
	 * @return Left daily redemption quota of flexible product.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "left-redemption-quota")
	@ApiOperation(value = "Get left daily redemption quota of flexible product.")
	public RedemptionQuota getLeftDailyRedemptionQuota(
			@RequestParam @ApiParam("Product id.") String productId,
			@RequestParam @ApiParam("Product type.") ProductType productType)
			throws ApiException {
		return client()
				.getLeftDailyRedemptionQuota(new RedemptionQuotaParams(productId, productType))
				.sync();
	}
	
	/**
	 * Purchase Flexible Product.
	 *
	 * @param productId Product id.
	 * @param amount    Amount.
	 *
	 * @return Flexible purchase response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "purchase-flexible")
	@ApiOperation(value = "Purchase Flexible Product.")
	public PurchaseResponse purchaseFlexible(
			@RequestParam @ApiParam("Product id.") String productId,
			@RequestParam @ApiParam("Amount.") String amount) throws ApiException {
		return client().purchaseFlexible(new FlexiblePurchaseParams(productId, amount)).sync();
	}
	
	/**
	 * Redeem Flexible Product.
	 *
	 * @param productId Product id.
	 * @param amount    Amount.
	 *
	 * @return Flexible redemption response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "redeem-flexible")
	@ApiOperation(value = "Redeem Flexible Product.")
	public Void redeemFlexible(@RequestParam @ApiParam("Product id.") String productId,
	                           @RequestParam @ApiParam("Amount.") String amount,
	                           @RequestParam @ApiParam("Product type.") ProductType type) throws ApiException {
		return client().redeemFlexible(new RedemptionParams(productId, amount, type)).sync();
	}
	
	/**
	 * @param asset Asset.
	 *
	 * @return Flexible product position.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "flexible-position")
	@ApiOperation(value = "Get flexible product position.")
	public List<FlexibleProductPosition> getFlexibleProductPosition(
			@RequestParam(required = false) @ApiParam("Asset.") String asset)
			throws ApiException {
		return client().getFlexibleProductPosition(new FlexibleProductPositionParams(asset)).sync();
	}
	
	/**
	 * @param type      Project type.
	 * @param asset     Asset.
	 * @param status    Project status. default: `START_TIME`.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @param sortBy    Project sorting.
	 * @param isSortAsc Sort ascending. Default: true.
	 *
	 * @return Tixed and activity project list.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "fixed-projects")
	@ApiOperation(value = "Get fixed and activity project list.")
	public List<FixedProject> getFixedProjects(
			@RequestParam @ApiParam("Project type.") FixedProjectType type,
			@RequestParam(required = false) @ApiParam("Asset.") String asset,
			@RequestParam(required = false) @ApiParam("Project status.") FixedProjectStatus status,
			@RequestParam(required = false) @ApiParam("Results page.") Integer page,
			@RequestParam(required = false) @ApiParam("Results limit.") Integer limit,
			@RequestParam(required = false) @ApiParam("Project sorting.") FixedProjectSorting sortBy,
			@RequestParam(required = false) @ApiParam("Sort ascending. Default: true.") Boolean isSortAsc)
			throws ApiException {
		return client()
				.getFixedProjects(new FixedProjectListParams(type, asset, status), new Paging(page, limit),
						new Sorting(sortBy, isSortAsc))
				.sync();
	}
	
	/**
	 * Purchase fixed projet.
	 *
	 * @param productId Product id.
	 * @param lot       Lot size.
	 *
	 * @return Fixed purchase response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "purchase-fixed")
	@ApiOperation(value = "Purchase fixed projet.")
	public PurchaseResponse purchaseFixed(
			@RequestParam @ApiParam("Product id.") String productId,
			@RequestParam @ApiParam("Lot size.") Long lot) throws ApiException {
		return client().purchaseFixed(new FixedPurchaseParams(productId, lot)).sync();
	}
	
	/**
	 * @param asset     Asset.
	 * @param projectId Project id.
	 * @param status    Project status.
	 *
	 * @return Flexible product position.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "fixed-position")
	@ApiOperation(value = "Get fixed projet position.")
	public List<FixedProjectPosition> getFixedProjectPosition(
			@RequestParam(required = false) @ApiParam("Asset.") String asset,
			@RequestParam(required = false) @ApiParam("Project id.") String projectId,
			@RequestParam(required = false) @ApiParam("Project status.") FixedProjectPositionStatus status)
			throws ApiException {
		return client()
				.getFixedProjectPosition(new FixedProjectPositionParams(asset, projectId, status))
				.sync();
	}
	
	/**
	 * @return Lending account.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "account")
	@ApiOperation(value = "Get lending account.")
	public LendingAccount getAccount() throws ApiException {
		return client().getAccount().sync();
	}
	
	/**
	 * @param lendingType Lending type.
	 * @param asset       Asset name.
	 * @param startTime   Start time in ms.
	 * @param endTime     End time in ms.
	 * @param page        Results page.
	 * @param limit       Results limit.
	 *
	 * @return Purchase record.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "purchases")
	@ApiOperation(value = "Get purchase record.")
	public List<Purchase> getPurchases(
			@RequestParam @ApiParam("Lending type.") LendingType lendingType,
			@RequestParam(required = false) @ApiParam("Asset.") String asset,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
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
	 *
	 * @return Redemption record.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "redemptions")
	@ApiOperation(value = "Get redemption record.")
	public List<Redemption> getRedemptions(
			@RequestParam @ApiParam("Lending type.") LendingType lendingType,
			@RequestParam(required = false) @ApiParam("Asset.") String asset,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getRedemptions(new LendingParams(lendingType, asset),
				new FramedPaging(startTime, endTime, page, limit)).sync();
	}
	
	/**
	 * @param lendingType Lending type.
	 * @param asset       Asset name.
	 * @param startTime   Start time in ms.
	 * @param endTime     End time in ms.
	 * @param page        Results page.
	 * @param limit       Results limit.
	 *
	 * @return Interest record.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "interests")
	@ApiOperation(value = "Get interest record.")
	public List<Interest> getInterests(
			@RequestParam @ApiParam("Lending type.") LendingType lendingType,
			@RequestParam(required = false) @ApiParam("Asset.") String asset,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
				.getInterests(new LendingParams(lendingType, asset), new FramedPaging(startTime, endTime, page, limit))
				.sync();
	}
	
	/**
	 * Change fixed/activity position to daily position.
	 *
	 * @param projectId  Project id.
	 * @param lot        Lot size.
	 * @param positionId Position id for fixed position.
	 *
	 * @return Change response.
	 *
	 * @throws ApiException Something went wrong.
	 */
	@JsonPostMapping(path = "change-position")
	@ApiOperation(value = "Change fixed/activity position to daily position.")
	public PositionChangedResponse fixedToDailyPosition(
			@RequestParam @ApiParam("Lending type.") String projectId,
			@RequestParam @ApiParam("Lot size.") Long lot,
			@RequestParam(required = false) @ApiParam("Position id.") Long positionId) throws ApiException {
		return client().fixedToDailyPosition(new ChangePositionParams(projectId, lot, positionId))
				.sync();
	}
}