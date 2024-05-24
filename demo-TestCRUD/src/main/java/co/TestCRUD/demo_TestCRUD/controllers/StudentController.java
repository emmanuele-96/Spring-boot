package co.TestCRUD.demo_TestCRUD.controllers;

import co.TestCRUD.demo_TestCRUD.entities.Student;
import co.TestCRUD.demo_TestCRUD.repositories.StudentRepository;
import co.TestCRUD.demo_TestCRUD.service.StudentService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;
    @PostMapping("")
        public @ResponseBody Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    @GetMapping("/")
    public @ResponseBody List<Student> getList(){
       return studentRepository.findAll();
    }
    @GetMapping("/{id}")
        public @ResponseBody Student getSingle(@PathVariable long id){
         Optional<Student> student = studentRepository.findById(id);
         if(student.isPresent()) {
             return student.get();
         } else {
             return null;
         }
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody @NotNull Student student) {
        student.setId(id);
        studentRepository.save(student);

    }
    @PutMapping("/{id}/working")
    public void setStudentWorking(@PathVariable long id, @RequestParam("isWorking") boolean isWorking) {
        studentService.setStudentUpdateIsWorking(id, isWorking);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentRepository.deleteById(id);

    }

}
