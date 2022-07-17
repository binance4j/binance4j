package com.binance4j.vision.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The representation of a checksum */
@Data
@AllArgsConstructor
@NoArgsConstructor
public record VisionChecksum(
		/** The MD5 checksum. */
		String checksum,

		/** The file name. */
		String fileName) {
}
