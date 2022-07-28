package com.binance4j.core.param;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.http.QueryMap;

/** The base of every Binance Request */
public interface Params {
	/** Jackson object mapper used to convert a POJO into a {@link QueryMap} */
	ObjectMapper defaultMapper = new ObjectMapper();
	/** The receiving window. */
	Long defaultRecvWindow = 60_000L;

	default ObjectMapper mapper() {
		return defaultMapper;
	}

	default long recvWindow() {
		return defaultRecvWindow;
	}

	default long timestamp() {
		return System.currentTimeMillis();
	}

	default int weight() {
		try {
			return getClass().getAnnotation(Param.class).weight();
		} catch (Exception e) {
			return 1;
		}
	}

	default RateLimitType rateLimitType() {
		try {
			return getClass().getAnnotation(Param.class).type();
		} catch (Exception e) {
			return RateLimitType.IP;
		}
	}

	default boolean isOrder() {
		try {
			return getClass().getAnnotation(Param.class).isOrder();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @return the params into a {@link QueryMap} and removes null and useless parameters.
	 */
	default Map<String, Object> toMap() {
		Map<String, Object> map = mapper().convertValue(this, new TypeReference<Map<String, Object>>() {
		});
		// add
		if (getClass().getAnnotation(Param.class).timestamp())
			map.put("timestamp", timestamp());
		if (getClass().getAnnotation(Param.class).recvWindow())
			map.put("recvWindow", recvWindow());
		// remove
		map.remove("order");
		map.values().removeAll(Collections.singleton(null));

		return map;
	}

	/**
	 * @return The param fields annotated with {@link Mandatory}.
	 */
	default List<Field> mandatoryFields() {
		return List.of(getClass().getDeclaredFields()).stream().filter(f -> f.isAnnotationPresent(Mandatory.class)).toList();
	}
}