package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account data
 * 
 * @param type     Type of daily hashrate.
 * @param userName Mining account.
 * @param list     List.
 */
@ApiModel("")
public record AccountData(@ApiModelProperty("") String type, @ApiModelProperty("") String userName, @ApiModelProperty("") List<AccountList> list) {
}
