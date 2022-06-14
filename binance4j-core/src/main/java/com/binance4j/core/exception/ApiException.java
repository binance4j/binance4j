package com.binance4j.core.exception;

import lombok.Getter;

/**
 * An exception which can occur while invoking methods of the Binance API.
 */
public class ApiException extends Exception {

  /**
   * The error code
   */
  @Getter
  private final int code;

  /**
   * The error code explanation
   */
  @Getter
  private final ApiErrorCode errorCode;

  /**
   * Constructor
   * 
   * @param code    The API response code
   * @param message The API response message
   */
  public ApiException(int code, String message) {
    super(message);
    this.code = code;
    this.errorCode = ApiErrorCode.valueOf(code);
  }

  /**
   * Constructor
   * 
   * @param code    The API response code
   * @param message The API response message
   */
  public ApiException(ApiErrorCode code, String message) {
    super(message);
    this.code = code.getValue();
    this.errorCode = code;
  }

  /**
   * Constructor
   * 
   * @param error The API response error
   */
  public ApiException(ApiError error) {
    this(error.getCode(), error.getMsg());
  }
}