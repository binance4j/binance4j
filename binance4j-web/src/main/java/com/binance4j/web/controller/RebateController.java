package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.rebate.dto.SpotRebateHistoryResponse;
import com.binance4j.web.annotation.JsonGetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Rebate endpoints. */
@RestController
@RequestMapping("api/v1/rebate")
@Api(value = "Rebate", tags = "Rebate", produces = "application/json", description = "Rebate endpoints")
public class RebateController extends BaseController {

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @return The spot rebate history records.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "tax-query")
	@ApiOperation(value = "Get the spot rebate history records.")
	public SpotRebateHistoryResponse getSpotRebateHistoryRecords(
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page", defaultValue = "1") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.rebate().getSpotRebateHistoryRecords(new FramedPaging(startTime, endTime, page, limit))
				.sync();
	}
}