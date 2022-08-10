package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link MiningClient#getAccounts} response.
 * 
 * @param code Response code.
 * @param msg  Response message.
 * @param data Response data.
 */
@ApiModel("Accounts list wrapper")
public record AccountListResponse(@ApiModelProperty("Response code.") int code,
		@ApiModelProperty("Response message.") String msg,
		@ApiModelProperty("Response data.") List<AccountData> data) {
}