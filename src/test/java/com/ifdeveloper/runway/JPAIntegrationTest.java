package com.ifdeveloper.runway;

import com.ifdeveloper.runway.models.File;
import com.ifdeveloper.runway.repository.FileRepository;
import jakarta.validation.ConstraintViolationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.TransactionSystemException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class JPAIntegrationTest {

    @Autowired
    private FileRepository fileRepository;

    @AfterEach
    public void clean() {
        fileRepository.deleteAll();
    }

    @Test
    @Sql(statements = "insert into file (id, name, size) values ('3052', 'codes-table', 1022)")
    public void findByNameIgnoreCase() {
        File file = fileRepository.findByNameIgnoreCase("CODES-TABLE");
        Assertions.assertThat(file.getName()).isEqualTo("codes-table");
        Assertions.assertThat(file.getSize()).isEqualTo(1022L);
    }

    @Test
    public void saveFileWithNameNullThrowsAnException() {
        File file = new File("03041", null, 30204L);

        var exception = assertThrows(TransactionSystemException.class, () -> {
            fileRepository.save(file);
        });

        Assertions.assertThat(exception.getCause()).hasCauseInstanceOf(ConstraintViolationException.class);
    }

}
