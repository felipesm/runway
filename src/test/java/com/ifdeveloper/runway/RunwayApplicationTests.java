package com.ifdeveloper.runway;

import com.ifdeveloper.runway.service.CopyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class RunwayApplicationTests {

	@Autowired
	private CopyService copyService;

	@DisplayName("Test Copying files")
	@Test
	void contextLoads() {
		var result = copyService.copyFiles();
		assertTrue("Valid", result);
	}

}
