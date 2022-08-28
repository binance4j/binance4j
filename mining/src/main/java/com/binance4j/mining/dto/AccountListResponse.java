package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [MiningClient.getAccounts] response.
 * 
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Accounts list wrapper")
data class AccountListResponse(
@ApiModelProperty("Response code.")
var code:int?=null,
@ApiModelProperty("Response message.")
var msg:String?=null,
@ApiModelProperty("Response data.") List<AccountData> data)
{
}