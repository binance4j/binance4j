package com.binance4j.core.pojo;

import java.util.ArrayList;
import java.util.List;

/** TODO JAVADOC */
public class SubObject {
    private List<SubSubObject> subSubObjects = new ArrayList<>();

    /** @return the subSubObjects */
    public List<SubSubObject> getSubSubObjects() {
        return subSubObjects;
    }

    /** @param subSubObjects the subSubObjects to set */
    public void setSubSubObjects(List<SubSubObject> subSubObjects) {
        this.subSubObjects = subSubObjects;
    }
}
