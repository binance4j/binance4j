package com.binance4j.margin;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.loan.LoanRecordRequest;

public class GetLoanRecordTest extends MarginTest {

    // TODO borrow
    // @Test
    void test1() throws ApiException {
        test(client.getLoanRecord(new LoanRecordRequest(asset)));
    }
}
