package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Enabled Isolated account limit.
 * 
 * @property enabledAccount Enabled account.
 * @property maxAccount     Account limit.
 */
@ApiModel("Enabled Isolated account limit.")
data class IsolatedAccountLimit(
@ApiModelProperty("Enabled account.")
@JsonProperty("enabledAccount") var enabledAccount:Int = 0,
@ApiModelProperty("Account limit.") @JsonProperty("maxAccount") var maxAccount:Int = 0)
{
}