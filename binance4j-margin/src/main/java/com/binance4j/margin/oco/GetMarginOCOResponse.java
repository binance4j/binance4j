package com.binance4j.margin.oco;

import java.util.List;

import com.binance4j.core.order.ContingencyType;
import com.binance4j.core.order.OCOOrderStatus;
import com.binance4j.core.order.OCOStatus;
import com.binance4j.core.order.OrderInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMarginOCOResponse {
    private Long orderListId;
    private ContingencyType contingencyType;
    private OCOStatus listStatusType;
    private OCOOrderStatus listOrderStatus;
    private String listClientOrderId;
    private Long transactionTime;
    private String symbol;
    private Boolean isIsoslated;
    private List<OrderInfo> orders;
}
