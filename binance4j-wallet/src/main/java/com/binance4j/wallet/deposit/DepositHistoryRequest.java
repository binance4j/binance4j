package com.binance4j.wallet.deposit;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get a coin deposit history
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DepositHistoryRequest extends IntervalRequest {
    /**
     * The deposited coin
     */
    private String coin;
    /**
     * The deposit status. 0(0:pending,6: credited but cannot withdraw,
     * 1:success)
     * 
     * 
     */
    private Integer status;

    /**
     * The history offset
     */
    private Integer offset;
    /**
     * The history size. Default:1000, Max:1000
     */
    private Integer limit = 1000;

    /** Default constructor */
    public DepositHistoryRequest() {
        super(1);
    }

    /**
     * Constructor
     * 
     * @param coin The coin we need deposit history
     */
    public DepositHistoryRequest(String coin) {
        this();
        this.coin = coin;
    }

    /**
     * Constructor
     * 
     * @param status The coin status (0:pending,6: credited but cannot withdraw,
     *               1:success)
     */
    public DepositHistoryRequest(int status) {
        this();
        this.status = status;
    }

    /**
     * Constructor
     * 
     * @param status The coin status
     */
    public DepositHistoryRequest(DepositStatus status) {
        this();
        this.status = status.getValue();
    }

    /**
     * Constructor
     * 
     * @param coin   The coin we need deposit history
     * @param status The coin status 0(0:pending,6: credited but cannot withdraw,
     *               1:success)
     */
    public DepositHistoryRequest(String coin, int status) {
        this(coin);
        this.status = status;
    }

    /**
     * Constructor
     * 
     * @param coin   The coin we need deposit history
     * @param status The coin status 0(0:pending,6: credited but cannot withdraw,
     *               1:success)
     */
    public DepositHistoryRequest(String coin, DepositStatus status) {
        this(coin, status.getValue());
    }
}