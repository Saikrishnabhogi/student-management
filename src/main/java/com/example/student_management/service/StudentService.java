package com.example.student_management.service;

import com.example.student_management.dto.StudentRequest;
import com.example.student_management.dto.StudentResponse;
import com.example.student_management.dto.StudentUpdateRequest;
import com.example.student_management.exception.StudentNotFoundException;
import com.example.student_management.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students= new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public StudentResponse addStudent(StudentRequest request) {

        Student student = new Student(
                (long) (students.size() + 1),
                request.getName(),
                request.getEmail()
        );

        students.add(student);

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }

    public Student getStudent(Long id){
        for(Student student: students ){
            if(student.getId()==id){
                return student;
            }
        }
        throw new StudentNotFoundException(
                "Student Not found Id:"+id
        );
    }

    public Student updateStudent(Long id, StudentUpdateRequest request){
        for(Student student: students){
            if(student.getId()==id){
                student.setName(request.getName());
                student.setEmail(request.getEmail());
                return student;
            }
        }
        throw new StudentNotFoundException(
                "Student Not found Id:"+id
        );
    }

    public void deleteStudent(Long id){
        Student studentToDelete=null;
        for(Student student: students){
            if(student.getId()==id){
                studentToDelete=student;
                break;
            }
        }
        if(studentToDelete==null){
            throw new StudentNotFoundException(
                    "Student not found Id:" + id);
        }

        students.remove(studentToDelete);

    }
}
