package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.convert.client.ConvertClient;
import com.binance4j.convert.dto.ConversionHistory;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("api/v1/convert")
@Api(value = "Convert Controller", tags = "Convert Controller", produces = "application/json", description = "Convert endpoints")
public class ConvertController {

	ConvertClient client;

	public ConvertController(Connectors connectors) {
		this.client = connectors.convert();
	}

	@GetMapping(path = "conversions", produces = "application/json")
	@ApiOperation(value = "Get conversions.")
	public ConversionHistory getTrades(@RequestParam(required = false) @ApiParam(example = "1659824617000", value = "Start time in ms") Long startTime,
			@RequestParam(required = false) @ApiParam(example = "1659824617000", value = "End time in ms") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit") Integer limit) throws ApiException {
		return client.getConversions(new TimeFrame(startTime, endTime, limit)).sync();
	}
}