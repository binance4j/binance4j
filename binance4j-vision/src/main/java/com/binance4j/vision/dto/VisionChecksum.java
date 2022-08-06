package com.binance4j.vision.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The representation of a checksum.
 * 
 * @param checksum MD5 checksum.
 * @param fileName File name.
 */
@ApiModel("The representation of a checksum.")
public record VisionChecksum(@ApiModelProperty("MD5 checksum.") String checksum, @ApiModelProperty("File name.") String fileName) {
}
