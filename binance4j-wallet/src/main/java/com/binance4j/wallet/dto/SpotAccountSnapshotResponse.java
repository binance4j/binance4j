package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** The response of a SPOT account snapshot request */
@ApiModel("")
public record SpotAccountSnapshotResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg,
		@ApiModelProperty("") List<SpotAccountSnapshot> snapshotVos) implements AccountSnapshotResponse<SpotAccountSnapshot> {
}