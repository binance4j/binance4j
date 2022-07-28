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

	/**
	 * @return {@link ObjectMapper} responsible for deserialization.
	 */
	default ObjectMapper mapper() {
		return defaultMapper;
	}

	/**
	 * @return The request receiving window.
	 */
	default long recvWindow() {
		return defaultRecvWindow;
	}

	/**
	 * @return The request timestamp in ms.
	 */
	default long timestamp() {
		return System.currentTimeMillis();
	}

	/**
	 * @return The request weight.
	 */
	default int weight() {
		return !getClass().isAnnotationPresent(Param.class) ? 1 : getClass().getAnnotation(Param.class).weight();

	}

	/**
	 * @return The request rate limit type. linked to {@link Params#weight()}.
	 */
	default RateLimitType rateLimitType() {
		return !getClass().isAnnotationPresent(Param.class) ? RateLimitType.IP : getClass().getAnnotation(Param.class).type();
	}

	/**
	 * @return If the request is an order
	 */
	default boolean isOrder() {
		return !getClass().isAnnotationPresent(Param.class) ? false : getClass().getAnnotation(Param.class).isOrder();
	}

	/**
	 * @return the params into a {@link QueryMap} minus null and useless parameters.
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
	 * Merges two {@link Params} into a {@link Map}
	 * 
	 * @return the merged maps.
	 */
	default Map<String, Object> toMap(Params params) {
		var map = toMap();
		map.putAll(params.toMap());
		return map;
	}

	/**
	 * @return The param fields annotated with {@link Mandatory}.
	 */
	default List<Field> mandatoryFields() {
		return List.of(getClass().getDeclaredFields()).stream().filter(f -> f.isAnnotationPresent(Mandatory.class)).toList();
	}
}