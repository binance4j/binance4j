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
@ApiModel("Workers data.")
public record WorkersData(@ApiModelProperty("Workers datas.") List<Worker> workerDatas,
		@ApiModelProperty("Total amount.") long totalNum,
		@ApiModelProperty("Rows per page.") long pageSize) {
}