package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.binance4j.core.Request;
import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 */
public abstract class CustomTest<T> {
	/** The API public key */
	protected String key = System.getenv("BINANCE_API_KEY");
	/** The API secret */
	protected String secret = System.getenv("BINANCE_API_SECRET");
	/** The testnet public key */
	protected String testnetKey = System.getenv("BINANCE_TESTNET_API_KEY");
	/** The testnet secret */
	protected String testnetSecret = System.getenv("BINANCE_TESTNET_API_SECRET");
	/** The symbol */
	protected String symbol = "BNBBTC";
	/** The asset */
	protected String asset = "BNB";
	/** The limit */
	protected int limit = 25;
	/** The assets */
	protected List<String> assets = List.of(asset, "BUSD", "BTC");
	/** The symbols */
	protected List<String> symbols = List.of(symbol, "BNBBUSD", "BTCBUSD");
	/** The client */
	protected T client;
	/** The testnet client */
	protected T testnetClient;

	/** Constructor */
	protected CustomTest() {
	}

	/**
	 * Constructor
	 * 
	 * @param client The API client.
	 */
	protected CustomTest(T client) {
		this.client = client;
	}

	/**
	 * @param clientClass The client class.
	 */
	protected CustomTest(Class<? extends T> clientClass) {
		try {
			this.client = clientClass.getDeclaredConstructor(String.class, String.class).newInstance(key, secret);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param clientClass        The client class.
	 * @param testnetClientClass The testnet client class.
	 */
	protected CustomTest(Class<? extends T> clientClass, Class<? extends T> testnetClientClass) {
		try {
			this.client = clientClass.getDeclaredConstructor(String.class, String.class).newInstance(key, secret);
			this.testnetClient = testnetClientClass.getDeclaredConstructor(String.class, String.class).newInstance(testnetKey, testnetSecret);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param bean The bean we want the properties.
	 * @return the properties of the given bean.
	 */
	protected Map<String, Object> getProperties(Object bean) {
		if (bean instanceof Collection == false) {
			return new ObjectMapper().convertValue(bean, new TypeReference<Map<String, Object>>() {
			});
		} else {
			return getProperties((Collection<Object>) bean);
		}
	}

	/**
	 * @param bean The bean we want the properties.
	 * @return the properties of the given bean.
	 */
	protected Map<String, Object> getProperties(Collection<Object> bean) {
		Map<String, Object> map = new HashMap<>();
		int i = 0;
		for (var b : (Collection<?>) bean) {
			map.put(String.format("[%s]", Integer.toString(i)), b);
			i++;
		}

		return map;
	}

	/**
	 * @param bean The bean we want the properties.
	 * @return the bean properties with a null walue.
	 */
	protected Set<String> getNullProperties(Object bean, String parentName) {
		if (bean == null) {
			return Collections.emptySet();
		}
		List<String> nulls = new ArrayList<>();

		if (bean instanceof Collection || bean instanceof Map || !isJavaBean(bean)) {
			Map<String, Object> props = getProperties(bean);

			List<String> list = props.entrySet().stream().filter(es -> Objects.isNull(es.getValue())).map(es -> parentName + "." + es.getKey()).toList();
			nulls.addAll(list);

			list = props.entrySet().stream().filter(es -> Objects.nonNull(es.getValue()))
					.map(es -> getNullProperties(es.getValue(), parentName + "." + es.getKey())).flatMap(Collection::stream).collect(Collectors.toList());
			nulls.addAll(list);
		}

		Collections.sort(nulls);
		return new TreeSet<>(nulls);
	}

	/**
	 * @param bean The bean we want the properties.
	 * @return the properties of the given bean.
	 */
	protected Map<String, Object> getProperties(Map<String, Object> bean) {
		return bean;
	}

	/**
	 * @param bean The bean we want the properties.
	 * @return the bean properties with a null walue.
	 */
	protected Set<String> getNullProperties(Object bean) {
		return getNullProperties(bean, bean.getClass().getSimpleName());
	}

	/**
	 * @param bean    The bean we want the properties.
	 * @param flatten Flatten the result to only show the properties names.
	 * @return the bean properties with a null walue.
	 */
	protected Set<String> getNullProperties(Object bean, boolean flatten) {
		Set<String> set = getNullProperties(bean);

		return !flatten ? set : set.stream().map(string -> {
			String[] array = string.split("\\.");
			return array[array.length - 1];
		}).collect(Collectors.toSet());
	}

	/**
	 * @param bean The bean to verify.
	 * @return if the given object has no null property.
	 */
	protected boolean hasNoNullProperty(Object bean) {
		return getNullProperties(bean).isEmpty();
	}

	/**
	 * @param bean The bean we want to inspect.
	 * @return if the bean has properties.
	 */
	protected boolean hasProperties(Object bean) {
		return getProperties(bean).size() != 0;
	}

	/**
	 * @param bean The bean to inspect.
	 * @return if the object is from the java lang package.
	 */
	protected boolean isJavaBean(Object bean) {
		return bean.getClass().getName().startsWith("java");
	}

	/**
	 * Tests that the object has no null properties
	 * 
	 * @param bean The bean.
	 */
	public void test(Object bean) {
		System.out.println(String.format("Testing %s object:", bean.getClass().getSimpleName()));

		Set<String> nulls = getNullProperties(bean);

		if (nulls.isEmpty()) {
			System.out.println("no null property");
		} else {
			System.out.println("null properties:");
			System.out.println(nulls + "\n");
		}

		assertTrue(hasNoNullProperty(bean));
	}

	/**
	 * Tests that the object has no null properties
	 * 
	 * @param req The request.
	 * @throws ApiException Thrown if error
	 */
	public void test(Request<?> req) throws ApiException {
		test(req.execute());
	}

	/**
	 * @return the key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the secret.
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @return the testnetKey.
	 */
	public String getTestnetKey() {
		return testnetKey;
	}

	/**
	 * @return the testnetSecret.
	 */
	public String getTestnetSecret() {
		return testnetSecret;
	}

	/**
	 * @return the symbol.
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @return the asset.
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @return the limit.
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @return the assets.
	 */
	public List<String> getAssets() {
		return assets;
	}

	/**
	 * @return the symbols.
	 */
	public List<String> getSymbols() {
		return symbols;
	}

	/**
	 * @return the client.
	 */
	public T getClient() {
		return client;
	}

	/**
	 * @return the testnetClient.
	 */
	public T getTestnetClient() {
		return testnetClient;
	}

}