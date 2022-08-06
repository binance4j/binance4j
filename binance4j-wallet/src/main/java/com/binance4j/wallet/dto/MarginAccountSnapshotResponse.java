package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** The response of a MARGIN account snapshot request */
@ApiModel("")
public record MarginAccountSnapshotResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg,
		@ApiModelProperty("") List<MarginAccountSnapshot> snapshotVos) implements AccountSnapshotResponse<MarginAccountSnapshot> {
}