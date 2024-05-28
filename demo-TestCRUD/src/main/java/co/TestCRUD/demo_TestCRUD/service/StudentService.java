package co.TestCRUD.demo_TestCRUD.service;

import co.TestCRUD.demo_TestCRUD.entities.Student;
import co.TestCRUD.demo_TestCRUD.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDetails.getName());
        student.setSurname(studentDetails.getSurname());
        return studentRepository.save(student);

    }
    public void setStudentUpdateIsWorking(Long studentId, boolean isWorking){
        Optional<Student> student = studentRepository.findById(studentId);
        if(!student.isPresent());
        student.get().setWorking(isWorking);
        studentRepository.save(student.get());
    }
    public boolean deleteStudent(Long id) {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
