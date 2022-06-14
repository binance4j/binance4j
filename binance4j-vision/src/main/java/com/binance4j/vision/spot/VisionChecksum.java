package com.binance4j.vision.spot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The representation of a checksum
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisionChecksum {
	/**
	 * The MD5 checksum
	 */
	private String checksum;

	/**
	 * The file name
	 */
	private String fileName;
}
