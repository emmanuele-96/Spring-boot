package co.TestCRUD.demo_TestCRUD;

import co.TestCRUD.demo_TestCRUD.entities.Student;
import co.TestCRUD.demo_TestCRUD.repositories.StudentRepository;
import co.TestCRUD.demo_TestCRUD.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.mockito.Mockito.*;


@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;
    public StudentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testSetStudentUpdateIsWorking_StudentFound(){
        Long studentId = 1L;
        boolean isWorking = true;

        Student student = new Student();
        student.setId(studentId);
        student.setWorking(false);
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        studentService.setStudentUpdateIsWorking(studentId, isWorking);

        verify(studentRepository, times(1)).save(student);
        assert(student.isWorking() == isWorking);
    }
    }

