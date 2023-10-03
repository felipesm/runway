package com.ifdeveloper.runway.repository;

import com.ifdeveloper.runway.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {

    File findByNameIgnoreCase(String name);
}
