package com.binance4j.web.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ApiException wrapper sent to client when captured by
 * {@link ApiExceptionHandler}
 * 
 * @param code    The exception code.
 * @param message The exception message.
 */
@ApiModel("ApiException")
public record ApiExceptionResponse(@ApiModelProperty("The exception code.") int code,
		@ApiModelProperty("The exception message.") String message) {
}