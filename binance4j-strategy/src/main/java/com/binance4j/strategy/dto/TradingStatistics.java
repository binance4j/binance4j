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
	private TradingRecord tradingRecord;
	/** The bar series. */
	private BarSeries series;
	/** The gross return. */
	private BigDecimal grossReturn;
	/** The gross profit. */
	private BigDecimal grossProfit;
	/** The gross loss. */
	private BigDecimal grossLoss;
	/** The average loss. */
	private BigDecimal averageLoss;
	/** The average profit. */
	private BigDecimal averageProfit;
	/** The average return per bar. */
	private BigDecimal averageReturnPerBar;
	/** The net loss. */
	private BigDecimal netLoss;
	/** The net profit. */
	private BigDecimal netProfit;
	/** The profit loss. */
	private BigDecimal profitLoss;
	/** The profit/loss percentage. */
	private BigDecimal profitLossPercentage;
	/** The profit/loss ratio. */
	private BigDecimal profitLossRatio;
	/** The buy and hold return. */
	private BigDecimal buyAndHoldReturn;
	/** The expectancy. */
	private BigDecimal expectancy;
	/** The percentage of positions which are not profitable. */
	private BigDecimal losingPositionsRatio;
	/** The maximum drawdown. */
	private BigDecimal maximumDrawdown;
	/** The number of bars. */
	private BigDecimal numberOfBars;
	/** The number of breakeven positions. */
	private BigDecimal numberOfBreakEvenPositions;
	/** The number of positions. */
	private BigDecimal numberOfPositions;
	/** The number of losing positions. */
	private BigDecimal numberOfLosingPositions;
	/** The number of winning positions. */
	private BigDecimal numberOfWinningPositions;
	/** The number of consecutive winning positions. */
	private BigDecimal numberOfConsecutiveWinningPositions;
	/** The return over max drawdown. */
	private BigDecimal returnOverMaxDrawdown;
	/** The winning positions ratio. */
	private BigDecimal winningPositionsRatio;

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
	private BigDecimal getCriterionResult(Class<? extends AbstractAnalysisCriterion> criterion) {
		try {
			return new BigDecimal(criterion.getConstructor().newInstance().calculate(series, tradingRecord).toString());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return the tradingRecord.
	 */
	public TradingRecord getTradingRecord() {
		return tradingRecord;
	}

	/**
	 * @param tradingRecord the tradingRecord to set.
	 */
	public void setTradingRecord(TradingRecord tradingRecord) {
		this.tradingRecord = tradingRecord;
	}

	/**
	 * @return the series.
	 */
	public BarSeries getSeries() {
		return series;
	}

	/**
	 * @param series the series to set.
	 */
	public void setSeries(BarSeries series) {
		this.series = series;
	}

	/**
	 * @return the grossReturn.
	 */
	public BigDecimal getGrossReturn() {
		return grossReturn;
	}

	/**
	 * @param grossReturn the grossReturn to set.
	 */
	public void setGrossReturn(BigDecimal grossReturn) {
		this.grossReturn = grossReturn;
	}

	/**
	 * @return the grossProfit.
	 */
	public BigDecimal getGrossProfit() {
		return grossProfit;
	}

	/**
	 * @param grossProfit the grossProfit to set.
	 */
	public void setGrossProfit(BigDecimal grossProfit) {
		this.grossProfit = grossProfit;
	}

	/**
	 * @return the grossLoss.
	 */
	public BigDecimal getGrossLoss() {
		return grossLoss;
	}

	/**
	 * @param grossLoss the grossLoss to set.
	 */
	public void setGrossLoss(BigDecimal grossLoss) {
		this.grossLoss = grossLoss;
	}

	/**
	 * @return the averageLoss.
	 */
	public BigDecimal getAverageLoss() {
		return averageLoss;
	}

	/**
	 * @param averageLoss the averageLoss to set.
	 */
	public void setAverageLoss(BigDecimal averageLoss) {
		this.averageLoss = averageLoss;
	}

	/**
	 * @return the averageProfit.
	 */
	public BigDecimal getAverageProfit() {
		return averageProfit;
	}

	/**
	 * @param averageProfit the averageProfit to set.
	 */
	public void setAverageProfit(BigDecimal averageProfit) {
		this.averageProfit = averageProfit;
	}

	/**
	 * @return the averageReturnPerBar.
	 */
	public BigDecimal getAverageReturnPerBar() {
		return averageReturnPerBar;
	}

	/**
	 * @param averageReturnPerBar the averageReturnPerBar to set.
	 */
	public void setAverageReturnPerBar(BigDecimal averageReturnPerBar) {
		this.averageReturnPerBar = averageReturnPerBar;
	}

	/**
	 * @return the netLoss.
	 */
	public BigDecimal getNetLoss() {
		return netLoss;
	}

	/**
	 * @param netLoss the netLoss to set.
	 */
	public void setNetLoss(BigDecimal netLoss) {
		this.netLoss = netLoss;
	}

	/**
	 * @return the netProfit.
	 */
	public BigDecimal getNetProfit() {
		return netProfit;
	}

	/**
	 * @param netProfit the netProfit to set.
	 */
	public void setNetProfit(BigDecimal netProfit) {
		this.netProfit = netProfit;
	}

	/**
	 * @return the profitLoss.
	 */
	public BigDecimal getProfitLoss() {
		return profitLoss;
	}

	/**
	 * @param profitLoss the profitLoss to set.
	 */
	public void setProfitLoss(BigDecimal profitLoss) {
		this.profitLoss = profitLoss;
	}

	/**
	 * @return the profitLossPercentage.
	 */
	public BigDecimal getProfitLossPercentage() {
		return profitLossPercentage;
	}

	/**
	 * @param profitLossPercentage the profitLossPercentage to set.
	 */
	public void setProfitLossPercentage(BigDecimal profitLossPercentage) {
		this.profitLossPercentage = profitLossPercentage;
	}

	/**
	 * @return the profitLossRatio.
	 */
	public BigDecimal getProfitLossRatio() {
		return profitLossRatio;
	}

	/**
	 * @param profitLossRatio the profitLossRatio to set.
	 */
	public void setProfitLossRatio(BigDecimal profitLossRatio) {
		this.profitLossRatio = profitLossRatio;
	}

	/**
	 * @return the buyAndHoldReturn.
	 */
	public BigDecimal getBuyAndHoldReturn() {
		return buyAndHoldReturn;
	}

	/**
	 * @param buyAndHoldReturn the buyAndHoldReturn to set.
	 */
	public void setBuyAndHoldReturn(BigDecimal buyAndHoldReturn) {
		this.buyAndHoldReturn = buyAndHoldReturn;
	}

	/**
	 * @return the expectancy.
	 */
	public BigDecimal getExpectancy() {
		return expectancy;
	}

	/**
	 * @param expectancy the expectancy to set.
	 */
	public void setExpectancy(BigDecimal expectancy) {
		this.expectancy = expectancy;
	}

	/**
	 * @return the losingPositionsRatio.
	 */
	public BigDecimal getLosingPositionsRatio() {
		return losingPositionsRatio;
	}

	/**
	 * @param losingPositionsRatio the losingPositionsRatio to set.
	 */
	public void setLosingPositionsRatio(BigDecimal losingPositionsRatio) {
		this.losingPositionsRatio = losingPositionsRatio;
	}

	/**
	 * @return the maximumDrawdown.
	 */
	public BigDecimal getMaximumDrawdown() {
		return maximumDrawdown;
	}

	/**
	 * @param maximumDrawdown the maximumDrawdown to set.
	 */
	public void setMaximumDrawdown(BigDecimal maximumDrawdown) {
		this.maximumDrawdown = maximumDrawdown;
	}

	/**
	 * @return the numberOfBars.
	 */
	public BigDecimal getNumberOfBars() {
		return numberOfBars;
	}

	/**
	 * @param numberOfBars the numberOfBars to set.
	 */
	public void setNumberOfBars(BigDecimal numberOfBars) {
		this.numberOfBars = numberOfBars;
	}

	/**
	 * @return the numberOfBreakEvenPositions.
	 */
	public BigDecimal getNumberOfBreakEvenPositions() {
		return numberOfBreakEvenPositions;
	}

	/**
	 * @param numberOfBreakEvenPositions the numberOfBreakEvenPositions to set.
	 */
	public void setNumberOfBreakEvenPositions(BigDecimal numberOfBreakEvenPositions) {
		this.numberOfBreakEvenPositions = numberOfBreakEvenPositions;
	}

	/**
	 * @return the numberOfPositions.
	 */
	public BigDecimal getNumberOfPositions() {
		return numberOfPositions;
	}

	/**
	 * @param numberOfPositions the numberOfPositions to set.
	 */
	public void setNumberOfPositions(BigDecimal numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	/**
	 * @return the numberOfLosingPositions.
	 */
	public BigDecimal getNumberOfLosingPositions() {
		return numberOfLosingPositions;
	}

	/**
	 * @param numberOfLosingPositions the numberOfLosingPositions to set.
	 */
	public void setNumberOfLosingPositions(BigDecimal numberOfLosingPositions) {
		this.numberOfLosingPositions = numberOfLosingPositions;
	}

	/**
	 * @return the numberOfWinningPositions.
	 */
	public BigDecimal getNumberOfWinningPositions() {
		return numberOfWinningPositions;
	}

	/**
	 * @param numberOfWinningPositions the numberOfWinningPositions to set.
	 */
	public void setNumberOfWinningPositions(BigDecimal numberOfWinningPositions) {
		this.numberOfWinningPositions = numberOfWinningPositions;
	}

	/**
	 * @return the numberOfConsecutiveWinningPositions.
	 */
	public BigDecimal getNumberOfConsecutiveWinningPositions() {
		return numberOfConsecutiveWinningPositions;
	}

	/**
	 * @param numberOfConsecutiveWinningPositions the numberOfConsecutiveWinningPositions to set.
	 */
	public void setNumberOfConsecutiveWinningPositions(BigDecimal numberOfConsecutiveWinningPositions) {
		this.numberOfConsecutiveWinningPositions = numberOfConsecutiveWinningPositions;
	}

	/**
	 * @return the returnOverMaxDrawdown.
	 */
	public BigDecimal getReturnOverMaxDrawdown() {
		return returnOverMaxDrawdown;
	}

	/**
	 * @param returnOverMaxDrawdown the returnOverMaxDrawdown to set.
	 */
	public void setReturnOverMaxDrawdown(BigDecimal returnOverMaxDrawdown) {
		this.returnOverMaxDrawdown = returnOverMaxDrawdown;
	}

	/**
	 * @return the winningPositionsRatio.
	 */
	public BigDecimal getWinningPositionsRatio() {
		return winningPositionsRatio;
	}

	/**
	 * @param winningPositionsRatio the winningPositionsRatio to set.
	 */
	public void setWinningPositionsRatio(BigDecimal winningPositionsRatio) {
		this.winningPositionsRatio = winningPositionsRatio;
	}

}
