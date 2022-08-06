package com.binance4j.core.pojo;

import java.util.ArrayList;
import java.util.List;

public class SubObject {
	List<SubSubObject> subSubObjects = new ArrayList<>();

	/** @return the subSubObjects */
	public List<SubSubObject> getSubSubObjects() {
		return subSubObjects;
	}

	/** @param subSubObjects SubSubObjects to set */
	public void setSubSubObjects(List<SubSubObject> subSubObjects) {
		this.subSubObjects = subSubObjects;
	}
}
