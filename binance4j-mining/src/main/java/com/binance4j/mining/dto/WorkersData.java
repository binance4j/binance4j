package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Workers data.
 * 
 * @param workerDatas Workers datas.
 * @param totalNum    Total amount.
 * @param pageSize    Rows per page.
 */
@ApiModel("")
public record WorkersData(@ApiModelProperty("") List<Worker> workerDatas, @ApiModelProperty("") long totalNum, @ApiModelProperty("") long pageSize) {
}