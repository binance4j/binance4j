package com.binance4j.vision.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The representation of a checksum.
 * 
 * @param checksum The MD5 checksum.
 * @param fileName The file name.
 */
@ApiModel("")
public record VisionChecksum(@ApiModelProperty("") String checksum, @ApiModelProperty("") String fileName) {
}
