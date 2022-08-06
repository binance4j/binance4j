package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The API key permissions.
 * 
 * @param ipRestrict                     is the key restricted to an ip address?
 * @param enableWithdrawals              This option allows you to withdraw via API. You must apply the IP Access
 *                                           Restriction filter in order to enable withdrawals
 * @param enableInternalTransfer         This option authorizes this key to transfer funds between your master account
 *                                           and your sub account instantly.
 * @param permitsUniversalTransfer       Authorizes this key to be used for a dedicated universal transfer API to
 *                                           transfer multiple supported currencies. Each business's own transfer API
 *                                           rights are not affected by this authorization.
 * @param enableVanillaOptions           Authorizes this key to Vanilla options trading.
 * @param enableReading                  Does the key enables reading ?
 * @param enableFutures                  API Key created before your futures account opened does not support futures API
 *                                           service
 * @param enableMargin                   This option can be adjusted after the Cross Margin account transfer is
 *                                           completed
 * @param enableSpotAndMarginTrading     Spot and margin trading.
 * @param createTime                     The API key creation timestamp.
 * @param tradingAuthorityExpirationTime Expiration time for spot and margin trading permission.
 */
@ApiModel("")
public record ApiPermissions(@ApiModelProperty("") boolean ipRestrict, @ApiModelProperty("")
/**
 * This option allows you to withdraw via API. You must apply the IP Access Restriction filter in order to enable
 * withdrawals.
 */
boolean enableWithdrawals, @ApiModelProperty("") boolean enableInternalTransfer, @ApiModelProperty("")
/**
 * Authorizes this key to be used for a dedicated universal transfer API to transfer multiple supported currencies. Each
 * business's own transfer API rights are not affected by this authorization.
 */
boolean permitsUniversalTransfer, @ApiModelProperty("") boolean enableVanillaOptions, @ApiModelProperty("") boolean enableReading,
		@ApiModelProperty("") boolean enableFutures, @ApiModelProperty("") boolean enableMargin, @ApiModelProperty("") boolean enableSpotAndMarginTrading,
		@ApiModelProperty("") long createTime, @ApiModelProperty("") long tradingAuthorityExpirationTime) {
}