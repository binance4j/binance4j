package com.binance4j.savings.dto;

import com.binance4j.core.param.Params;
import com.binance4j.savings.param.FixedProjectListParams;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link FixedProjectListParams} sorting.
 * 
 * @property sortBy    Project sorting.
 * @property isSortAsc Sort ascending. Default: true.
 */
@ApiModel("Sorting.")
data class Sorting(@ApiModelProperty("Project sorting.")
var sortBy:String?=null,
@ApiModelProperty("Sort ascending. Default: true.")
Boolean isSortAsc):Params
{

	/**
	 * Creates an instance of {@link Sorting}.
	 * 
	 * @property sortBy Project sorting.
	 * @property isSortAsc Sort ascending. Default: true.
	 */
	public Sorting(FixedProjectSorting sortBy, Boolean isSortAsc) {
		this(sortBy == null ? null : sortBy.toString(), null);
	}

	/**
	 * Creates an instance of {@link Sorting}.
	 * 
	 * @property sortBy Project sorting.
	 */
	public Sorting(FixedProjectSorting sortBy) {
		this(sortBy == null ? null : sortBy.toString(), null);
	}

	/**
	 * Creates an instance of {@link Sorting}.
	 * 
	 * @property isSortAsc Sort ascending. Default: true.
	 */
	public Sorting(Boolean isSortAsc) {
		this((String) null, isSortAsc);
	}
}
