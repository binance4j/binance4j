package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;
import java.beans.Introspector;
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

import com.binance4j.core.Request;
import com.binance4j.core.exception.ApiException;

/** Base class for Unit test. */
// @Execution(ExecutionMode.CONCURRENT)
public abstract class CustomTest {
	/** The key. */
	protected String key = System.getenv("BINANCE_API_KEY");
	/** The secret. */
	protected String secret = System.getenv("BINANCE_API_SECRET");
	/** The testnetKey. */
	protected String testnetKey = System.getenv("BINANCE_TESTNET_API_KEY");
	/** The testnetSecret. */
	protected String testnetSecret = System.getenv("BINANCE_TESTNET_API_SECRET");
	/** The symbol. */
	protected String symbol = "BNBBTC";
	/** The asset. */
	protected String asset = "BNB";
	/** The limit. */
	protected int limit = 25;
	/** The String. */
	protected List<String> assets = Arrays.asList(asset, "BUSD", "BTC");
	/** The String. */
	protected List<String> symbols = Arrays.asList(symbol, "BNBBUSD", "BTCBUSD");

	/**
	 * @return the properties of the given bean
	 * @param bean Bean we want the properties
	 */
	public Map<String, Object> getProperties(Object bean) {
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
					Arrays.asList(Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors())
							.stream().forEach(pd -> {
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
	 * @return the properties of the given bean
	 * @param collection Collection we want the properties
	 */
	public Map<String, Object> getProperties(Collection<?> collection) {
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
	 * @return the bean properties with a null walue
	 * @param bean Bean we want the properties
	 */
	public Set<String> getNullProperties(Object bean) {
		return getNullProperties(bean, bean == null ? "object" : bean.getClass().getSimpleName());
	}

	/**
	 * @return the bean properties with a null walue
	 * @param bean    Bean we want the properties
	 * @param flatten Flatten the result to only show the properties names
	 */
	public Set<String> getNullProperties(Object bean, boolean flatten) {
		Set<String> set = getNullProperties(bean, bean.getClass().getSimpleName());
		return !flatten ? set : set.stream().map(string -> {
			String[] array = string.split("\\.");
			return array[array.length - 1];
		}).collect(Collectors.toSet());
	}

	/**
	 * @return the bean properties with a null walue
	 * @param bean       Bean we want the properties
	 * @param parentBean Enclosing class
	 */
	public Set<String> getNullProperties(Object bean, String parentBean) {
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
			list = ((Map<?, ?>) bean).entrySet().stream()
					.map(es -> getNullProperties(es.getValue(), bean.getClass().getSimpleName()).stream()
							.map(np -> es.getKey() + "." + np).collect(Collectors.toSet()))
					.flatMap(Collection::stream).collect(Collectors.toList());
		}
		// Handling custom objects
		else if (!isJavaBean(bean)) {
			list = getProperties(bean).entrySet().stream().map(o -> {
				if (o.getValue() instanceof Collection || o.getValue() instanceof Map) {
					return getNullProperties(o.getValue(), o.getKey());
				} else if (o.getValue() == null) {
					return new HashSet<>(Arrays.asList(
							Character.isUpperCase(parentBean.charAt(0)) ? o.getKey() : parentBean + "." + o.getKey()));
				} else {
					return getNullProperties(o.getValue(), o.getKey());
				}
			}).flatMap(Collection::stream).collect(Collectors.toList());
		}
		Collections.sort(list);
		return new TreeSet<>(list);
	}

	/**
	 * @return if the given object has no null property
	 * @param bean Bean to verify
	 */
	public boolean hasNoNullProperty(Object bean) {
		return getNullProperties(bean).isEmpty();
	}

	/**
	 * @return if the bean has properties
	 * @param bean Bean we want to inspect
	 */
	public boolean hasProperties(Object bean) {
		return getProperties(bean).size() != 0;
	}

	/**
	 * @return if the object is from the java lang package
	 * @param bean Bean to inspect
	 */
	public boolean isJavaBean(Object bean) {
		return bean.getClass().getName().startsWith("java");
	}

	/**
	 * @return if the object is a Map
	 * @param bean Bean to inspect
	 */
	public boolean isMap(Object bean) {
		return bean instanceof Map;
	}

	/**
	 * @return if the object is a Collection (Map excluded)
	 * @param bean Bean to inspect
	 */
	public boolean isCollection(Object bean) {
		return bean instanceof Collection;
	}

	/**
	 * Tests that the object has no null properties.
	 * 
	 * @param bean Bean to test.
	 */
	public void testNoNulls(Object bean) {
		Set<String> nulls = getNullProperties(bean);
		printNulls(nulls, bean);
		assertTrue(hasNoNullProperty(bean));
	}

	/**
	 * Tests that the object has no null properties.
	 * 
	 * @param request Request to execute.
	 * @throws ApiException thrown if execution failed.
	 */
	public void testNoNulls(Request<?> request) throws ApiException {
		testNoNulls(request.sync());
	}

	/**
	 * Tests that the object has no null properties.
	 * 
	 * @param request Request to execute.
	 * @throws ApiException thrown if execution failed.
	 */
	public void testNotThrow(Request<?> request) throws ApiException {
		assertDoesNotThrow(() -> {
			var res = request.sync();
			if (res != null) {
				Set<String> nulls = getNullProperties(res);
				printNulls(nulls, res);
			}
		});
	}

	/**
	 * Tests that the object has the expected null properties.
	 * 
	 * @param bean          Bean to test.
	 * @param expectedNulls Expected null properties.
	 * @param flatten       Flatten the properties.
	 */
	public void testHasNulls(Object bean, Collection<String> expectedNulls, boolean flatten) {
		Set<String> nulls = getNullProperties(bean, flatten);
		printNulls(nulls, bean);
		assertTrue(nulls.containsAll(expectedNulls));
	}

	/**
	 * Tests that the object has the expected null properties.
	 * 
	 * @param request       Request to execute.
	 * @param expectedNulls Expected null properties.
	 * @param flatten       Flatten the properties.
	 * @throws ApiException thrown if execution failed.
	 */
	public void testHasNulls(Request<?> request, Collection<String> expectedNulls, boolean flatten)
			throws ApiException {
		testHasNulls(request.sync(), expectedNulls, flatten);
	}

	/**
	 * Prints the bean null values
	 * 
	 * @param nulls Null values
	 * @param bean  Bean
	 */
	private void printNulls(Set<String> nulls, Object bean) {
		String text = String.format("Testing %s object...\n\n%s\n\n", bean.getClass().getSimpleName(), bean);
		String nullText = nulls.isEmpty() ? "no null property." : "null properties:" + nulls + "\n";
		String seperator = "\n==========\n";
		text = String.format("%s\n%s", text, nullText);
		System.out.println(seperator + text + seperator);
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
}