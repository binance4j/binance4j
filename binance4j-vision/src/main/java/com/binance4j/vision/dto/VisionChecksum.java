package com.binance4j.vision.dto;

/**
 * The representation of a checksum.
 * 
 * @param checksum The MD5 checksum.
 * @param fileName The file name.
 */
public record VisionChecksum(String checksum, String fileName) {
}
