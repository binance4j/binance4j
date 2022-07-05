package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.binance4j.core.market.AggTrade;

public class BaseTestServiceTest {

    @Test
    void testGetProperties() throws IntrospectionException {
        AggTrade trade = getAggTrade();
        Map<String, Object> map = BaseTestService.getBeanProperties(trade);

        assertEquals(map.get("firstTradeId"), trade.getFirstTradeId());
        assertEquals(map.get("lastTradeId"), trade.getLastTradeId());
        assertEquals(map.get("price"), trade.getPrice());
        assertEquals(map.get("quantity"), trade.getQuantity());
        assertEquals(map.get("time"), trade.getTime());
        assertEquals(map.get("tradeId"), trade.getTradeId());
    }

    @Test
    void testGetNullProperties() throws IntrospectionException {
        AggTrade trade = getAggTrade();

        trade.setFirstTradeId(null);
        trade.setPrice(null);

        List<String> list = BaseTestService.getNullProperties(trade);

        assertEquals(2, list.size());
        assertTrue(list.contains("firstTradeId"));
        assertTrue(list.contains("price"));
    }

    @Test
    void testHasNoNullProperty() throws IntrospectionException {
        AggTrade trade = getAggTrade();
        assertTrue(BaseTestService.hasNoNullProperty(trade));
    }

    @Test
    void testHasNullProperty() throws IntrospectionException {
        AggTrade trade = getAggTrade();
        trade.setFirstTradeId(null);
        assertFalse(BaseTestService.hasNoNullProperty(trade));
    }

    AggTrade getAggTrade() {
        AggTrade trade = new AggTrade();
        trade.setFirstTradeId(1L);
        trade.setLastTradeId(2L);
        trade.setPrice(new BigDecimal(1));
        trade.setQuantity(new BigDecimal(1));
        trade.setTime(100L);
        trade.setTradeId(123L);

        return trade;
    }
}
