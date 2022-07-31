package com.binance4j.savings.dto;

import com.binance4j.core.param.Params;
import com.binance4j.savings.param.FixedProjectListParams;

/**
 * {@link FixedProjectListParams} sorting.
 * 
 * @param sortBy    Project sorting.
 * @param isSortAsc Sort ascending. Default: true.
 */
public record Sorting(FixedProjectSorting sortBy, Boolean isSortAsc) implements Params {

	/**
	 * Creates an instance of {@link Sorting}.
	 * 
	 * @param sortBy Project sorting.
	 */
	public Sorting(FixedProjectSorting sortBy) {
		this(sortBy, null);
	}

	/**
	 * Creates an instance of {@link Sorting}.
	 * 
	 * @param isSortAsc Sort ascending. Default: true.
	 */
	public Sorting(Boolean isSortAsc) {
		this(null, isSortAsc);
	}

}
