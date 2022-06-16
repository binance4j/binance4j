package com.binance4j.strategy;

import org.ta4j.core.Rule;

/**
 * An {@link OperatorStrategy} on the XOR operator
 */
public class XorStrategy extends OperatorStrategy {

    public XorStrategy(TradingStrategy... strategies) {
        super(strategies);
    }

    @Override
    protected Rule operate(Rule rule1, Rule rule2) {
        return rule1.xor(rule2);
    }
}
