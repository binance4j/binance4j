package com.binance4j.savings.dto;

import com.binance4j.core.param.Params;
import com.binance4j.savings.param.FixedProjectListParams;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link FixedProjectListParams} sorting.
 * 
 * @param sortBy    Project sorting.
 * @param isSortAsc Sort ascending. Default: true.
 */
@ApiModel("Sorting.")
public record Sorting(@ApiModelProperty("Project sorting.") String sortBy, @ApiModelProperty("Sort ascending. Default: true.") Boolean isSortAsc)
		implements Params {

	/**
	 * Creates an instance of {@link Sorting}.
	 * 
	 * @param sortBy    Project sorting.
	 * @param isSortAsc Sort ascending. Default: true.
	 */
	public Sorting(FixedProjectSorting sortBy, Boolean isSortAsc) {
		this(sortBy.toString(), null);
	}

	/**
	 * Creates an instance of {@link Sorting}.
	 * 
	 * @param sortBy Project sorting.
	 */
	public Sorting(FixedProjectSorting sortBy) {
		this(sortBy.toString(), null);
	}

	/**
	 * Creates an instance of {@link Sorting}.
	 * 
	 * @param isSortAsc Sort ascending. Default: true.
	 */
	public Sorting(Boolean isSortAsc) {
		this((String) null, isSortAsc);
	}
}
