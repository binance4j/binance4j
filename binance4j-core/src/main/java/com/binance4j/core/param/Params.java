package com.binance4j.core.param;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.dto.RateLimitType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.http.QueryMap;

/** The base of every Binance Request */
public class Params {
	/** Jackson object mapper used to convert a POJO into a {@link QueryMap} */
	protected static final ObjectMapper MAPPER = new ObjectMapper();
	/** The receiving window. */
	protected Long recvWindow = 60_000L;
	/** The request timestamp. */
	protected Long timestamp = System.currentTimeMillis();
	/** The request weight */
	protected int weight = 1;
	/** Is this request generating an order? */
	protected boolean isOrderRequest;
	/** The request weight type. */
	protected RateLimitType rateLimitType = RateLimitType.IP;

	/** Constructor */
	protected Params() {
	}

	/** @param weight The Request weight */
	public Params(int weight) {
		this.weight = weight;
	}

	/**
	 * @param weight         The Request weight.
	 * @param isOrderRequest Is the request a trading order.
	 */
	public Params(int weight, Boolean isOrderRequest) {
		this.weight = weight;
		this.isOrderRequest = isOrderRequest;
	}

	/**
	 * @return the params into a {@link QueryMap} and removes null and useless parameters.
	 */
	public Map<String, Object> toMap() {
		Map<String, Object> map = MAPPER.convertValue(this, new TypeReference<Map<String, Object>>() {
		});

		List.of("weight", "weightType", "orderRequest", "isOrderRequest").forEach(f -> map.remove(f));
		map.values().removeAll(Collections.singleton(null));
		return map;
	}

	/**
	 * @return The param fields annotated with {@link Mandatory}.
	 */
	public List<Field> getMandatoryFields() {
		return List.of(getClass().getDeclaredFields()).stream().filter(f -> f.isAnnotationPresent(Mandatory.class)).toList();
	}

	/** @return the weight */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the weightType
	 */
	public RateLimitType getWeightType() {
		return rateLimitType;
	}

	/**
	 * @param weightType the weightType to set
	 */
	public void setWeightType(RateLimitType weightType) {
		this.rateLimitType = weightType;
	}

	/**
	 * @return the recvWindow
	 */
	public Long getRecvWindow() {
		return recvWindow;
	}

	/**
	 * @param recvWindow the recvWindow to set
	 */
	public void setRecvWindow(Long recvWindow) {
		this.recvWindow = recvWindow;
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}