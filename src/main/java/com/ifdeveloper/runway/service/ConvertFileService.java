package com.ifdeveloper.runway.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertFileService {

    private ConvertService convertService;

    public ConvertFileService(ConvertService convertService) {
        this.convertService = convertService;
    }

    public String getFileConvert(String format) {
        return convertService.fileConvert(format);
    }
}
