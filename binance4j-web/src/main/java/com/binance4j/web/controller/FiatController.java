package com.binance4j.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.PaymentHistory;
import com.binance4j.fiat.dto.PaymentType;
import com.binance4j.fiat.dto.TransactionHistory;
import com.binance4j.fiat.dto.TransactionType;
import com.binance4j.fiat.param.PaymentParams;
import com.binance4j.fiat.param.TransactionParams;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("api/v1/convert")
@Api(value = "Fiat Controller", tags = "Fiat Controller", produces = "application/json", description = "Fiat endpoints")
public class FiatController {

	FiatClient client;

	public FiatController(Connectors connectors) {
		this.client = connectors.fiat();
	}

	@GetMapping(path = "payments", produces = "application/json")
	@ApiOperation(value = "Get payments.")
	public PaymentHistory getPayments(@RequestParam(required = false) @ApiParam(example = "BUY", value = "Payment type.") PaymentType transactionType)
			throws ApiException {
		return client.getPayments(new PaymentParams(transactionType)).sync();
	}

	@GetMapping(path = "transactions", produces = "application/json")
	@ApiOperation(value = "Get transactions.")
	public TransactionHistory getTransactions(
			@RequestParam(required = false) @ApiParam(example = "BUY", value = "Payment type.") TransactionType transactionType) throws ApiException {
		System.out.println(transactionType);
		return client.getTransactions(new TransactionParams(transactionType)).sync();
	}
}