package co.TestCRUD.demo_TestCRUD.service;

import co.TestCRUD.demo_TestCRUD.entities.Student;
import co.TestCRUD.demo_TestCRUD.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public void setStudentUpdateIsWorking(Long studentId, boolean isWorking){
        Optional<Student> student = studentRepository.findById(studentId);
        if(!student.isPresent()) return;
        student.get().setWorking(isWorking);
        studentRepository.save(student.get());
    }
}
