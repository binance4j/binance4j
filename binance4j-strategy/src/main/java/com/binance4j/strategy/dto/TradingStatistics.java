package com.binance4j.strategy.dto;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Trade;
import org.ta4j.core.TradingRecord;
import org.ta4j.core.analysis.criteria.AbstractAnalysisCriterion;
import org.ta4j.core.analysis.criteria.AverageReturnPerBarCriterion;
import org.ta4j.core.analysis.criteria.BuyAndHoldReturnCriterion;
import org.ta4j.core.analysis.criteria.ExpectancyCriterion;
import org.ta4j.core.analysis.criteria.ExpectedShortfallCriterion;
import org.ta4j.core.analysis.criteria.LinearTransactionCostCriterion;
import org.ta4j.core.analysis.criteria.LosingPositionsRatioCriterion;
import org.ta4j.core.analysis.criteria.MaximumDrawdownCriterion;
import org.ta4j.core.analysis.criteria.NumberOfBarsCriterion;
import org.ta4j.core.analysis.criteria.NumberOfBreakEvenPositionsCriterion;
import org.ta4j.core.analysis.criteria.NumberOfConsecutiveWinningPositionsCriterion;
import org.ta4j.core.analysis.criteria.NumberOfLosingPositionsCriterion;
import org.ta4j.core.analysis.criteria.NumberOfPositionsCriterion;
import org.ta4j.core.analysis.criteria.NumberOfWinningPositionsCriterion;
import org.ta4j.core.analysis.criteria.ReturnOverMaxDrawdownCriterion;
import org.ta4j.core.analysis.criteria.ValueAtRiskCriterion;
import org.ta4j.core.analysis.criteria.WinningPositionsRatioCriterion;
import org.ta4j.core.analysis.criteria.pnl.AverageLossCriterion;
import org.ta4j.core.analysis.criteria.pnl.AverageProfitCriterion;
import org.ta4j.core.analysis.criteria.pnl.GrossLossCriterion;
import org.ta4j.core.analysis.criteria.pnl.GrossProfitCriterion;
import org.ta4j.core.analysis.criteria.pnl.GrossReturnCriterion;
import org.ta4j.core.analysis.criteria.pnl.NetLossCriterion;
import org.ta4j.core.analysis.criteria.pnl.NetProfitCriterion;
import org.ta4j.core.analysis.criteria.pnl.ProfitLossCriterion;
import org.ta4j.core.analysis.criteria.pnl.ProfitLossPercentageCriterion;
import org.ta4j.core.analysis.criteria.pnl.ProfitLossRatioCriterion;

/** Statistics results of a trading backtest */
public class TradingStatistics {
	/** The trading record. */
	private final TradingRecord tradingRecord;
	/** The bar series. */
	private final BarSeries series;
	/** The gross return. */
	private final BigDecimal grossReturn;
	/** The gross profit. */
	private final BigDecimal grossProfit;
	/** The gross loss. */
	private final BigDecimal grossLoss;
	/** The average loss. */
	private final BigDecimal averageLoss;
	/** The average profit. */
	private final BigDecimal averageProfit;
	/** The average return per bar. */
	private final BigDecimal averageReturnPerBar;
	/** The net loss. */
	private final BigDecimal netLoss;
	/** The net profit. */
	private final BigDecimal netProfit;
	/** The profit loss. */
	private final BigDecimal profitLoss;
	/** The profit/loss percentage. */
	private final BigDecimal profitLossPercentage;
	/** The profit/loss ratio. */
	private final BigDecimal profitLossRatio;
	/** The buy and hold return. */
	private final BigDecimal buyAndHoldReturn;
	/** The expectancy. */
	private final BigDecimal expectancy;
	/** The percentage of positions which are not profitable. */
	private final BigDecimal losingPositionsRatio;
	/** The maximum drawdown. */
	private final BigDecimal maximumDrawdown;
	/** The number of bars. */
	private final BigDecimal numberOfBars;
	/** The number of breakeven positions. */
	private final BigDecimal numberOfBreakEvenPositions;
	/** The number of positions. */
	private final BigDecimal numberOfPositions;
	/** The number of losing positions. */
	private final BigDecimal numberOfLosingPositions;
	/** The number of winning positions. */
	private final BigDecimal numberOfWinningPositions;
	/** The number of consecutive winning positions. */
	private final BigDecimal numberOfConsecutiveWinningPositions;
	/** The return over max drawdown. */
	private final BigDecimal returnOverMaxDrawdown;
	/** The winning positions ratio. */
	private final BigDecimal winningPositionsRatio;

	/**
	 * @param tradingRecord The record generated by a backtest.
	 * @param series        The series the record is based on.
	 */
	public TradingStatistics(TradingRecord tradingRecord, BarSeries series) {
		this.tradingRecord = tradingRecord;
		this.series = series;

		grossReturn = getCriterionResult(GrossReturnCriterion.class);
		grossProfit = getCriterionResult(GrossProfitCriterion.class);
		grossLoss = getCriterionResult(GrossLossCriterion.class);
		averageLoss = getCriterionResult(AverageLossCriterion.class);
		averageProfit = getCriterionResult(AverageProfitCriterion.class);
		averageReturnPerBar = getCriterionResult(AverageReturnPerBarCriterion.class);
		netLoss = getCriterionResult(NetLossCriterion.class);
		netProfit = getCriterionResult(NetProfitCriterion.class);
		profitLoss = getCriterionResult(ProfitLossCriterion.class);
		profitLossPercentage = getCriterionResult(ProfitLossPercentageCriterion.class);
		profitLossRatio = getCriterionResult(ProfitLossRatioCriterion.class);
		buyAndHoldReturn = getCriterionResult(BuyAndHoldReturnCriterion.class);
		expectancy = getCriterionResult(ExpectancyCriterion.class);
		losingPositionsRatio = getCriterionResult(LosingPositionsRatioCriterion.class);
		maximumDrawdown = getCriterionResult(MaximumDrawdownCriterion.class);
		numberOfBars = getCriterionResult(NumberOfBarsCriterion.class);
		numberOfBreakEvenPositions = getCriterionResult(NumberOfBreakEvenPositionsCriterion.class);
		numberOfConsecutiveWinningPositions = getCriterionResult(NumberOfConsecutiveWinningPositionsCriterion.class);
		numberOfLosingPositions = getCriterionResult(NumberOfLosingPositionsCriterion.class);
		numberOfPositions = getCriterionResult(NumberOfPositionsCriterion.class);
		numberOfWinningPositions = getCriterionResult(NumberOfWinningPositionsCriterion.class);
		returnOverMaxDrawdown = getCriterionResult(ReturnOverMaxDrawdownCriterion.class);
		winningPositionsRatio = getCriterionResult(WinningPositionsRatioCriterion.class);
	}

	/**
	 * Calculates the expected short fall
	 *
	 * @param confidence the confidence level.
	 * @return The expected short fall.
	 */
	public BigDecimal getExpectedShortfall(double confidence) {
		return new BigDecimal(new ExpectedShortfallCriterion(confidence).calculate(series, tradingRecord).toString());
	}

	/**
	 * Calculates the linear transaction cost
	 *
	 * @param initialAmount the initially traded amount.
	 * @param a             the a coefficient (e.g. 0.005 for 0.5% per {@link Trade trade}).
	 * @return The linear transaction cost.
	 */
	public BigDecimal getLinearTransactionCost(double initialAmount, double a) {
		return new BigDecimal(new LinearTransactionCostCriterion(initialAmount, a).calculate(series, tradingRecord).toString());
	}

	/**
	 * Calculates the value at risk
	 *
	 * @param confidence the confidence level.
	 * @return The value at risk.
	 */
	public BigDecimal getValueAtRisk(double confidence) {
		return new BigDecimal(new ValueAtRiskCriterion(confidence).calculate(series, tradingRecord).toString());
	}

	/**
	 * calculates the given criterion result
	 *
	 * @param criterion The criterion to use for calculation.
	 * @return The criterion result.
	 */
	private final BigDecimal getCriterionResult(Class<? extends AbstractAnalysisCriterion> criterion) {
		try {
			return new BigDecimal(criterion.getConstructor().newInstance().calculate(series, tradingRecord).toString());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return the tradingRecord
	 */
	public TradingRecord getTradingRecord() {
		return tradingRecord;
	}

	/**
	 * @return the series
	 */
	public BarSeries getSeries() {
		return series;
	}

	/**
	 * @return the grossReturn
	 */
	public BigDecimal getGrossReturn() {
		return grossReturn;
	}

	/**
	 * @return the grossProfit
	 */
	public BigDecimal getGrossProfit() {
		return grossProfit;
	}

	/**
	 * @return the grossLoss
	 */
	public BigDecimal getGrossLoss() {
		return grossLoss;
	}

	/**
	 * @return the averageLoss
	 */
	public BigDecimal getAverageLoss() {
		return averageLoss;
	}

	/**
	 * @return the averageProfit
	 */
	public BigDecimal getAverageProfit() {
		return averageProfit;
	}

	/**
	 * @return the averageReturnPerBar
	 */
	public BigDecimal getAverageReturnPerBar() {
		return averageReturnPerBar;
	}

	/**
	 * @return the netLoss
	 */
	public BigDecimal getNetLoss() {
		return netLoss;
	}

	/**
	 * @return the netProfit
	 */
	public BigDecimal getNetProfit() {
		return netProfit;
	}

	/**
	 * @return the profitLoss
	 */
	public BigDecimal getProfitLoss() {
		return profitLoss;
	}

	/**
	 * @return the profitLossPercentage
	 */
	public BigDecimal getProfitLossPercentage() {
		return profitLossPercentage;
	}

	/**
	 * @return the profitLossRatio
	 */
	public BigDecimal getProfitLossRatio() {
		return profitLossRatio;
	}

	/**
	 * @return the buyAndHoldReturn
	 */
	public BigDecimal getBuyAndHoldReturn() {
		return buyAndHoldReturn;
	}

	/**
	 * @return the expectancy
	 */
	public BigDecimal getExpectancy() {
		return expectancy;
	}

	/**
	 * @return the losingPositionsRatio
	 */
	public BigDecimal getLosingPositionsRatio() {
		return losingPositionsRatio;
	}

	/**
	 * @return the maximumDrawdown
	 */
	public BigDecimal getMaximumDrawdown() {
		return maximumDrawdown;
	}

	/**
	 * @return the numberOfBars
	 */
	public BigDecimal getNumberOfBars() {
		return numberOfBars;
	}

	/**
	 * @return the numberOfBreakEvenPositions
	 */
	public BigDecimal getNumberOfBreakEvenPositions() {
		return numberOfBreakEvenPositions;
	}

	/**
	 * @return the numberOfPositions
	 */
	public BigDecimal getNumberOfPositions() {
		return numberOfPositions;
	}

	/**
	 * @return the numberOfLosingPositions
	 */
	public BigDecimal getNumberOfLosingPositions() {
		return numberOfLosingPositions;
	}

	/**
	 * @return the numberOfWinningPositions
	 */
	public BigDecimal getNumberOfWinningPositions() {
		return numberOfWinningPositions;
	}

	/**
	 * @return the numberOfConsecutiveWinningPositions
	 */
	public BigDecimal getNumberOfConsecutiveWinningPositions() {
		return numberOfConsecutiveWinningPositions;
	}

	/**
	 * @return the returnOverMaxDrawdown
	 */
	public BigDecimal getReturnOverMaxDrawdown() {
		return returnOverMaxDrawdown;
	}

	/**
	 * @return the winningPositionsRatio
	 */
	public BigDecimal getWinningPositionsRatio() {
		return winningPositionsRatio;
	}

}
