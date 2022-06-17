package com.binance4j.margin.oco;

import java.math.BigDecimal;

import com.binance4j.core.order.OCOResponse;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class MarginOCOResponse extends OCOResponse {
    /** will not return if no margin trade happens */
    private BigDecimal marginBuyBorrowAmount;
    /** will not return if no margin trade happens */
    private BigDecimal marginBuyBorrowAsset;
    private Boolean isIsolated;
}