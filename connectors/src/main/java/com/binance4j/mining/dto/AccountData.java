package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account data.
 * 
 * @property type     Type of daily hashrate.
 * @property userName Mining account.
 * @property list     List.
 */
@ApiModel("Account data.")
data class AccountData(
@ApiModelProperty("Type of daily hashrate.")
 val type : String,
@ApiModelProperty("Mining account.")
 val userName : String,
@ApiModelProperty("List.") List<AccountList> list)
{
}
