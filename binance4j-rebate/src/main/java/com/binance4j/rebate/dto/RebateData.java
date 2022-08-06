package com.binance4j.rebate.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Rebate data
 * 
 * @param page         The current page.
 * @param totalRecords The total records.
 * @param totalPageNum The total pages.
 * @param data         The rebates.
 */
@ApiModel("")
public record RebateData(@ApiModelProperty("") int page, @ApiModelProperty("") int totalRecords, @ApiModelProperty("") int totalPageNum,
		@ApiModelProperty("") List<Rebate> data) {
}
