package com.ifdeveloper.runway.repository;

import com.ifdeveloper.runway.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, String> {

    File findFirstByOrderByIdDesc();

    File findByNameIgnoreCase(String name);

    List<File> findAllByOrderByNameAsc();
}
