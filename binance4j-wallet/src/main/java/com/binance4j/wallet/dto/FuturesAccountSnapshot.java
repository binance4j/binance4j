package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A daily FUTURES account snapshot.
 * 
 * @param type       Type.
 * @param updateTime Update time in ms.
 * @param data       Data.
 */
@ApiModel("A daily FUTURES account snapshot.")
public record FuturesAccountSnapshot(@ApiModelProperty("Type.") String type,
		@ApiModelProperty("Update time in ms.") long updateTime,
		@ApiModelProperty("Data.") FuturesSnapshotData data) implements Snapshot {
}