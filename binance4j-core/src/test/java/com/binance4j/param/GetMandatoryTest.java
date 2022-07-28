package com.binance4j.param;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;

public class GetMandatoryTest {

	@Test
	@DisplayName("Params must return the fields annotated with @Mandatory")
	void testMandatory() {
		var params = new TestParams();

		List<String> fieldsName = params.getMandatoryFields().stream().map(Field::getName).toList();

		assertTrue(fieldsName.contains("foo"));
	}

	public class TestParams extends Params {
		@Mandatory
		String foo;
		String bar;
	}
}
