package com.binance4j.wallet.systemstatus;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The request to obtain the system status */
@Data
@EqualsAndHashCode(callSuper = true)
public class SystemStatusRequest extends FramedRequest {
    public SystemStatusRequest() {
        super(1);
    }
}
