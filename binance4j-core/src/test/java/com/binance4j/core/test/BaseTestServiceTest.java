package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.binance4j.core.market.AggTrade;

public class BaseTestServiceTest {
    AggTrade trade;
    AggTrade trade2;

    @BeforeEach
    void beforeEach() {
        trade = new AggTrade();
        trade.setFirstTradeId(1L);
        trade.setLastTradeId(2L);
        trade.setPrice(new BigDecimal(1));
        trade.setQuantity(new BigDecimal(1));
        trade.setTime(100L);
        trade.setTradeId(123L);

        trade2 = new AggTrade();
        trade2.setFirstTradeId(1L);
        trade2.setLastTradeId(2L);
        trade2.setPrice(new BigDecimal(1));
        trade2.setQuantity(null);
        trade2.setTime(null);
        trade2.setTradeId(123L);
    }

    @Test
    void testGetProperties() throws IntrospectionException {
        Map<String, Object> map = BaseTestService.getProperties(trade);

        List<String> list = new ArrayList<String>();
        list.add("ok");
        list.add("lol");
        list.add("hihi");

        System.out.println(BaseTestService.getProperties(list));
        assertEquals(map.get("firstTradeId"), trade.getFirstTradeId());
        assertEquals(map.get("lastTradeId"), trade.getLastTradeId());
        assertEquals(map.get("price"), trade.getPrice());
        assertEquals(map.get("quantity"), trade.getQuantity());
        assertEquals(map.get("time"), trade.getTime());
        assertEquals(map.get("tradeId"), trade.getTradeId());
    }

    @Test
    void testGetNullProperties() throws IntrospectionException {
        trade.setFirstTradeId(null);
        trade.setPrice(null);

        Set<String> list = BaseTestService.getNullProperties(trade);
        System.out.println(list);
        assertEquals(2, list.size());
        assertTrue(list.contains("AggTrade.firstTradeId"));
        assertTrue(list.contains("AggTrade.price"));
    }

    @Test
    void testGetNullPropertiesOfList() throws IntrospectionException {
        trade.setFirstTradeId(null);
        trade.setPrice(null);

        List<AggTrade> listOfTrades = new ArrayList<>();
        listOfTrades.add(trade);
        listOfTrades.add(trade2);
        Set<String> list = BaseTestService.getNullProperties(listOfTrades);

        System.out.println(list);

        assertEquals(4, list.size());
        assertTrue(list.contains("AggTrade[0].firstTradeId"));
        assertTrue(list.contains("AggTrade[0].price"));
        assertTrue(list.contains("AggTrade[0].firstTradeId"));
        assertTrue(list.contains("AggTrade[0].price"));
    }

    @Test
    void testHasNoNullProperty() throws IntrospectionException {
        assertTrue(BaseTestService.hasNoNullProperty(trade));
    }

    @Test
    void testHasNullProperty() throws IntrospectionException {
        trade.setFirstTradeId(null);
        assertFalse(BaseTestService.hasNoNullProperty(trade));
    }

    @Test
    void testHasBeanProperties() {
        assertTrue(BaseTestService.hasProperties(trade));
    }

    @Test
    void testIsJava() {
        assertTrue(BaseTestService.isJavaBean("test"));
        assertTrue(BaseTestService.isJavaBean(new ArrayList<>()));
        assertTrue(BaseTestService.isJavaBean(new HashMap<>()));
        assertFalse(BaseTestService.isJavaBean(trade));
    }

    @Test
    void testIsMap() {
        assertTrue(BaseTestService.isMap(new HashMap<>()));
        assertFalse(BaseTestService.isMap(new HashSet<>()));
        assertFalse(BaseTestService.isMap(new ArrayList<>()));
        assertFalse(BaseTestService.isMap("test"));
        assertFalse(BaseTestService.isMap(trade));
    }

    @Test
    void testIsCollection() {
        assertTrue(BaseTestService.isCollection(new HashSet<>()));
        assertTrue(BaseTestService.isCollection(new ArrayList<>()));
        assertFalse(BaseTestService.isCollection(new HashMap<>()));
        assertFalse(BaseTestService.isCollection("test"));
        assertFalse(BaseTestService.isCollection(trade));
    }
}
