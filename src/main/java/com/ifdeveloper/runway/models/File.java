package com.ifdeveloper.runway.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class File {

    @Id
    private String id;

    private String name;

    private Long size;

    public File() {}

    public File(String id, String name, Long size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
