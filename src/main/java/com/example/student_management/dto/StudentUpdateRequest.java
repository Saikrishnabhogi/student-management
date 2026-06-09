package com.example.student_management.dto;

public class StudentUpdateRequest {
     private String name;
     private String email;

     public String getName(){
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
