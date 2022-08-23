package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.rebate.dto.SpotRebateHistoryResponse;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.configuration.Binance4jConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Rebate endpoints. */
@RestController
@RequestMapping(Binance4jConfiguration.CONNECTORS_BASE_URI + "rebate")
@Api(value = "Rebate", tags = "Rebate", produces = "application/json", description = "Rebate endpoints")
public class RebateController extends BaseController {
	/**
	 * Creates instance.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	public RebateController(Connectors connectors) {
		super(connectors);
	}

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param page      Results page.
	 * @param limit     Results limit.
	 * @return The spot rebate history records.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "tax-query")
	@ApiOperation(value = "Get the spot rebate history records.")
	public SpotRebateHistoryResponse getSpotRebateHistoryRecords(
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(value = PAGE_DESCRIPTION, defaultValue = "1") Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().rebate().getSpotRebateHistoryRecords(new FramedPaging(startTime, endTime, page, limit))
				.sync();
	}
}