package com.binance4j.vision.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A file checksum.
 * 
 * @property checksum MD5 checksum.
 * @property fileName File name.
 */
@ApiModel("A file checksum.")
data class VisionChecksum(@ApiModelProperty("MD5 checksum.") String checksum,
		@ApiModelProperty("File name.") var fileName : String? = null) {
}
