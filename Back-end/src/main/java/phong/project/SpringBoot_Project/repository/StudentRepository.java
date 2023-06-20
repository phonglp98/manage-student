package phong.project.SpringBoot_Project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import phong.project.SpringBoot_Project.entity.Student;
import phong.project.SpringBoot_Project.entity.User;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByUserId(Long id);
}

