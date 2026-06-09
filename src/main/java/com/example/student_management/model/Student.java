package com.example.student_management.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Student {
    @NotNull(message = "Id is required")
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Email is required")
    private String email;

    public Student(Long id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
