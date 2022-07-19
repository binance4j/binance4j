package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.binance4j.core.pojo.TestObject;
import com.binance4j.core.pojo.TestObject2;

public class BaseTestServiceTest extends CustomTest<Void> {

	List<String> list = List.of("hello", "world");
	TestObject obj1 = new TestObject("hello", null, null, null, null);
	TestObject obj2 = new TestObject("world", null, 0, list, null);

	protected BaseTestServiceTest() {
		super();
	}

	@Test
	void testGetProperties() {
		Map<String, Object> map = getProperties(obj1);
		assertEquals(map.size(), 5);
		assertEquals(map.get("longVal"), obj1.longVal());
		assertEquals(map.get("stringVal"), obj1.stringVal());
		assertEquals(map.get("intVal"), obj1.intVal());
		assertEquals(map.get("listVal"), obj1.listVal());
		assertEquals(map.get("objVal"), obj1.objVal());
	}

	@Test
	void testGetPropertiesOfList() {
		Map<String, Object> map = getProperties(List.of("hello", "world"));
		System.out.println(map);
	}

	@Test
	void testGetNullProperties() {
		Set<String> list = getNullProperties(obj2);
		System.out.println(list);
		assertEquals(2, list.size());
		assertTrue(list.containsAll(List.of("TestObject.longVal", "TestObject.objVal")));
	}

	@Test
	void testGetNullPropertiesOfList() {
		List<TestObject> obj = new ArrayList<>();
		obj.add(obj1);
		obj.add(obj2);
		Set<String> list = getNullProperties(obj);

		assertEquals(6, list.size());
		System.out.println(list);
		assertTrue(list.containsAll(List.of("ArrayList.[0].intVal", "ArrayList.[0].listVal", "ArrayList.[0].longVal", "ArrayList.[0].objVal",
				"ArrayList.[1].longVal", "ArrayList.[1].objVal")));
	}

	@Test
	void testGetNestedProperties() {
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add(null);

		var nulls = getNullProperties(new TestObject(null, 0L, 0, null, new TestObject("world", null, 0, list, new TestObject("world", 0L, null, list, null))));
		System.out.println(nulls);
	}

	@Test
	void testHasNoNullProperty() throws IntrospectionException {
		assertTrue(hasNoNullProperty(new TestObject2("", 0L, 0, List.of("ok"))));
	}

	@Test
	void testHasBeanProperties() {
		assertTrue(hasProperties(obj1));
	}

	@Test
	void testIsJava() {
		assertTrue(isJavaBean("test"));
		assertTrue(isJavaBean(new ArrayList<>()));
		assertTrue(isJavaBean(new HashMap<>()));
		assertFalse(isJavaBean(obj1));
	}
}
