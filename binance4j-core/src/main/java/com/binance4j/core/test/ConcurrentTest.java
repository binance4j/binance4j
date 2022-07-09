package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import lombok.Getter;
import lombok.NonNull;

@Execution(ExecutionMode.CONCURRENT)
public abstract class ConcurrentTest<T> {
    @Getter
    protected String key = System.getenv("BINANCE_API_KEY");
    @Getter
    protected String secret = System.getenv("BINANCE_API_SECRET");
    @Getter
    protected String testnetKey = System.getenv("BINANCE_TESTNET_API_KEY");
    @Getter
    protected String testnetSecret = System.getenv("BINANCE_TESTNET_API_SECRET");
    @Getter
    protected String symbol = "BNBBTC";
    @Getter
    protected String asset = "BNB";
    @Getter
    protected int limit = 25;
    @Getter
    protected List<String> assets = Arrays.asList(asset, "BUSD", "BTC");
    @Getter
    protected List<String> symbols = Arrays.asList(symbol, "BNBBUSD", "BTCBUSD");
    @Getter
    protected T client;
    @Getter
    protected T testnetClient;

    protected ConcurrentTest() {
    }

    protected ConcurrentTest(T client) {
        this.client = client;
    }

    protected ConcurrentTest(@NonNull Class<? extends T> client) {
        try {
            this.client = client.getDeclaredConstructor(String.class, String.class).newInstance(getKey(),
                    getSecret());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    protected ConcurrentTest(Class<? extends T> client, Class<? extends T> testnetClient) {
        try {
            this.client = client.getDeclaredConstructor(String.class, String.class).newInstance(getKey(), getSecret());
            this.testnetClient = testnetClient.getDeclaredConstructor(String.class, String.class).newInstance(
                    getTestnetKey(),
                    getTestnetSecret());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the properties of the given bean
     * 
     * @param bean The bean we want the properties
     */
    protected Map<String, Object> getProperties(Object bean) {
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
    protected Set<String> getNullProperties(Object bean) {
        return getNullProperties(bean, bean.getClass().getSimpleName());
    }

    /**
     * Returns the bean properties with a null walue
     * 
     * @param bean           The bean we want the properties
     * @param enclosingClass The enclosing class
     */
    protected Set<String> getNullProperties(Object bean, String enclosingClass) {
        List<String> list = new ArrayList<>();
        // Handling collections
        if (bean instanceof Collection) {
            int i = 0;

            for (Object b : (Collection<?>) bean) {
                Set<String> nullProps = getNullProperties(b, bean.getClass().getSimpleName());

                for (String np : nullProps) {
                    list.add(String.format("%s[%s].%s", enclosingClass, Integer.toString(i), np));
                }
                i++;

            }
        }
        // Handling maps
        else if (bean instanceof Map) {
            list = ((Map<?, ?>) bean).entrySet().stream()
                    .map(es -> getNullProperties(es.getValue(), bean.getClass().getSimpleName())
                            .stream()
                            .map(np -> es.getKey() + "." + np)
                            .collect(Collectors.toSet()))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
        // Handling custom objects
        else if (!isJavaBean(bean)) {
            list = getProperties(bean).entrySet().stream().map(o -> {
                if (o.getValue() instanceof Collection || o.getValue() instanceof Map) {
                    return getNullProperties(o.getValue(), o.getKey());
                } else if (o.getValue() == null) {
                    return new HashSet<>(Arrays.asList(o.getKey()));
                }
                return new HashSet<String>();
            }).flatMap(Collection::stream).collect(Collectors.toList());
        }
        Collections.sort(list);

        return new TreeSet<>(list);
    }

    /**
     * Tells if the given object has no null property
     * 
     * @param bean The bean to verify
     */
    protected boolean hasNoNullProperty(Object bean) {
        return getNullProperties(bean).isEmpty();
    }

    /**
     * Tells if the bean has properties
     * 
     * @param bean The bean we want to inspect
     */
    protected boolean hasProperties(Object bean) {
        return getProperties(bean).size() != 0;
    }

    /**
     * Tells if the object is from the java lang package
     * 
     * @param bean The bean to inspect
     */
    protected boolean isJavaBean(Object bean) {
        return bean.getClass().getName().startsWith("java");
    }

    /**
     * Tells if the object is a Map
     * 
     * @param bean The bean to inspect
     */
    protected boolean isMap(Object bean) {
        return bean instanceof Map;
    }

    /**
     * Tells if the object is a Collection (Map excluded)
     * 
     * @param bean The bean to inspect
     */
    protected boolean isCollection(Object bean) {
        return bean instanceof Collection;
    }

    public void test(Object bean) {
        System.out.println(String.format("Testing %s object", bean.getClass().getSimpleName()));
        System.out.println();
        System.out.println(bean);
        System.out.println();

        assertTrue(hasNoNullProperty(bean));

        System.out.println("null properties:");
        System.out.println();
        System.out.println(getNullProperties(bean));
        System.out.println();
    }
}