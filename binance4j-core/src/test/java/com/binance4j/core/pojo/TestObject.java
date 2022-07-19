package com.binance4j.core.pojo;

import java.util.List;

public record TestObject(String stringVal, Long longVal, Integer intVal, List<String> listVal, TestObject objVal) {
}
