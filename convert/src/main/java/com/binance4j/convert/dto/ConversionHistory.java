package com.binance4j.convert.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Conversions history.
 * 
 * @param list      Conversions.
 * @param startTime Start time in ms.
 * @param endTime   End time in ms.
 * @param limit     Results limit.
 * @param moreData  Is there more data?
 */
@ApiModel("Conversions history.")
public record ConversionHistory(@ApiModelProperty("The conversions.") List<Conversion> list,
		@ApiModelProperty("Start time in ms.") long startTime,
		@ApiModelProperty("End time in ms.") long endTime, @ApiModelProperty("Results limit.") int limit,
		@ApiModelProperty("Is there more data?") boolean moreData) {
}