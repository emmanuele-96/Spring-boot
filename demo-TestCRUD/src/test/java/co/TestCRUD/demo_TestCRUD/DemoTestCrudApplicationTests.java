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
	@Test
	 void createStudent() throws Exception {
		Student student = new Student(null,"Bart","Simpson",true);


		MvcResult result = createStudentRequest(student);

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isNotNull();
		assertThat(studentFromResponse.getName()).isEqualTo("Bart");
		assertThat(studentFromResponse.getSurname()).isEqualTo("Simpson");
		assertThat(studentFromResponse.isWorking()).isTrue();
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
