/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.margin.param;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;

/**
 * A LIMIT_MAKER order.
 */
public class LimitMakerOrder extends BaseOrder {
	/**
	 * Order quantity
	 */
	String quantity;
	
	/**
	 * Order price
	 */
	String price;
	
	/**
	 * @param symbol   Symbol.
	 * @param side     Side.
	 * @param quantity Order quantity.
	 * @param price    Order price.
	 */
	public LimitMakerOrder(String symbol, OrderSide side, String quantity, String price) {
		super(symbol, side, OrderType.LIMIT_MAKER);
		this.quantity = quantity;
		this.price = price;
	}
	
	/**
	 * Creates an instance of {@link LimitMakerOrder} in the BUY side.
	 *
	 * @param symbol   Symbol.
	 * @param quantity Order quantity.
	 * @param price    Order price.
	 *
	 * @return An instance of {@link LimitMakerOrder}.
	 */
	public static LimitMakerOrder buy(String symbol, String quantity, String price) {
		return new LimitMakerOrder(symbol, OrderSide.BUY, quantity, price);
	}
	
	/**
	 * Creates an instance of {@link LimitMakerOrder} in the SELL side.
	 *
	 * @param symbol   Symbol.
	 * @param quantity Order quantity.
	 * @param price    Order price.
	 *
	 * @return An instance of {@link LimitMakerOrder}.
	 */
	public static LimitMakerOrder sell(String symbol, String quantity, String price) {
		return new LimitMakerOrder(symbol, OrderSide.SELL, quantity, price);
	}
	
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "LimitMakerOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}