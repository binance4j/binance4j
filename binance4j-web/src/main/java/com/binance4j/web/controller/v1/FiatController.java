package com.binance4j.web.controller.v1;

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
import com.binance4j.web.annotation.JsonGetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	@JsonGetMapping(path = "payments")
	@ApiOperation(value = "Get payments.")
	public PaymentHistory getPayments(
			@RequestParam(name = "Payment type.") PaymentType transactionType,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().fiat()
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
	@JsonGetMapping(path = "transactions")
	@ApiOperation(value = "Get transactions.")
	public TransactionHistory getTransactions(
			@RequestParam(name = "Payment type.") TransactionType transactionType,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().fiat().getTransactions(new TransactionParams(transactionType)).sync();
	}
}