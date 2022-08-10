package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Enabled Isolated account limit.
 * 
 * @param enabledAccount Enabled account.
 * @param maxAccount     Account limit.
 */
@ApiModel("Enabled Isolated account limit.")
public record IsolatedAccountLimit(@ApiModelProperty("Enabled account.") int enabledAccount,
		@ApiModelProperty("Account limit.") int maxAccount) {
}