package com.ifdeveloper.runway.config;

public class EnvironmentConfig {

    private String fileName;

    public EnvironmentConfig(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile() {
        System.out.println("Writing file " + fileName);
    }
}
