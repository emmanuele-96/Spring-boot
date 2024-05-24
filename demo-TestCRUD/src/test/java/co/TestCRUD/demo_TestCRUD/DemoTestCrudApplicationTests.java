package co.TestCRUD.demo_TestCRUD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import co.TestCRUD.demo_TestCRUD.controllers.StudentController;
import co.TestCRUD.demo_TestCRUD.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class StudentControllerTest {
	@Autowired
	private StudentController studentController;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Test
	void setStudentControllerLoads() {
		assertThat(studentController).isNotNull();
	}
	private MvcResult createStudent() throws Exception {
		Student student = new Student();
		student.setWorking(true);
		student.setName("Bart");
		student.setSurname("Simpson");
		return createStudent(student);
	}
	private MvcResult createStudent(Student student) throws Exception {
		MvcResult result = createStudent();
		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isNotNull();
		return createStudent(student);
	}

	private MvcResult createStudentRequest() throws Exception {
		Student student = new Student();
		student.setWorking(true);
		student.setName("Bart");
		student.setSurname("Simpson");
		return createStudentRequest(student);
	}
	private MvcResult createStudentRequest(Student student) throws Exception {
		if(student == null) return null;
		String studentJSON = objectMapper.writeValueAsString(student);
		return this.mockMvc.perform(post("/student")
				.contentType(MediaType.APPLICATION_JSON)
				.content(studentJSON)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

}
