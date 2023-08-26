package com.ifdeveloper.runway;

import com.ifdeveloper.runway.service.ConvertFileService;
import com.ifdeveloper.runway.service.ConvertServiceImplStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(ConvertServiceImplStub.class)
@SpringBootTest
public class StubIntegrationTest {

    @Autowired
    private ConvertFileService convertFileService;

    @Test
    public void convertFile() {
        String result = convertFileService.getFileConvert("txt");
        String expected = "_.txt";
        String log = String.format("result = %s | expected = %s", result, expected);
        System.out.println(log);
        Assertions.assertTrue(result.equals("_.txt"));
    }
}
