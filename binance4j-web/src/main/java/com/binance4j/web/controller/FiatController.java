package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.fiat.dto.PaymentHistory;
import com.binance4j.fiat.dto.PaymentType;
import com.binance4j.fiat.dto.TransactionHistory;
import com.binance4j.fiat.dto.TransactionType;
import com.binance4j.fiat.param.PaymentParams;
import com.binance4j.fiat.param.TransactionParams;
import com.binance4j.web.annotation.MyGetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Fiat endpoints. */
@RestController
@RequestMapping("api/v1/fiat")
@Api(value = "Fiat", tags = "Fiat", produces = "application/json", description = "Fiat endpoints")
public class FiatController extends BaseController {

	/**
	 * @param transactionType Transaction type.
	 * @param startTime       Start time in ms.
	 * @param endTime         End time in ms.
	 * @param page            Results page.
	 * @param limit           Results limit.
	 * @return Fiat payments.
	 * @throws ApiException Something went wrong with the API.
	 */
	@MyGetMapping(path = "payments")
	@ApiOperation(value = "Get payments.")
	public PaymentHistory getPayments(
			@RequestParam(required = true) @ApiParam(example = "BUY", value = "Payment type.") PaymentType transactionType,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.fiat()
				.getPayments(new PaymentParams(transactionType), new FramedPaging(startTime, endTime, page, limit))
				.sync();
	}

	/**
	 * @param transactionType Transaction type.
	 * @param startTime       Start time in ms.
	 * @param endTime         End time in ms.
	 * @param page            Results page.
	 * @param limit           Results limit.
	 * @return Fiat transactions.
	 * @throws ApiException Something went wrong with the API.
	 */
	@MyGetMapping(path = "transactions")
	@ApiOperation(value = "Get transactions.")
	public TransactionHistory getTransactions(
			@RequestParam(required = true) @ApiParam(example = "BUY", value = "Payment type.") TransactionType transactionType,
			@RequestParam(required = false) @ApiParam(value = "Start time in ms.") Long startTime,
			@RequestParam(required = false) @ApiParam(value = "End time in ms.") Long endTime,
			@RequestParam(required = false) @ApiParam(example = "1", value = "The result page") Integer page,
			@RequestParam(required = false) @ApiParam(example = "25", value = "The result limit.") Integer limit)
			throws ApiException {
		return connectors.fiat().getTransactions(new TransactionParams(transactionType)).sync();
	}
}