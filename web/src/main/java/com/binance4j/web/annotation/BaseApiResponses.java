package com.binance4j.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.binance4j.web.exception.ApiExceptionResponse;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * An {@link ApiResponses} wrapper with all {@link ApiResponses}s.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses({
		@ApiResponse(code = 400, message = "", response = ApiExceptionResponse.class),
		@ApiResponse(code = 401, message = "", response = ApiExceptionResponse.class),
		@ApiResponse(code = 403, message = "", response = ApiExceptionResponse.class),
		@ApiResponse(code = 404, message = "", response = ApiExceptionResponse.class)
})
public @interface BaseApiResponses {
}
