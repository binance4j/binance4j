package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.convert.dto.ConversionHistory;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Convert endpoints. */
@RestController
@RequestMapping("api/v1/convert")
@Api(value = "Convert", tags = "Convert", produces = "application/json", description = "Convert endpoints")
public class ConvertController extends BaseController {

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Assets conversion history.
	 * @throws ApiException Something went wrong with the API.
	 */
	@GetMapping(path = "conversions", produces = "application/json")
	@ApiOperation(value = "Get conversions.")
	public ConversionHistory getConversions(@RequestParam(required = true) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = true) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit) throws ApiException {
		return connectors.convert().getConversions(new TimeFrame(startTime, endTime, limit)).sync();
	}
}