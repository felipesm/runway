package com.ifdeveloper.runway;

import com.ifdeveloper.runway.service.ConvertFileService;
import com.ifdeveloper.runway.service.ConvertService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MockIntegrationTest {

    @Autowired
    private ConvertFileService convertFileService;

    @MockBean
    private ConvertService convertService;

    @Test
    public void convertFile() {
        Mockito.when(convertService.fileConvert("pdf")).thenReturn(".pdf");
        String expected = ".pdf";

        String result = convertFileService.getFileConvert("pdf");
        String log = String.format("result = %s | expected = %s", result, expected);
        System.out.println(log);
        Assertions.assertTrue(result.equals(".pdf"));
    }
}
