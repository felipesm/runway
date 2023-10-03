package com.ifdeveloper.runway;

import com.ifdeveloper.runway.models.File;
import com.ifdeveloper.runway.repository.FileRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class JDBCIntegrationTest {

    @Autowired
    private FileRepository fileRepository;


    @AfterEach
    public void cleanUp() {
        fileRepository.deleteAll();
    }

    @Test
    @Sql(statements = "insert into file (id, name, size) values ('40774', 'codes-products', 40034)")
    public void findByNameIgnoreCase() {
        var file = fileRepository.findByNameIgnoreCase("CODES-pRODuctS");
        Assertions.assertThat(file.getName()).isEqualTo("codes-products");
        Assertions.assertThat(file.getId()).isEqualTo("40774");
    }

    @Test
    @Sql(statements = "insert into file (id, name, size) values ('7635', 'list-objects', 97456)")
    @Sql(statements = "insert into file (id, name, size) values ('11455', 'code-promo', 201414)")
    @Sql(statements = "insert into file (id, name, size) values ('302', 'house-color-list', 5224)")
    public void findByNameOrderedByNameAsc() {
        var files = fileRepository.findAllByOrderByNameAsc();
        Assertions.assertThat(files).extracting(File::getName).containsExactly("code-promo", "house-color-list", "list-objects");
    }

}
