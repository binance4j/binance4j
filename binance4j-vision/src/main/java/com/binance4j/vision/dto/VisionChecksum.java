package com.binance4j.vision.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A file checksum.
 * 
 * @param checksum MD5 checksum.
 * @param fileName File name.
 */
@ApiModel("A file checksum.")
public record VisionChecksum(@ApiModelProperty("MD5 checksum.") String checksum, @ApiModelProperty("File name.") String fileName) {
}
