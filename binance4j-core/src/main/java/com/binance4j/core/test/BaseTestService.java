package com.binance4j.core.test;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
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
     */
    public static Map<String, Object> getProperties(Object bean) {
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
     * Returns the bean properties with a null walue
     * 
     * @param bean The bean we want the properties
     */
    public static Set<String> getNullProperties(Object bean) {
        if (!isJavaBean(bean)) {
            return getProperties(bean).entrySet().stream().filter(t -> Objects.isNull(t.getValue()))
                    .map(Entry::getKey).map(k -> bean.getClass().getSimpleName() + "." + k).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

    /**
     * Returns the bean properties in the collection with a null walue
     * 
     * @param collection The collection we want the bean properties
     */
    public static Set<String> getNullProperties(Collection<?> collection) {
        Set<String> set = new HashSet<>();
        int i = 0;

        for (Object bean : collection) {
            Set<String> nullProps = BaseTestService.getNullProperties(bean);

            for (String np : nullProps) {
                set.add(String.format("%s[%s].%s", np.split("\\.")[0], Integer.toString(i), np.split("\\.")[1]));
            }
            i++;
        }

        return set;
    }

    /**
     * Returns the bean properties in the map with a null walue
     * 
     * @param collection The map we want the bean properties
     */
    public static Set<String> getNullProperties(Map<String, ?> bean) {
        return bean.entrySet().stream()
                .map(es -> getNullProperties(es.getValue()).stream().map(np -> es.getKey() + "." + np)
                        .collect(Collectors.toSet()))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    /**
     * Tells if the given object has no null property
     * 
     * @param bean The bean to verify
     */
    public static boolean hasNoNullProperty(Object bean) {
        return getNullProperties(bean).isEmpty();
    }

    /**
     * Tells if the bean has properties
     * 
     * @param bean The bean we want to inspect
     */
    public static boolean hasProperties(Object bean) {
        return getProperties(bean).size() != 0;
    }

    /**
     * Tells if the object is from the java lang package
     * 
     * @param bean The bean to inspect
     */
    public static boolean isJavaBean(Object bean) {
        return bean.getClass().getName().startsWith("java");
    }

    /**
     * Tells if the object is a Map
     * 
     * @param bean The bean to inspect
     */
    public static boolean isMap(Object bean) {
        return bean instanceof Map;
    }

    /**
     * Tells if the object is a Collection (Map excluded)
     * 
     * @param bean The bean to inspect
     */
    public static boolean isCollection(Object bean) {
        return bean instanceof Collection;
    }

}