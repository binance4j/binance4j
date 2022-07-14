package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.binance4j.core.market.AggTrade;
import com.binance4j.core.pojo.NestedObject;
import com.binance4j.core.pojo.SubObject;
import com.binance4j.core.pojo.SubSubObject;

/** TODO JAVADOC */
public class BaseTestServiceTest extends ConcurrentTest<Void> {
    protected BaseTestServiceTest() {
        super();
    }

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
    void testGetProperties() {
        Map<String, Object> map = getProperties(trade);

        List<String> list = new ArrayList<String>();
        list.add("ok");
        list.add("lol");
        list.add("hihi");

        assertEquals(map.get("firstTradeId"), trade.getFirstTradeId());
        assertEquals(map.get("lastTradeId"), trade.getLastTradeId());
        assertEquals(map.get("price"), trade.getPrice());
        assertEquals(map.get("quantity"), trade.getQuantity());
        assertEquals(map.get("time"), trade.getTime());
        assertEquals(map.get("tradeId"), trade.getTradeId());
    }

    @Test
    void testGetNullProperties() {
        trade.setFirstTradeId(null);
        trade.setPrice(null);

        Set<String> list = getNullProperties(trade);
        assertEquals(2, list.size());
        assertTrue(list.containsAll(Arrays.asList("firstTradeId", "price")));
    }

    @Test
    void testGetNullPropertiesOfList() {
        trade.setFirstTradeId(null);
        trade.setPrice(null);

        List<AggTrade> listOfTrades = new ArrayList<>();
        listOfTrades.add(trade);
        listOfTrades.add(trade2);
        Set<String> list = getNullProperties(listOfTrades);

        assertEquals(4, list.size());
        assertTrue(list.contains("ArrayList[0].firstTradeId"));
        assertTrue(list.contains("ArrayList[0].price"));
        assertTrue(list.contains("ArrayList[1].quantity"));
        assertTrue(list.contains("ArrayList[1].time"));
    }

    @Test
    void testGetNestedProperties() {
        trade.setFirstTradeId(null);
        trade.setPrice(null);

        SubSubObject subSubObject1 = new SubSubObject();
        subSubObject1.getTrades().add(trade);
        subSubObject1.getTrades().add(trade);

        SubSubObject subSubObject2 = new SubSubObject();
        subSubObject2.getTrades().add(trade);
        subSubObject2.getTrades().add(trade);

        SubObject subsub1 = new SubObject();
        subsub1.getSubSubObjects().add(subSubObject1);
        subsub1.getSubSubObjects().add(subSubObject2);

        SubObject subsub2 = new SubObject();
        subsub2.getSubSubObjects().add(subSubObject1);
        subsub2.getSubSubObjects().add(subSubObject2);

        NestedObject nestedObject = new NestedObject();
        nestedObject.getSubs().add(subsub1);
        nestedObject.getSubs().add(subsub2);

        Set<String> list = getNullProperties(nestedObject);

        assertEquals(16, list.size());
        assertTrue(list.contains("subs[0].subSubObjects[0].trades[0].firstTradeId"));
        assertTrue(list.contains("subs[0].subSubObjects[0].trades[0].price"));
        assertTrue(list.contains("subs[0].subSubObjects[0].trades[1].firstTradeId"));
        assertTrue(list.contains("subs[0].subSubObjects[0].trades[1].price"));
        assertTrue(list.contains("subs[0].subSubObjects[1].trades[0].firstTradeId"));
        assertTrue(list.contains("subs[0].subSubObjects[1].trades[0].price"));
        assertTrue(list.contains("subs[0].subSubObjects[1].trades[1].firstTradeId"));
        assertTrue(list.contains("subs[0].subSubObjects[1].trades[1].price"));
        assertTrue(list.contains("subs[1].subSubObjects[0].trades[0].firstTradeId"));
        assertTrue(list.contains("subs[1].subSubObjects[0].trades[0].price"));
        assertTrue(list.contains("subs[1].subSubObjects[0].trades[1].firstTradeId"));
        assertTrue(list.contains("subs[1].subSubObjects[0].trades[1].price"));
        assertTrue(list.contains("subs[1].subSubObjects[1].trades[0].firstTradeId"));
        assertTrue(list.contains("subs[1].subSubObjects[1].trades[0].price"));
        assertTrue(list.contains("subs[1].subSubObjects[1].trades[1].firstTradeId"));
        assertTrue(list.contains("subs[1].subSubObjects[1].trades[1].price"));
    }

    @Test
    void testHasNoNullProperty() throws IntrospectionException {
        assertTrue(hasNoNullProperty(trade));
    }

    @Test
    void testHasNullProperty() throws IntrospectionException {
        trade.setFirstTradeId(null);
        assertFalse(hasNoNullProperty(trade));
    }

    @Test
    void testHasBeanProperties() {
        assertTrue(hasProperties(trade));
    }

    @Test
    void testIsJava() {
        assertTrue(isJavaBean("test"));
        assertTrue(isJavaBean(new ArrayList<>()));
        assertTrue(isJavaBean(new HashMap<>()));
        assertFalse(isJavaBean(trade));
    }

    @Test
    void testIsMap() {
        assertTrue(isMap(new HashMap<>()));
        assertFalse(isMap(new HashSet<>()));
        assertFalse(isMap(new ArrayList<>()));
        assertFalse(isMap("test"));
        assertFalse(isMap(trade));
    }

    @Test
    void testIsCollection() {
        assertTrue(isCollection(new HashSet<>()));
        assertTrue(isCollection(new ArrayList<>()));
        assertFalse(isCollection(new HashMap<>()));
        assertFalse(isCollection("test"));
        assertFalse(isCollection(trade));
    }
}
