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

import lombok.Data;
import lombok.ToString;

/**
 * Statistics results of a trading backtest
 */
@Data
public class TradingStatistics {
	/** The trading record */
	@ToString.Exclude
	private TradingRecord tradingRecord;
	/** The bar series */
	@ToString.Exclude
	private BarSeries series;
	/** The gross return */
	private BigDecimal grossReturn;
	/** The gross profit */
	private BigDecimal grossProfit;
	/** The gross loss */
	private BigDecimal grossLoss;
	/** The average loss */
	private BigDecimal averageLoss;
	/** The average profit */
	private BigDecimal averageProfit;
	/** The average return per bar */
	private BigDecimal averageReturnPerBar;
	/** The net loss */
	private BigDecimal netLoss;
	/** The net profit */
	private BigDecimal netProfit;
	/** The profit loss */
	private BigDecimal profitLoss;
	/** The profit/loss percentage */
	private BigDecimal profitLossPercentage;
	/** The profit/loss ratio */
	private BigDecimal profitLossRatio;
	/** The buy and hold return */
	private BigDecimal buyAndHoldReturn;
	/** The expectancy */
	private BigDecimal expectancy;
	/** The percentage of positions which are not profitable. */
	private BigDecimal losingPositionsRatio;
	/** The maximum drawdown */
	private BigDecimal maximumDrawdown;
	/** The number of bars */
	private BigDecimal numberOfBars;
	/** The number of breakeven positions */
	private BigDecimal numberOfBreakEvenPositions;
	/** The number of positions */
	private BigDecimal numberOfPositions;
	/** The number of losing positions */
	private BigDecimal numberOfLosingPositions;
	/** The number of winning positions */
	private BigDecimal numberOfWinningPositions;
	/** The number of consecutive winning positions */
	private BigDecimal numberOfConsecutiveWinningPositions;
	/** The return over max drawdown */
	private BigDecimal returnOverMaxDrawdown;
	/** The winning positions ratio */
	private BigDecimal winningPositionsRatio;

	/**
	 *
	 * 
	 * @param tradingRecord The record generated by a backtest
	 * @param series        The series the record is based on
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
	 * @param confidence the confidence level
	 * @return The expected short fall
	 */
	public BigDecimal getExpectedShortfall(double confidence) {
		return new BigDecimal(
				new ExpectedShortfallCriterion(confidence).calculate(series, tradingRecord).toString());
	}

	/**
	 * Calculates the linear transaction cost
	 *
	 * @param initialAmount the initially traded amount
	 * @param a             the a coefficient (e.g. 0.005 for 0.5% per {@link Trade
	 *                      trade})
	 * @return The linear transaction cost
	 */
	public BigDecimal getLinearTransactionCost(double initialAmount, double a) {
		return new BigDecimal(
				new LinearTransactionCostCriterion(initialAmount, a).calculate(series, tradingRecord).toString());
	}

	/**
	 * Calculates the value at risk
	 *
	 * @param confidence the confidence level
	 * @return The value at risk
	 */
	public BigDecimal getValueAtRisk(double confidence) {
		return new BigDecimal(
				new ValueAtRiskCriterion(confidence).calculate(series, tradingRecord).toString());
	}

	/**
	 * calculates the given criterion result
	 *
	 * @param criterion The criterion to use for calculation
	 * @return The criterion result
	 */
	private BigDecimal getCriterionResult(Class<? extends AbstractAnalysisCriterion> criterion) {
		try {
			return new BigDecimal(criterion.getConstructor().newInstance().calculate(series, tradingRecord).toString());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
