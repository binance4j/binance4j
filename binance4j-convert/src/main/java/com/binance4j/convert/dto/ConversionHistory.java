package com.binance4j.convert.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Conversions history.
 * 
 * @param list      The conversions.
 * @param startTime Start time in ms.
 * @param endTime   End time in ms.
 * @param limit     Results limit.
 * @param moreData  Is there more data?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ConversionHistory(
		/** The conversions. */
		List<Conversion> list,
		/** Start time in ms. */
		long startTime,
		/** End time in ms. */
		long endTime,
		/** Results limit. */
		int limit,
		/** Is there more data? */
		boolean moreData) {
}