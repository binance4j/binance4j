package com.binance4j.rebate.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Rebate data.
 * 
 * @property page         Current page.
 * @property totalRecords Total records.
 * @property totalPageNum Total pages.
 * @property data         Rebates.
 */
@ApiModel("Rebate data.")
data class RebateData(
@ApiModelProperty("Current page.")
var page:int?=null,
@ApiModelProperty("Total records.")
var totalRecords:int?=null,
@ApiModelProperty("Total pages.")
var totalPageNum:int?=null,
@ApiModelProperty("Rebates.") List<Rebate> data)
{
}
