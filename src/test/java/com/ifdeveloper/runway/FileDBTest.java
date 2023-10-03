package com.ifdeveloper.runway;

import com.ifdeveloper.runway.models.File;
import com.ifdeveloper.runway.repository.FileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class FileDBTest {

    @Autowired
    private FileRepository fileRepository;

    @AfterEach
    public void cleanUp() {
        fileRepository.deleteAll();
    }

    @Test
    public void testDataSource() {
        var file = fileRepository.save(new File("1234", "zipcode", 1093L));
        var fileFound = fileRepository.findById(file.getId()).get();

        Assertions.assertNotNull(fileFound);
        Assertions.assertEquals(file.getId(), fileFound.getId());
    }

    @Test
    @Sql(scripts = {"classpath:insert_01.sql"})
    @Sql(statements = "insert into file (id, name, size) values ('4089', 'prices-table', 10238)")
    public void insertFiles() {
        var files = fileRepository.findAll();
        Assertions.assertEquals(4, files.size());
    }

    @Test
    @Sql(value = "/delete_table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into file (id, name, size) values ('60357', 'shirts-table', 30587)")
    public void insertFile() {
        var files = fileRepository.findAll();
        Assertions.assertEquals(1, files.size());
    }
}
