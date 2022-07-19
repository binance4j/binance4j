package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

import lombok.NonNull;

/**
 * 
 */
@Execution(ExecutionMode.CONCURRENT)
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
	protected CustomTest(@NonNull Class<? extends T> clientClass) {
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
		Map<String, Object> map = new HashMap<>();
		try {
			List.of(Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors()).stream().forEach(pd -> {
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
		Set<String> set = getNullProperties(bean, bean.getClass().getSimpleName());

		return !flatten ? set : set.stream().map(string -> {
			String[] array = string.split("\\.");
			return array[array.length - 1];
		}).collect(Collectors.toSet());
	}

	/**
	 * @param bean           The bean we want the properties.
	 * @param enclosingClass The enclosing class.
	 * @return the bean properties with a null walue.
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
			list = ((Map<?, ?>) bean).entrySet().stream().map(es -> getNullProperties(es.getValue(), bean.getClass().getSimpleName()).stream()
					.map(np -> es.getKey() + "." + np).collect(Collectors.toSet())).flatMap(Collection::stream).collect(Collectors.toList());
		}
		// Handling custom objects
		else if (!isJavaBean(bean)) {
			list = getProperties(bean).entrySet().stream().map(o -> {
				if (o.getValue() instanceof Collection || o.getValue() instanceof Map) {
					return getNullProperties(o.getValue(), o.getKey());
				} else if (o.getValue() == null) {
					return new HashSet<>(List.of(Character.isUpperCase(enclosingClass.charAt(0)) ? o.getKey() : enclosingClass + "." + o.getKey()));
				} else {
					return getNullProperties(o.getValue(), o.getKey());
				}
			}).flatMap(Collection::stream).collect(Collectors.toList());
		}
		Collections.sort(list);

		return new TreeSet<>(list);
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
	 * @param bean The bean to inspect.
	 * @return if the object is a Map.
	 */
	protected boolean isMap(Object bean) {
		return bean instanceof Map;
	}

	/**
	 * @param bean The bean to inspect.
	 * @return if the object is a Collection (Map excluded).
	 */
	protected boolean isCollection(Object bean) {
		return bean instanceof Collection;
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