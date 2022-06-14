package com.binance4j.spot.order;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to display the user's current order count usage for all intervals.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderCountRequest extends FramedRequest {
    /** Default constructor */
    public OrderCountRequest() {
        super(20);
    }
}
