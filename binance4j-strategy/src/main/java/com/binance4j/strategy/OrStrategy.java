package com.binance4j.strategy;

import org.ta4j.core.Rule;

/**
 * An {@link OperatorStrategy} on the OR operator
 */
public class OrStrategy extends OperatorStrategy {

    public OrStrategy(TradingStrategy... strategies) {
        super(strategies);
    }

    @Override
    protected Rule operate(Rule rule1, Rule rule2) {
        return rule1.or(rule2);
    }
}
