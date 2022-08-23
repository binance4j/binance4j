package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.convert.dto.ConversionHistory;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.configuration.Binance4jConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Convert endpoints. */
@RestController
@RequestMapping(Binance4jConfiguration.CONNECTORS_BASE_URI + "convert")
@Api(value = "Convert", tags = "Convert", produces = "application/json", description = "Convert endpoints")
public class ConvertController extends BaseController {
	/**
	 * Creates instance.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	public ConvertController(Connectors connectors) {
		super(connectors);
	}

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Assets conversion history.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "conversions")
	@ApiOperation(value = "Get conversions.")
	public ConversionHistory getConversions(
			@RequestParam @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().convert().getConversions(new TimeFrame(startTime, endTime, limit)).sync();
	}
}