package com.binance4j.strategy.dto;

import java.lang.reflect.InvocationTargetException;

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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Statistics results of a trading backtest. */
@ApiModel("Statistics results of a trading backtest.")
public class TradingStatistics {
	/** The trading record. */
	@ApiModelProperty("The trading record.")
	final TradingRecord tradingRecord;
	/** The bar series. */
	@ApiModelProperty("The bar series.")
	final BarSeries series;
	/** The gross return. */
	@ApiModelProperty("The gross return.")
	final String grossReturn;
	/** The gross profit. */
	@ApiModelProperty("The gross profit.")
	final String grossProfit;
	/** The gross loss. */
	@ApiModelProperty("The gross loss.")
	final String grossLoss;
	/** The average loss. */
	@ApiModelProperty("The average loss.")
	final String averageLoss;
	/** The average profit. */
	@ApiModelProperty("The average profit.")
	final String averageProfit;
	/** The average return per bar. */
	@ApiModelProperty("The average return per bar.")
	final String averageReturnPerBar;
	/** The net loss. */
	@ApiModelProperty("The net loss.")
	final String netLoss;
	/** The net profit. */
	@ApiModelProperty("The net profit.")
	final String netProfit;
	/** The profit loss. */
	@ApiModelProperty("The profit loss.")
	final String profitLoss;
	/** The profit/loss percentage. */
	@ApiModelProperty("The profit/loss percentage.")
	final String profitLossPercentage;
	/** The profit/loss ratio. */
	@ApiModelProperty("The profit/loss ratio.")
	final String profitLossRatio;
	/** The buy and hold return. */
	@ApiModelProperty("The buy and hold return.")
	final String buyAndHoldReturn;
	/** The expectancy. */
	@ApiModelProperty("The expectancy.")
	final String expectancy;
	/** The percentage of positions which are not profitable. */
	@ApiModelProperty("The percentage of positions which are not profitable.")
	final String losingPositionsRatio;
	/** The maximum drawdown. */
	@ApiModelProperty("The maximum drawdown.")
	final String maximumDrawdown;
	/** The number of bars. */
	@ApiModelProperty("The number of bars.")
	final String numberOfBars;
	/** The number of breakeven positions. */
	@ApiModelProperty("The number of breakeven positions.")
	final String numberOfBreakEvenPositions;
	/** The number of positions. */
	@ApiModelProperty("The number of positions.")
	final String numberOfPositions;
	/** The number of losing positions. */
	@ApiModelProperty("The number of losing positions.")
	final String numberOfLosingPositions;
	/** The number of winning positions. */
	@ApiModelProperty("The number of winning positions.")
	final String numberOfWinningPositions;
	/** The number of consecutive winning positions. */
	@ApiModelProperty("The number of consecutive winning positions.")
	final String numberOfConsecutiveWinningPositions;
	/** The return over max drawdown. */
	@ApiModelProperty("The return over max drawdown.")
	final String returnOverMaxDrawdown;
	/** The winning positions ratio. */
	@ApiModelProperty("The winning positions ratio.")
	final String winningPositionsRatio;

	/**
	 * @param tradingRecord Record generated by a backtest.
	 * @param series        Series the record is based on.
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
	 * @param confidence Confidence level.
	 * @return The expected short fall.
	 */
	public String getExpectedShortfall(double confidence) {
		return new ExpectedShortfallCriterion(confidence).calculate(series, tradingRecord).toString();
	}

	/**
	 * Calculates the linear transaction cost
	 *
	 * @param initialAmount Initially traded amount.
	 * @param a             A coefficient (e.g. 0.005 for 0.5% per {@link Trade trade}).
	 * @return The linear transaction cost.
	 */
	public String getLinearTransactionCost(double initialAmount, double a) {
		return new LinearTransactionCostCriterion(initialAmount, a).calculate(series, tradingRecord).toString();
	}

	/**
	 * Calculates the value at risk
	 *
	 * @param confidence Confidence level.
	 * @return The value at risk.
	 */
	public String getValueAtRisk(double confidence) {
		return new ValueAtRiskCriterion(confidence).calculate(series, tradingRecord).toString();
	}

	/**
	 * calculates the given criterion result
	 *
	 * @param criterion Criterion to use for calculation.
	 * @return The criterion result.
	 */
	private final String getCriterionResult(Class<? extends AbstractAnalysisCriterion> criterion) {
		try {
			return criterion.getConstructor().newInstance().calculate(series, tradingRecord).toString();
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
	public String getGrossReturn() {
		return grossReturn;
	}

	/**
	 * @return the grossProfit
	 */
	public String getGrossProfit() {
		return grossProfit;
	}

	/**
	 * @return the grossLoss
	 */
	public String getGrossLoss() {
		return grossLoss;
	}

	/**
	 * @return the averageLoss
	 */
	public String getAverageLoss() {
		return averageLoss;
	}

	/**
	 * @return the averageProfit
	 */
	public String getAverageProfit() {
		return averageProfit;
	}

	/**
	 * @return the averageReturnPerBar
	 */
	public String getAverageReturnPerBar() {
		return averageReturnPerBar;
	}

	/**
	 * @return the netLoss
	 */
	public String getNetLoss() {
		return netLoss;
	}

	/**
	 * @return the netProfit
	 */
	public String getNetProfit() {
		return netProfit;
	}

	/**
	 * @return the profitLoss
	 */
	public String getProfitLoss() {
		return profitLoss;
	}

	/**
	 * @return the profitLossPercentage
	 */
	public String getProfitLossPercentage() {
		return profitLossPercentage;
	}

	/**
	 * @return the profitLossRatio
	 */
	public String getProfitLossRatio() {
		return profitLossRatio;
	}

	/**
	 * @return the buyAndHoldReturn
	 */
	public String getBuyAndHoldReturn() {
		return buyAndHoldReturn;
	}

	/**
	 * @return the expectancy
	 */
	public String getExpectancy() {
		return expectancy;
	}

	/**
	 * @return the losingPositionsRatio
	 */
	public String getLosingPositionsRatio() {
		return losingPositionsRatio;
	}

	/**
	 * @return the maximumDrawdown
	 */
	public String getMaximumDrawdown() {
		return maximumDrawdown;
	}

	/**
	 * @return the numberOfBars
	 */
	public String getNumberOfBars() {
		return numberOfBars;
	}

	/**
	 * @return the numberOfBreakEvenPositions
	 */
	public String getNumberOfBreakEvenPositions() {
		return numberOfBreakEvenPositions;
	}

	/**
	 * @return the numberOfPositions
	 */
	public String getNumberOfPositions() {
		return numberOfPositions;
	}

	/**
	 * @return the numberOfLosingPositions
	 */
	public String getNumberOfLosingPositions() {
		return numberOfLosingPositions;
	}

	/**
	 * @return the numberOfWinningPositions
	 */
	public String getNumberOfWinningPositions() {
		return numberOfWinningPositions;
	}

	/**
	 * @return the numberOfConsecutiveWinningPositions
	 */
	public String getNumberOfConsecutiveWinningPositions() {
		return numberOfConsecutiveWinningPositions;
	}

	/**
	 * @return the returnOverMaxDrawdown
	 */
	public String getReturnOverMaxDrawdown() {
		return returnOverMaxDrawdown;
	}

	/**
	 * @return the winningPositionsRatio
	 */
	public String getWinningPositionsRatio() {
		return winningPositionsRatio;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "TradingStatistics [averageLoss=" + averageLoss + ", averageProfit=" + averageProfit + ", averageReturnPerBar=" + averageReturnPerBar
				+ ", buyAndHoldReturn=" + buyAndHoldReturn + ", expectancy=" + expectancy + ", grossLoss=" + grossLoss + ", grossProfit=" + grossProfit
				+ ", grossReturn=" + grossReturn + ", losingPositionsRatio=" + losingPositionsRatio + ", maximumDrawdown=" + maximumDrawdown + ", netLoss="
				+ netLoss + ", netProfit=" + netProfit + ", numberOfBars=" + numberOfBars + ", numberOfBreakEvenPositions=" + numberOfBreakEvenPositions
				+ ", numberOfConsecutiveWinningPositions=" + numberOfConsecutiveWinningPositions + ", numberOfLosingPositions=" + numberOfLosingPositions
				+ ", numberOfPositions=" + numberOfPositions + ", numberOfWinningPositions=" + numberOfWinningPositions + ", profitLoss=" + profitLoss
				+ ", profitLossPercentage=" + profitLossPercentage + ", profitLossRatio=" + profitLossRatio + ", returnOverMaxDrawdown=" + returnOverMaxDrawdown
				+ ", series=" + series + ", tradingRecord=" + tradingRecord + ", winningPositionsRatio=" + winningPositionsRatio + "]";
	}

}
