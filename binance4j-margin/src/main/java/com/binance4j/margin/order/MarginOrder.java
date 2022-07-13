package com.binance4j.margin.order;

import java.math.BigDecimal;

import com.binance4j.core.configuration.RestClientConfiguration;
import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.BaseOrder;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.OrderType;
import com.binance4j.core.order.SideEffectType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A trade order to enter or exit a position.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MarginOrder extends BaseOrder {
    /**
     * Set the margin order side-effect. NO_SIDE_EFFECT, MARGIN_BUY, AUTO_REPAY;
     * default: NO_SIDE_EFFECT.
     */
    private SideEffectType sideEffectType;

    /**
     * Produit un ordre sans prix
     *
     * @param symbol      la paire d'asset sur laquelle passer l'ordre
     * @param type        le type d'ordre
     * @param side        le sens de l'ordre
     * @param quantity    la quantité de l'ordre
     * @param timeInForce la durée de vie de l'ordre
     */
    public MarginOrder(String symbol, OrderType type, OrderSide side, BigDecimal quantity, TimeInForce timeInForce) {
        super(6, symbol, type, side, quantity, timeInForce);
    }

    /**
     * Produit un ordre sans prix avec time in force GTC par défaut
     *
     * @param symbol   la paire d'asset sur laquelle passer l'ordre
     * @param type     le type d'ordre
     * @param side     le sens de l'ordre
     * @param quantity la quantité de l'ordre
     */
    public MarginOrder(String symbol, OrderType type, OrderSide side, BigDecimal quantity) {
        super(6, symbol, type, side, quantity);
    }

    /**
     * Produit un ordre avec un prix
     *
     * @param symbol      la paire d'asset sur laquelle passer l'ordre
     * @param type        le type d'ordre
     * @param side        le sens de l'ordre
     * @param quantity    la quantité de l'ordre
     * @param price       le prix de l'ordre
     * @param timeInForce la durée de vie de l'ordre
     */
    public MarginOrder(String symbol, OrderType type, OrderSide side, BigDecimal quantity,
            BigDecimal price, TimeInForce timeInForce) {
        super(6, symbol, type, side, quantity, price, timeInForce);
    }

    /**
     * Produit un ordre avec un prix et time in force GTC par défaut
     *
     * @param symbol   la paire d'asset sur laquelle passer l'ordre
     * @param type     le type d'ordre
     * @param side     le sens de l'ordre
     * @param quantity la quantité de l'ordre
     * @param price    le prix de l'ordre
     */
    public MarginOrder(String symbol, OrderType type, OrderSide side, BigDecimal quantity,
            BigDecimal price) {
        super(6, symbol, type, side, quantity, price);
    }

    // STATIQUE //

    /**
     * Produit un ordre d'achat MARKET
     *
     * @param symbol      La paire d'asset
     * @param quantity    La quantité
     * @param timeInForce La durée de vie de l'ordre
     */
    public static MarginOrder buyMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
        return new MarginOrder(symbol, OrderType.MARKET, OrderSide.BUY, quantity, timeInForce);
    }

    /**
     * Produit un ordre d'achat MARKET avec timeInForce par défaut
     */
    public static MarginOrder buyMarket(String symbol, BigDecimal quantity) {
        return buyMarket(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
    }

    /**
     * Produit un ordre de vent MARKET
     *
     * @param symbol      La paire d'asset
     * @param quantity    La quantité
     * @param timeInForce La durée de vie de l'ordre
     */
    public static MarginOrder sellMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
        return new MarginOrder(symbol, OrderType.MARKET, OrderSide.SELL, quantity, timeInForce);
    }

    /**
     * Produit un ordre de vent MARKET avec timeInForce par défaut
     */
    public static MarginOrder sellMarket(String symbol, BigDecimal quantity) {
        return buyMarket(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
    }

    /**
     * Produit un ordre d'achat LIMIT
     *
     * @param symbol      La paire d'asset
     * @param quantity    La quantité
     * @param price       Le prix d'achat
     * @param timeInForce La durée de vie de l'ordre
     */
    public static MarginOrder buyLimit(String symbol, BigDecimal quantity, BigDecimal price,
            TimeInForce timeInForce) {
        return new MarginOrder(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, timeInForce);
    }

    /**
     * Produit un ordre d'achat LIMIT avec timeInForce par défaut
     */
    public static MarginOrder buyLimit(String symbol, BigDecimal quantity, BigDecimal price) {
        return buyLimit(symbol, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
    }

    /**
     * Produit un ordre de vente LIMIT
     *
     * @param symbol      La paire d'asset
     * @param quantity    La quantité
     * @param price       Le prix de vente
     * @param timeInForce La durée de vie de l'ordre
     */
    public static MarginOrder sellLimit(String symbol, BigDecimal quantity, BigDecimal price,
            TimeInForce timeInForce) {
        return new MarginOrder(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, timeInForce);
    }

    /**
     * Produit un ordre de vente LIMIT avec timeInForce par défaut
     */
    public static MarginOrder sellLimit(String symbol, BigDecimal quantity, BigDecimal price) {
        return sellLimit(symbol, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
    }
}