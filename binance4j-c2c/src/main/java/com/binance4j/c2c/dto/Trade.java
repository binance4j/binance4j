package com.binance4j.c2c.dto;

/**
 * A C2C Trade.
 * 
 * @param orderNumber         Order number.
 * @param advNo               Adv No.
 * @param tradeType           Trade type.
 * @param asset               Asset.
 * @param fiat                Fiat.
 * @param fiatSymbol          Fiat symbol.
 * @param amount              Amount.
 * @param totalPrice          Total price.
 * @param unitPrice           Unit price.
 * @param orderStatus         Order status.
 * @param createTime          Create time.
 * @param commission          Commission.
 * @param counterPartNickName Counter part nickname.
 * @param advertisementRole   Advertisement role.
 */
public record Trade(
		/** Order number. */
		String orderNumber,
		/** Adv No. */
		long advNo,
		/** Trade type. */
		String tradeType,
		/** Asset. */
		String asset,
		/** Fiat. */
		String fiat,
		/** Fiat symbol. */
		String fiatSymbol,
		/** Amount. */
		String amount,
		/** Total price. */
		String totalPrice,
		/** Unit price. */
		String unitPrice,
		/** Order status. */
		String orderStatus,
		/** Create time. */
		long createTime,
		/** Commission. */
		String commission,
		/** Counter part nickname. */
		String counterPartNickName,
		/** Advertisement role. */
		String advertisementRole) {
}
