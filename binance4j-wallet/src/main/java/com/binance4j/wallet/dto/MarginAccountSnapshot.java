package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** A daily MARGIN account snapshot */
@ApiModel("")
public record MarginAccountSnapshot(@ApiModelProperty("") String type, @ApiModelProperty("") long updateTime,
		@ApiModelProperty("") MarginAccountSnapshotData data) implements Snapshot {
}