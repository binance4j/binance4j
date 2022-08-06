package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** The response of a FUTURES account snapshot request */
@ApiModel("")
public record FuturesAccountSnapshotResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg,
		@ApiModelProperty("") List<FuturesAccountSnapshot> snapshotVos) implements AccountSnapshotResponse<FuturesAccountSnapshot> {
}