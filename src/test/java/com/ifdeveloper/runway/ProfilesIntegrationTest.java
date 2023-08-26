package com.ifdeveloper.runway;

import com.ifdeveloper.runway.config.EnvironmentConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProfilesIntegrationTest {

    @Autowired
    private EnvironmentConfig environmentConfig;

    @Test
    void test() {
        environmentConfig.writeFile();
    }
}
