package com.binance4j.blvt;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.dto.FixedProjectType;
import com.binance4j.savings.param.FixedProjectListParams;

public class GetFixedandActivityProjects extends SavingsTest {

	@Test
	void test1() throws ApiException {
		testNoNulls(client.getFixedProjects(new FixedProjectListParams(FixedProjectType.CUSTOMIZED_FIXED)));
		testNoNulls(client.getFixedProjects(new FixedProjectListParams(FixedProjectType.ACTIVITY)));
	}
}
