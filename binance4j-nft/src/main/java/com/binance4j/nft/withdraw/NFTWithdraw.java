package com.binance4j.nft.withdraw;

import com.binance4j.nft.deposit.NFTDeposit;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * A NFT Withdraw
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NFTWithdraw extends NFTDeposit {
	/**
	 * The withdraw fee
	 */
	private BigDecimal fee;
	/**
	 * The fee asset
	 */
	private String feeAsset;
}
