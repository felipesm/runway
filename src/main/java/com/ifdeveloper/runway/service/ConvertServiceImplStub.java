package com.ifdeveloper.runway.service;

import org.springframework.context.annotation.Primary;

@Primary
public class ConvertServiceImplStub implements ConvertService {
    @Override
    public String fileConvert(String format) {
        System.out.println("TESTE 02");
        return "_." + format;
    }
}
