package com.binance4j.convert.dto;

import java.util.List;

/**
 * Conversions history.
 * 
 * @param list      The conversions.
 * @param startTime Start time in ms.
 * @param endTime   End time in ms.
 * @param limit     Results limit.
 * @param moreData  Is there more data?
 */
public record ConversionHistory(List<Conversion> list, long startTime, long endTime, int limit, boolean moreData) {
}