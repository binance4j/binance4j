package com.binance4j.strategy;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Rule;

/**
 * A trading strategy where its entry and exit rules merge the given strategies
 * rules on a logical operator
 */
public abstract class OperatorStrategy implements TradingStrategy {
    protected TradingStrategy[] strategies;

    @Override
    public Rule entry(BarSeries series) {
        return handleRule(getEntries(series).reduce(this::operate));
    }

    @Override
    public Rule exit(BarSeries series) {
        return handleRule(getExits(series).reduce(this::operate));
    }

    /**
     * Constructor
     * 
     * @param strategies The strategies to merge the rules
     */
    protected OperatorStrategy(TradingStrategy... strategies) {
        this.strategies = strategies;
    }

    /**
     * Returns a stream of all the given strategies entry rules
     * 
     * @param series The series to produce the rules
     * @return A stream of all the produced rules
     */
    protected Stream<Rule> getEntries(BarSeries series) {
        return Arrays.asList(strategies).stream().map(s -> s.entry(series));
    }

    /**
     * Returns a stream of all the given strategies exit rules
     * 
     * @param series The series to produce the rules
     * @return A stream of all the produced rules
     */
    protected Stream<Rule> getExits(BarSeries series) {
        return Arrays.asList(strategies).stream().map(s -> s.exit(series));
    }

    /**
     * Returns the optional rule or null
     * 
     * @param rule the optional rule
     * @return the rule or null
     */
    protected Rule handleRule(Optional<Rule> rule) {
        return rule.isPresent() ? rule.get() : null;
    }

    /**
     * The operation on the reducer
     * 
     * @param rule1 The current rule
     * @param rule2 The accumulated rule
     * @return The final rule made of all the others
     */
    protected abstract Rule operate(Rule rule1, Rule rule2);
}
