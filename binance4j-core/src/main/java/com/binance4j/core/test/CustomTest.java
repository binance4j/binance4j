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

import com.binance4j.core.Request;
import com.binance4j.core.exception.ApiException;

@Execution(ExecutionMode.CONCURRENT)
public abstract class CustomTest<T> {
	protected String key = System.getenv("BINANCE_API_KEY");
	protected String secret = System.getenv("BINANCE_API_SECRET");
	protected String testnetKey = System.getenv("BINANCE_TESTNET_API_KEY");
	protected String testnetSecret = System.getenv("BINANCE_TESTNET_API_SECRET");
	protected String symbol = "BNBBTC";
	protected String asset = "BNB";
	protected int limit = 25;
	protected List<String> assets = Arrays.asList(asset, "BUSD", "BTC");
	protected List<String> symbols = Arrays.asList(symbol, "BNBBUSD", "BTCBUSD");
	protected T client;
	protected T testnetClient;

	protected CustomTest() {
	}

	protected CustomTest(T client) {
		this.client = client;
	}

	protected CustomTest(Class<? extends T> client) {
		try {
			this.client = client.getDeclaredConstructor(String.class, String.class).newInstance(getKey(), getSecret());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}

	protected CustomTest(Class<? extends T> client, Class<? extends T> testnetClient) {
		try {
			this.client = client.getDeclaredConstructor(String.class, String.class).newInstance(getKey(), getSecret());
			this.testnetClient = testnetClient.getDeclaredConstructor(String.class, String.class).newInstance(getTestnetKey(), getTestnetSecret());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
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
			if (bean != null) {
				if (bean instanceof Record) {
					Arrays.asList(bean.getClass().getRecordComponents()).stream().forEach(pd -> {
						try {
							map.put(pd.getName(), pd.getAccessor().invoke(bean));
						} catch (Exception e) {
						}
					});
				} else {
					Arrays.asList(Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors()).stream().forEach(pd -> {
						try {
							map.put(pd.getName(), pd.getReadMethod().invoke(bean));
						} catch (Exception e) {
						}
					});
				}
			}
			return map;
		} catch (IntrospectionException e) {
			return Collections.emptyMap();
		}
	}

	/**
	 * Returns the properties of the given bean
	 * 
	 * @param collection The collection we want the properties
	 */
	protected Map<String, Object> getProperties(Collection<?> collection) {
		Map<String, Object> map = new HashMap<>();
		int i = 0;
		for (var bean : collection) {
			for (var es : getProperties(bean).entrySet()) {
				map.put(String.format("%s[%s]", es.getKey(), Integer.toString(i)), es.getValue());
			}
			i++;
		}

		return map;
	}

	/**
	 * Returns the bean properties with a null walue
	 * 
	 * @param bean The bean we want the properties
	 */
	protected Set<String> getNullProperties(Object bean) {
		return getNullProperties(bean, bean == null ? "object" : bean.getClass().getSimpleName());
	}

	/**
	 * Returns the bean properties with a null walue
	 * 
	 * @param bean    The bean we want the properties
	 * @param flatten Flatten the result to only show the properties names
	 */
	protected Set<String> getNullProperties(Object bean, boolean flatten) {
		Set<String> set = getNullProperties(bean, bean.getClass().getSimpleName());

		return !flatten ? set : set.stream().map(string -> {
			String[] array = string.split("\\.");
			return array[array.length - 1];
		}).collect(Collectors.toSet());
	}

	/**
	 * Returns the bean properties with a null walue
	 * 
	 * @param bean       The bean we want the properties
	 * @param parentBean The enclosing class
	 */
	protected Set<String> getNullProperties(Object bean, String parentBean) {
		List<String> list = new ArrayList<>();
		if (bean == null) {
			return Set.of(parentBean);
		}
		// Handling collections
		if (bean instanceof Collection) {
			int i = 0;

			for (Object b : (Collection<?>) bean) {
				Set<String> nullProps = getNullProperties(b, bean.getClass().getSimpleName());
				for (String np : nullProps) {
					list.add(String.format("%s[%s].%s", parentBean, Integer.toString(i), np));
				}
				i++;

			}
		}
		// Handling maps
		else if (bean instanceof Map) {
			list = ((Map<?, ?>) bean).entrySet().stream().map(es -> getNullProperties(es.getValue(), bean.getClass().getSimpleName()).stream()
					.map(np -> es.getKey() + "." + np).collect(Collectors.toSet())).flatMap(Collection::stream).collect(Collectors.toList());
		}
		// Handling custom objects
		else if (!isJavaBean(bean)) {
			list = getProperties(bean).entrySet().stream().map(o -> {
				if (o.getValue() instanceof Collection || o.getValue() instanceof Map) {
					return getNullProperties(o.getValue(), o.getKey());
				} else if (o.getValue() == null) {
					return new HashSet<>(Arrays.asList(Character.isUpperCase(parentBean.charAt(0)) ? o.getKey() : parentBean + "." + o.getKey()));
				} else {
					return getNullProperties(o.getValue(), o.getKey());
				}
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

	/**
	 * Tests that the object has no null properties
	 * 
	 * @param bean
	 */
	public void test(Object bean) {
		Set<String> nulls = getNullProperties(bean);

		String text = String.format("Testing %s object...\n\n%s\n\n", bean.getClass().getSimpleName(), bean);
		String nullText = nulls.isEmpty() ? "no null property." : "null properties:" + nulls + "\n";
		String seperator = "\n==========\n";

		text = String.format("%s\n%s", text, nullText);

		System.out.println(seperator + text + seperator);

		assertTrue(hasNoNullProperty(bean));
	}

	/**
	 * Tests that the object has no null properties
	 * 
	 * @throws ApiException
	 */
	public void test(Request<?> executor) throws ApiException {
		test(executor.execute());
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @return the testnetKey
	 */
	public String getTestnetKey() {
		return testnetKey;
	}

	/**
	 * @return the testnetSecret
	 */
	public String getTestnetSecret() {
		return testnetSecret;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @return the asset
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @return the assets
	 */
	public List<String> getAssets() {
		return assets;
	}

	/**
	 * @return the symbols
	 */
	public List<String> getSymbols() {
		return symbols;
	}

	/**
	 * @return the client
	 */
	public T getClient() {
		return client;
	}

	/**
	 * @return the testnetClient
	 */
	public T getTestnetClient() {
		return testnetClient;
	}

}