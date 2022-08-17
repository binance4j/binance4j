package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.loan.dto.LoanIncome;
import com.binance4j.loan.dto.LoanIncomeType;
import com.binance4j.loan.param.LoanIncomeHistoryParams;
import com.binance4j.web.annotation.JsonGetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Loan endpoints. */
@RestController
@RequestMapping("api/v1/loan")
@Api(value = "Loan", tags = "Loan", produces = "application/json", description = "Loan endpoints")
public class LoanController extends BaseController {

	/**
	 * @param asset     Asset we want the incomes.
	 * @param type      Loan income type. All types will be returned by default.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Get crypto loans income history.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "income")
	@ApiOperation(value = "Get incomes.")
	public List<LoanIncome> getLoansIncome(
			@RequestParam @ApiParam(value = "Asset.") String asset,
			@RequestParam(required = false) @ApiParam(value = "Income type.") LoanIncomeType type,
			@RequestParam(required = false) @ApiParam(value = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(value = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(value = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().loan()
				.getLoansIncome(new LoanIncomeHistoryParams(asset, type), new TimeFrame(startTime, endTime, limit))
				.sync();
	}
}