package co.TestCRUD.demo_TestCRUD;

import co.TestCRUD.demo_TestCRUD.entities.Student;
import co.TestCRUD.demo_TestCRUD.repositories.StudentRepository;
import co.TestCRUD.demo_TestCRUD.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;
    @Test
    public void testCreateStudent() {
        Student student = new Student(1L, "Bart", "Simpson", false);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student createdStudent = studentService.createStudent(student);

        assertNotNull(createdStudent.getId());

    }
    @Test
    public void testGetStudent() {
        Student student = new Student(1L, "Bart", "Simpson", false);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Optional<Student> foundStudent = studentService.getStudentById(1L);
        assertTrue(foundStudent.isPresent());
        assertEquals("Bart", foundStudent.get().getName());
    }
    @Test
    public void testUpdateStudent() {
        Student student = new Student(1L, "Krasty", "IlCloune", true);
        Student updatedStudent = new Student(1L, "Krasty", "UpdatedSurname", true);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.save(any(Student.class))).thenReturn(updatedStudent);

        student.setSurname("UpdatedSurname");
        Student result = studentService.updateStudent(1L, student);
        assertEquals("UpdatedSurname", result.getSurname());
    }
    @Test
    public void testDeleteStudent() {
        Student student = new Student(1L, "Homer", "Simpson", false);
        Student createStudent = studentService.createStudent(student);
        studentService.deleteStudent(createStudent.getId());
        List<Student> renamingStudents = studentService.getAllStudent();
        assertFalse(renamingStudents.contains(student));
    }
    }

