package com.ifdeveloper.runway.controller;

import com.ifdeveloper.runway.models.File;
import com.ifdeveloper.runway.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public File getFile() {
        return fileRepository.findFirstByOrderByIdDesc();
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public File saveFile(@RequestBody File file) {
        return fileRepository.save(file);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping
    public void putFile(@RequestBody File file) {
        fileRepository.save(file);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable String id) {
        fileRepository.deleteById(id);
    }
}
