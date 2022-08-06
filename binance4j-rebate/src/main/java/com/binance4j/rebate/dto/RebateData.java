package com.binance4j.rebate.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Rebate data.
 * 
 * @param page         Current page.
 * @param totalRecords Total records.
 * @param totalPageNum Total pages.
 * @param data         Rebates.
 */
@ApiModel("Rebate data.")
public record RebateData(@ApiModelProperty("Current page.") int page, @ApiModelProperty("Total records.") int totalRecords,
		@ApiModelProperty("Total pages.") int totalPageNum, @ApiModelProperty("Rebates.") List<Rebate> data) {
}
