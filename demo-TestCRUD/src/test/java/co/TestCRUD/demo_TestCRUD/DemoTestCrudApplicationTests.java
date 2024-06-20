package co.TestCRUD.demo_TestCRUD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import co.TestCRUD.demo_TestCRUD.controllers.StudentController;
import co.TestCRUD.demo_TestCRUD.entities.Student;
import co.TestCRUD.demo_TestCRUD.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles(value = "test")
@WebMvcTest(StudentController.class)
class StudentControllerTest {
	@Autowired
	private StudentService studentService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void createStudent() throws Exception {
		Student student = new Student();
		student.setName("Bart");
		student.setSurname("Simpson");


		Mockito.when(studentService.createStudent(Mockito.any(Student.class))).thenReturn(student);

		mockMvc.perform(MockMvcRequestBuilders
						.post("/students")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(student)))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"));
	}

	@Test
	public void getAllStudents() throws Exception {
		Student student1 = new Student();
		student1.setName("Bart");
		student1.setSurname("Simpson");

		Student student2 = new Student();
		student2.setName("Lisa");
		student2.setSurname("Simpson");

		Mockito.when(studentService.getAllStudent()).thenReturn(Arrays.asList(student1, student2));

		mockMvc.perform(MockMvcRequestBuilders
						.get("/students")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Bart"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Lisa"));
	}

	@Test
	public void getStudentById() throws Exception {
		Student student = new Student();
		student.setName("Bart");
		student.setSurname("Simpson");

		Mockito.when(studentService.getStudentById(1L)).thenReturn(Optional.of(student));

		mockMvc.perform(MockMvcRequestBuilders
						.get("/students/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bart"));
	}

	@Test
	public void updateStudent() throws Exception {
		Student student = new Student();
		student.setName("Bart");
		student.setSurname("Simpson");

		Mockito.when(studentService.updateStudent(Mockito.anyLong(), Mockito.any(Student.class))).thenReturn(student);

		mockMvc.perform(MockMvcRequestBuilders
						.put("/students/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(student)))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bart"));
	}

	@Test
	public void updateStudentWorking() throws Exception {
		Student student = new Student();
		student.setName("Bart");
		student.setSurname("Simpson");
		student.setWorking(true);

		Mockito.when(studentService.updateStudentWorkingStatus(Mockito.anyLong(), Mockito.anyBoolean())).thenReturn(student);

		mockMvc.perform(MockMvcRequestBuilders
						.patch("/students/1/working")
						.param("working", "true")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.working").value(true));
	}
	@Test
	public void deleteStudent() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
						.delete("/students/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}

