package com.binance4j.wallet.permissions;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get The api key permissions */
@Data
@EqualsAndHashCode(callSuper = true)
public class ApiPermissionsRequest extends FramedRequest {
    public ApiPermissionsRequest() {
        super(1);
    }
}
