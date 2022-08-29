/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.savings.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.savings.dto.FixedProjectType;
import com.binance4j.savings.dto.LendingType;
import com.binance4j.savings.dto.ProductType;
import com.binance4j.savings.param.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SavingsClientTest extends CustomTest {
    SavingsClient client = new SavingsClient(key, secret);

    public SavingsClientTest() {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testGetAccount() throws ApiException {
        testNotThrow(client.getAccount());
    }

    @Test
    void testGetFixedProjects() throws ApiException {
        testNotThrow(client.getFixedProjects(new FixedProjectListParams(FixedProjectType.CUSTOMIZED_FIXED)));
        testNotThrow(client.getFixedProjects(new FixedProjectListParams(FixedProjectType.ACTIVITY)));
    }

    @Test
    void testGetFlexibleProducts() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        testHasNulls(client.getFlexibleProducts(), List.of("tierAnnualInterestRate"), true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testGetInterests() throws ApiException {
        testNotThrow(client.getInterests(new LendingParams(LendingType.DAILY)));
        testNotThrow(client.getInterests(new LendingParams(LendingType.ACTIVITY)));
        testNotThrow(client.getInterests(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
    }

    @Test
    void testGetPurchases() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        testNotThrow(client.getPurchases(new LendingParams(LendingType.DAILY)));
        testNotThrow(client.getPurchases(new LendingParams(LendingType.ACTIVITY)));
        testNotThrow(client.getPurchases(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testGetRedemptions() throws ApiException {
        testNotThrow(client.getRedemptions(new LendingParams(LendingType.DAILY)));
        testNotThrow(client.getRedemptions(new LendingParams(LendingType.ACTIVITY)));
        testNotThrow(client.getRedemptions(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
    }

    @Test
    void testGetLeftDailyFlexiblePurchaseQuota() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        var productId = client.getFlexibleProducts().sync().get(0).productId();
        testNotThrow(client.getLeftDailyFlexiblePurchaseQuota(new PurchaseQuotaParams(productId)));
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testGetLeftDailyRedemptionQuota() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        var productId = client.getFlexibleProducts().sync().get(0).productId();
        testNotThrow(client.getLeftDailyRedemptionQuota(new RedemptionQuotaParams(productId, ProductType.FAST)));
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    // NOT TESTED

    // TODO @Test
    void testFixedToDailyPosition() throws ApiException {
        testNotThrow(client.fixedToDailyPosition(new ChangePositionParams("projectId", 0L)));
    }

    // TODO @Test
    void testGetFixedProjectPosition() throws ApiException {
        testNotThrow(client.getFixedProjectPosition(new FixedProjectPositionParams(null, null, null)));
    }

    // TODO @Test
    void testGetFlexibleProductPosition() throws ApiException {
        testNotThrow(client.getFlexibleProductPosition());
    }

    // TODO @Test
    void testPurchaseFixed() throws ApiException {
        testNotThrow(client.purchaseFixed(new FixedPurchaseParams("productId", 1L)));
    }

    // TODO @Test
    void testPurchaseFlexible() throws ApiException {
        testNotThrow(client.purchaseFlexible(new FlexiblePurchaseParams("productId", "amount")));
    }

    // TODO @Test
    void testRedeemFlexible() throws ApiException {
        testNotThrow(client.redeemFlexible(new RedemptionParams("productId", "amount", ProductType.FAST)));
    }
}