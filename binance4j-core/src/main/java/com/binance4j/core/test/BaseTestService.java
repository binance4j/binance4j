package com.binance4j.core.test;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class BaseTestService {
    public static final String KEY = System.getenv("BINANCE_API_KEY");
    public static final String SECRET = System.getenv("BINANCE_API_SECRET");
    public static final String TESTNETKEY = System.getenv("BINANCE_TESTNET_API_KEY");
    public static final String TESTNETSECRET = System.getenv("BINANCE_TESTNET_API_SECRET");
    public static final String SYMBOL = "BNBBTC";
    public static final String ASSET = "BNB";
    public static final List<String> ASSETS = Arrays.asList(ASSET, "BUSD", "BTC");
    public static final List<String> SYMBOLS = Arrays.asList(SYMBOL, "BNBBUSD", "BTCBUSD");

    protected BaseTestService() {
    }

    /**
     * Returns the properties of the given bean
     * 
     * @param bean The bean we want the properties
     * @return The bean properties
     */
    public static Map<String, Object> getBeanProperties(Object bean) {
        Map<String, Object> map = new HashMap<>();
        try {
            Arrays.asList(Introspector.getBeanInfo(bean.getClass(), Object.class)
                    .getPropertyDescriptors())
                    .stream()
                    .forEach(pd -> {
                        try {
                            map.put(pd.getName(), pd.getReadMethod().invoke(bean));
                        } catch (Exception e) {
                        }
                    });
            return map;
        } catch (IntrospectionException e) {
            return Collections.emptyMap();
        }
    }

    /**
     * Returns the bean properties with a null walue or null
     * 
     * @param bean The bean we want the properties
     * @return The bean properties with a null value
     */
    public static List<String> getNullProperties(Object bean) {
        return getBeanProperties(bean).entrySet().stream().filter(t -> Objects.isNull(t.getValue()))
                .map(Entry::getKey).collect(Collectors.toList());
    }

    /**
     * Tells if the given object has no null property
     * 
     * @param bean The bean to verify
     */
    public static boolean hasNoNullProperty(Object bean) {
        return getNullProperties(bean).isEmpty();
    }
}