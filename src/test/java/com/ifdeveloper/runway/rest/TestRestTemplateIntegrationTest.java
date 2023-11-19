package com.ifdeveloper.runway.rest;

import com.ifdeveloper.runway.models.File;
import com.ifdeveloper.runway.repository.FileRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestTemplateIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private FileRepository fileRepository;

    @AfterEach
    public void clean() {
        fileRepository.deleteAll();
    }

    @Test
    @Sql(statements = "insert into file (id, name, size) values ('996563', 'list-pokemon', 334475)")
    public void getTest() throws URISyntaxException {
        ResponseEntity<File> responseEntity = testRestTemplate.getForEntity(new URI("/"), File.class);
        Assertions.assertThat(responseEntity.getBody().getName()).isEqualTo("list-pokemon");
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        File responseObject = testRestTemplate.getForObject("/", File.class);
        Assertions.assertThat(responseObject.getName()).isEqualTo("list-pokemon");
    }

    @Test
    public void postTest() {
        ResponseEntity<File> responseEntity = testRestTemplate.postForEntity("/", new File("102458", "list-games", 89310L), File.class);
        Assertions.assertThat(responseEntity.getBody().getName()).isEqualTo("list-games");
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        File response = testRestTemplate.postForObject("/", new File("0483910", "list-objects", 775930L), File.class);
        Assertions.assertThat(response.getName()).isEqualTo("list-objects");
    }

    @Test
    @Sql(statements = "insert into file (id, name, size) values ('109392', 'list-ect', 22003)")
    public void putTest() {
        testRestTemplate.put("/", new File("109392", "list-certificates", 22003L));
        var file = fileRepository.findById("109392");
        Assertions.assertThat(file.get().getName()).isEqualTo("list-certificates");
    }

    @Test
    @Sql(statements = "insert into file (id, name, size) values ('340', 'list-streamers', 302934)")
    @Sql(statements = "insert into file (id, name, size) values ('4993', 'list-stores', 437674)")
    @Sql(statements = "insert into file (id, name, size) values ('49583', 'list-juices', 10039)")
    public void deleteTest() {
        testRestTemplate.delete("/{id}", 4993);
        var count = fileRepository.count();
        Assertions.assertThat(count).isEqualTo(2);
    }
}
