package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response of a SPOT account snapshot request.
 * 
 * @param code        Code.
 * @param msg         Message.
 * @param snapshotVos Snapshot.
 */
@ApiModel("Response of a SPOT account snapshot request.")
public record SpotAccountSnapshotResponse(@ApiModelProperty("Code.") int code, @ApiModelProperty("Message.") String msg,
		@ApiModelProperty("Snapshot.") List<SpotAccountSnapshot> snapshotVos)
		implements AccountSnapshotResponse<SpotAccountSnapshot> {
}