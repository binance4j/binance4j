package com.binance4j.wallet.transfer;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** Request to fetch User Universal Transfer History */
@Data
@EqualsAndHashCode(callSuper = true)
public class WalletTransferHistoryRequest extends IntervalRequest {
    /**
     * The User universal transfer type
     */
    private WalletTransferType type;
    /**
     * ???
     */
    private Integer current = 1;
    /**
     * The result size
     */
    private Integer size = 10;
    /**
     * Must be sent when type are ISOLATEDMARGIN_MARGIN and
     * ISOLATEDMARGIN_ISOLATEDMARGIN
     * 
     * 
     */
    private String fromSymbol;
    /**
     * Must be sent when type are MARGIN_ISOLATEDMARGIN and
     * ISOLATEDMARGIN_ISOLATEDMARGIN
     * 
     * 
     */
    private String toSymbol;

    /**
     * Constructor
     * 
     * @param type The transfer type
     */
    public WalletTransferHistoryRequest(WalletTransferType type) {
        super(1);
        this.type = type;
    }
}
