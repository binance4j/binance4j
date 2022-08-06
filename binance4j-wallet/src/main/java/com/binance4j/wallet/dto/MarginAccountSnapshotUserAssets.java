package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Margin account snapshot user assets.
 * 
 * @param asset    The asset abbreviation
 * @param borrowed The borrowed amount
 * @param free     The fee amount
 * @param interest The interest amount
 * @param locked   The locked volume
 * @param netAsset Net asset
 */
@ApiModel("")
public record MarginAccountSnapshotUserAssets(@ApiModelProperty("")
/** The asset abbreviation **/
String asset, @ApiModelProperty("")
/** The borrowed amount **/
String borrowed, @ApiModelProperty("")
/** The fee amount **/
String free, @ApiModelProperty("")
/** The interest amount **/
String interest, @ApiModelProperty("")
/** The locked volume **/
String locked, @ApiModelProperty("")
/** Net asset **/
String netAsset) {
}