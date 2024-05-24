package co.TestCRUD.demo_TestCRUD.repositories;

import co.TestCRUD.demo_TestCRUD.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}
