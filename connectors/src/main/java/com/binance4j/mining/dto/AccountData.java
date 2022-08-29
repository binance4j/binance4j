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
@JsonProperty("type") var type: String = "",
@ApiModelProperty("Mining account.")
@JsonProperty("userName") var userName: String = "",
@ApiModelProperty("List.") List<AccountList> list)
{
}
