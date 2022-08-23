package com.binance4j.web.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.PaymentHistory;
import com.binance4j.fiat.dto.PaymentType;
import com.binance4j.fiat.dto.TransactionHistory;
import com.binance4j.fiat.dto.TransactionType;
import com.binance4j.fiat.param.PaymentParams;
import com.binance4j.fiat.param.TransactionParams;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.configuration.Binance4jConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Fiat endpoints. */
@RestController
@RequestMapping(Binance4jConfiguration.CONNECTORS_BASE_URI + "fiat")
@Api(value = "Fiat", tags = "Fiat", produces = "application/json", description = "Fiat endpoints")
public class FiatController extends BaseController {
	/**
	 * Creates instance.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	public FiatController(Connectors connectors) {
		super(connectors);
	}

	/**
	 * @return FIat client.
	 */
	private FiatClient client() {
		return connectors.rest().fiat();
	}

	/**
	 * @param transactionType Transaction type.
	 * @param startTime       Start time in ms.
	 * @param endTime         End time in ms.
	 * @param page            Results page.
	 * @param limit           Results limit.
	 * @return Fiat payments.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "payments")
	@ApiOperation(value = "Get payments.")
	public PaymentHistory getPayments(
			@RequestParam @ApiParam("Payment type.") PaymentType transactionType,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client()
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
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "transactions")
	@ApiOperation(value = "Get transactions.")
	public TransactionHistory getTransactions(
			@RequestParam @ApiParam("Payment type.") TransactionType transactionType,
			@RequestParam(required = false) @ApiParam(START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false) @ApiParam(END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false) @ApiParam(PAGE_DESCRIPTION) Integer page,
			@RequestParam(required = false) @ApiParam(LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return client().getTransactions(new TransactionParams(transactionType)).sync();
	}
}