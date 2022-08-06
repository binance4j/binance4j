package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A daily MARGIN account snapshot.
 * 
 * @param type       Type.
 * @param updateTime Update time in ms.
 * @param data       Data.
 */
@ApiModel("A daily MARGIN account snapshot.")
public record MarginAccountSnapshot(@ApiModelProperty("Type.") String type, @ApiModelProperty("Update time in ms.") long updateTime,
		@ApiModelProperty("Data.") MarginAccountSnapshotData data) implements Snapshot {
}