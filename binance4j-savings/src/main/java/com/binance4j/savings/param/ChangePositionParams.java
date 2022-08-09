package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * {@link SavingsClient#fixedToDailyPosition} params.
 * 
 * @param projectId  Project id.
 * @param lot        Lot size.
 * @param positionId Position id for fixed position.
 */
@Param
public record ChangePositionParams(String projectId, Long lot, Long positionId) implements Params {
	/**
	 * Creates an instance of {@link ChangePositionParams}
	 * 
	 * @param projectId Project id.
	 * @param lot       Lot size.
	 */
	public ChangePositionParams(String projectId, Long lot) {
		this(projectId, lot, null);
	}
}
