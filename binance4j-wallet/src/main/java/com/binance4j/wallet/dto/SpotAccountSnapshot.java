package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** A daily SPOT account snapshot */
@ApiModel("")
public record SpotAccountSnapshot(@ApiModelProperty("") String type, @ApiModelProperty("") long updateTime, @ApiModelProperty("") SpotAccountSnapshotData data)
		implements Snapshot {
}