package com.ifdeveloper.runway.service;

import org.springframework.stereotype.Service;

@Service
public class CopyService {

    public Boolean copyFiles() {
        System.out.println("Copying files");
        return true;
    }
}
