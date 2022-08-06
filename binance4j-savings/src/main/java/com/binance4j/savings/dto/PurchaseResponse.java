package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible purchase response.
 * 
 * @param purchaseId Purchase id.
 */
@ApiModel("Flexible purchase response.")
public record PurchaseResponse(@ApiModelProperty("Purchase id.") String purchaseId) {
}