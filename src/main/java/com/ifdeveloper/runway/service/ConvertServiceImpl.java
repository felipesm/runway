package com.ifdeveloper.runway.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public String fileConvert(String format) {
        System.out.println("TESTE 01");
        return "." + format;
    }
}
