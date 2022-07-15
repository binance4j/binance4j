package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.PairParams;

/** TODO JAVADOC */
public class GetIsolatedSymbolTest extends MarginTest {

    @Override
    public void test(Object bean) {
        Set<String> nulls = getNullProperties(bean);
        assertEquals(nulls.size(), 1);
        assertTrue(nulls.contains("id"));
    }

    @Test
    void test1() throws ApiException {
        test(client.getIsolatedSymbol(new PairParams(symbol)));
    }
}
