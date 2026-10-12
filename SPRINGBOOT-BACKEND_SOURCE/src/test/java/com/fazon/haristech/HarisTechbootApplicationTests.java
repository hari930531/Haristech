package com.fazon.haristech;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HarisTechbootApplicationTests {

	@Test
	@Disabled("Skipping test in CI environment due to missing DB")
	void contextLoads() {
	}

}