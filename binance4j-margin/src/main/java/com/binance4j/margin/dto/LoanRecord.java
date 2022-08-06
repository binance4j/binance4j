package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A loan record.
 * 
 * @param total Total records.
 * @param rows  Records.
 */
@ApiModel("A loan record.")
public record LoanRecord(@ApiModelProperty("Total records.") int total, @ApiModelProperty("Records.") List<Loan> rows) {
}