package co.TestCRUD.demo_TestCRUD.service;

import co.TestCRUD.demo_TestCRUD.entities.Student;
import co.TestCRUD.demo_TestCRUD.repositories.StudentRepository;
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
    public Student updateStudentWorkingStatus(Long id, boolean isWorking) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setWorking(isWorking);
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found"));
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
