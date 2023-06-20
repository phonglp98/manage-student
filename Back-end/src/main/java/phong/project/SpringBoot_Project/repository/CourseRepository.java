package phong.project.SpringBoot_Project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import phong.project.SpringBoot_Project.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String name);
}

