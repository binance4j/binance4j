package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;// TODO transfer to sub account module when created

/**
 * Sub account transfer
 * 
 * @param counterParty    Counter party name.
 * @param email           Counter party email.
 * @param type            Transfer in or transfer out.
 * @param asset           Transfer asset.
 * @param quantity        Quantity of transfer asset.
 * @param fromAccountType Type of from account.
 * @param toAccountType   Type of to account.
 * @param status          Transfer status.
 * @param tranId          Transfer ID.
 * @param time            Transfer time.
 */
public record SubAccountTransfer(String counterParty, String email, int type, String asset, @JsonProperty("qty") String quantity, String fromAccountType,
		String toAccountType, String status, long tranId, long time) {
}