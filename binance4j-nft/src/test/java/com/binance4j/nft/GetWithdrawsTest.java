package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.withdraw.NFTWithdrawHistory;
import com.binance4j.nft.withdraw.NFTWithdrawRequest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Tests the Deposit history request */
public class GetWithdrawsTest {
    NFTClient client = TestService.getClient();
    int limit = 25;
    int page = 1;

    @Test
    @DisplayName("It should return a non null result")
    void testRequest() throws ApiException {
        NFTWithdrawRequest req = new NFTWithdrawRequest();
        test(req);
    }

    @Test
    @DisplayName("It should return a non null result")
    void testLimitAndPage() throws ApiException {
        NFTWithdrawRequest req = new NFTWithdrawRequest(limit, page);
        testLimit(req);
    }

    /**
     * Tests that the result fields ar not null
     * 
     * @param req The request
     * @throws ApiException The Exception sent by the server
     */
    NFTWithdrawHistory test(NFTWithdrawRequest req) throws ApiException {
        NFTWithdrawHistory history = client.getWithdraws(req).execute();
        System.out.println("--- Result ---");
        System.out.println(history);

        assertNotNull(history.getTotal());

        history.getList().forEach(withdraw -> {
            assertNotNull(withdraw.getContractAddress());
            assertNotNull(withdraw.getNetwork());
            assertNotNull(withdraw.getTimestamp());
            assertNotNull(withdraw.getTokenId());
            assertNotNull(withdraw.getTransactionId());
            assertNotNull(withdraw.getFee());
            assertNotNull(withdraw.getFeeAsset());
        });
        return history;
    }

    /**
     * Tests that the result fields ar not null and that the total is inferior or
     * equal to the request limit
     * 
     * @param req The request
     * @throws ApiException The Exception sent by the server
     */
    void testLimit(NFTWithdrawRequest req) throws ApiException {
        NFTWithdrawHistory history = test(req);
        assertTrue(history.getTotal() <= limit);
    }
}
