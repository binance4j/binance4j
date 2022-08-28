package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account data.
 * 
 * @param type     Type of daily hashrate.
 * @param userName Mining account.
 * @param list     List.
 */
@ApiModel("Account data.")
public record AccountData(@ApiModelProperty("Type of daily hashrate.") String type,
		@ApiModelProperty("Mining account.") String userName,
		@ApiModelProperty("List.") List<AccountList> list) {
}
