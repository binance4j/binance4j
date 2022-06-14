package com.binance4j.spot.account;

import com.binance4j.core.request.FramedRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get the current account information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountRequest extends FramedRequest {
	public AccountRequest() {
		super(10);
	}
}
