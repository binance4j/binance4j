package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FixedProjectSorting;
import com.binance4j.savings.dto.FixedProjectStatus;
import com.binance4j.savings.dto.FixedProjectType;

/** The {@link SavingsClient#getFixedProjects} params. */
public class FixedProjectListParams extends Params {
	/** Asset. */
	String asset;
	/** Project type. */
	FixedProjectType type;
	/** Project status. default: {@code START_TIME}. */
	FixedProjectStatus status;
	/** Sort ascending. Default: true. */
	boolean isSortAsc;
	/** Project sorting. */
	FixedProjectSorting sortBy;
	/** Current page. */
	Long current;
	/** Page size. */
	Long size;

	/**
	 * @param type Project type.
	 */
	public FixedProjectListParams(FixedProjectType type) {
		super(1);
		this.type = type;
	}

	/**
	 * @return the asset
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/**
	 * @return the type
	 */
	public FixedProjectType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(FixedProjectType type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public FixedProjectStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(FixedProjectStatus status) {
		this.status = status;
	}

	/**
	 * @return the isSortAsc
	 */
	public boolean isSortAsc() {
		return isSortAsc;
	}

	/**
	 * @param isSortAsc the isSortAsc to set
	 */
	public void setSortAsc(boolean isSortAsc) {
		this.isSortAsc = isSortAsc;
	}

	/**
	 * @return the sortBy
	 */
	public FixedProjectSorting getSortBy() {
		return sortBy;
	}

	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(FixedProjectSorting sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * @return the current
	 */
	public Long getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(Long current) {
		this.current = current;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

}
