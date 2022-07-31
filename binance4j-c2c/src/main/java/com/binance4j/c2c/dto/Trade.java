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
public record Trade(String orderNumber, long advNo, String tradeType, String asset, String fiat, String fiatSymbol, String amount, String totalPrice,
		String unitPrice, String orderStatus, long createTime, String commission, String counterPartNickName, String advertisementRole) {
}
