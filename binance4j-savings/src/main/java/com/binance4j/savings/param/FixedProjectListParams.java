package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FixedProjectStatus;
import com.binance4j.savings.dto.FixedProjectType;

/**
 * {@link SavingsClient#getFixedProjects} params.
 * 
 * @param type   Project type.
 * @param asset  Asset.
 * @param status Project status. default: {@code START_TIME}.
 */
public record FixedProjectListParams(@Mandatory FixedProjectType type, String asset, FixedProjectStatus status) implements Params {
	/**
	 * Creates an instance of {@link FixedProjectListParams}.
	 * 
	 * @param type Project type.
	 */
	public FixedProjectListParams(FixedProjectType type) {
		this(type, null, null);
	}

	/**
	 * Creates an instance of {@link FixedProjectListParams}.
	 * 
	 * @param type  Project type.
	 * @param asset Asset.
	 */
	public FixedProjectListParams(FixedProjectType type, String asset) {
		this(type, asset, null);
	}

	/**
	 * Creates an instance of {@link FixedProjectListParams}.
	 * 
	 * @param type   Project type.
	 * @param status Project status.
	 */
	public FixedProjectListParams(FixedProjectType type, FixedProjectStatus status) {
		this(type, null, status);
	}
}