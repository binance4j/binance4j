package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response of a FUTURES account snapshot request.
 * 
 * @param code        Code.
 * @param msg         Message.
 * @param snapshotVos Snapshot.
 */
@ApiModel("Response of a FUTURES account snapshot request.")
public record FuturesAccountSnapshotResponse(@ApiModelProperty("Code.") int code,
		@ApiModelProperty("Message.") String msg,
		@ApiModelProperty("Snapshot.") List<FuturesAccountSnapshot> snapshotVos)
		implements AccountSnapshotResponse<FuturesAccountSnapshot> {
}