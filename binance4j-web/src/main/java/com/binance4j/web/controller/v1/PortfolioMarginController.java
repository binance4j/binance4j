package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.connectors.Connectors;
import com.binance4j.core.exception.ApiException;
import com.binance4j.portfoliomargin.dto.AccountInfo;
import com.binance4j.portfoliomargin.dto.CollaterateRateInfo;
import com.binance4j.web.annotation.JsonGetMapping;
import com.binance4j.web.configuration.Binance4jConfiguration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/** Controller for Portfolio margin endpoints. */
@RestController
@RequestMapping(Binance4jConfiguration.CONNECTORS_BASE_URI + "portfolio-margin")
@Api(value = "Portfolio margin", tags = "Portfolio margin", produces = "application/json", description = "Portfolio margin endpoints")
public class PortfolioMarginController extends BaseController {
	/**
	 * Creates instance.
	 * 
	 * @param connectors Binance4j connectors.
	 */
	public PortfolioMarginController(Connectors connectors) {
		super(connectors);
	}

	/**
	 * @return Margin Account Details.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "account")
	@ApiOperation(value = "Get Margin Account Details.")
	public AccountInfo getAccount() throws ApiException {
		return connectors.rest().portfolioMargin().getAccountInfo().sync();
	}

	/**
	 * @return Collateral rate.
	 * @throws ApiException Something went wrong.
	 */
	@JsonGetMapping(path = "collaterate-rate")
	@ApiOperation(value = "Get collateral rate.")
	public List<CollaterateRateInfo> getCollateralRate() throws ApiException {
		return connectors.rest().portfolioMargin().getCollateralRate().sync();
	}
}