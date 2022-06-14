package com.binance4j.spot.order;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

/**
 * The partial trade of an order
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTrade {
	/**
	 * The price
	 */
	BigDecimal price;
	/**
	 * The quantity
	 */
	BigDecimal qty;
	/**
	 * The commission
	 */
	BigDecimal commission;
	/**
	 * The commission asset
	 */
	String commissionAsset;
	/**
	 * The trade id
	 */
	Long tradeId;
}
