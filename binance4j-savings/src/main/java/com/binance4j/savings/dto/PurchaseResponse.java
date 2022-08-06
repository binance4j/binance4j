package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible purchase response.
 * 
 * @param purchaseId Purchase id.
 */
@ApiModel("")
public record PurchaseResponse(@ApiModelProperty("") String purchaseId) {
}