package com.ifdeveloper.runway;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class IntegrationDBTest {

    @Test
    void test() {
        Assertions.assertTrue(true);
    }
}
