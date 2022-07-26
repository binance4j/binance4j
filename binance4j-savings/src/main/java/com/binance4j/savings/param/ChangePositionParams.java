package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/** The {@link SavingsClient#fixedToDailyPosition} params. */
public class ChangePositionParams extends Params {
	/** Project id. */
	String projectId;
	/** Lot. */
	Long lot;
	/** Position id for fixed position. */
	Long positionId;

	/**
	 * @param projectId The project id.
	 */
	public ChangePositionParams(String projectId) {
		super(1);
		this.projectId = projectId;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the lot
	 */
	public Long getLot() {
		return lot;
	}

	/**
	 * @param lot the lot to set
	 */
	public void setLot(Long lot) {
		this.lot = lot;
	}

	/**
	 * @return the positionId
	 */
	public Long getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId the positionId to set
	 */
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

}
