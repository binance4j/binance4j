package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** A daily FUTURES account snapshot */
@ApiModel("")
public record FuturesAccountSnapshot(@ApiModelProperty("") String type, @ApiModelProperty("") long updateTime, @ApiModelProperty("") FuturesSnapshotData data)
		implements Snapshot {
}