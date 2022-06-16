package com.binance4j.strategy;

import org.ta4j.core.Rule;

/**
 * An {@link OperatorStrategy} on the AND operator
 */
public class AndStrategy extends OperatorStrategy {

    public AndStrategy(TradingStrategy... strategies) {
        super(strategies);
    }

    @Override
    protected Rule operate(Rule rule1, Rule rule2) {
        return rule1.and(rule2);
    }
}
