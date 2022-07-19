package com.binance4j.core.pojo;

import java.util.ArrayList;
import java.util.List;

/** TODO JAVADOC */
public class NestedObject {
    private List<SubObject> subs = new ArrayList<>();

    /** @return the sub */.
    public List<SubObject> getSubs() {
        return subs;
    }

    /** @param sub the sub to set */.
    public void setSubs(List<SubObject> sub) {
        this.subs = sub;
    }
}
