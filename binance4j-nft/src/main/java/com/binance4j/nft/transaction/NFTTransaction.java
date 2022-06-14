package com.binance4j.nft.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFTTransaction {
	/**
	 * The Order number.
	 * <ul>
	 * <li>0: purchase order</li>
	 * <li>1: sell order</li>
	 * <li>2: royalty income</li>
	 * <li>3: primary market order</li>
	 * <li>4: mint fee</li>
	 * </ul>
	 */
	private String orderNo;
	/**
	 * The tokens
	 */
	private List<NFT> tokens;
	/**
	 * The trade time in ms
	 */
	private Long tradeTime;
	/**
	 * The trade amount
	 */
	private BigDecimal tradeAmount;
	/**
	 * THe currency used to buy the NFT
	 */
	private String tradeCurrency;
}
