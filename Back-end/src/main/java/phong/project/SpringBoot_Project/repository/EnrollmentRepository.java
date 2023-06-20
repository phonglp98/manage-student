package phong.project.SpringBoot_Project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import phong.project.SpringBoot_Project.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findByCourseId(Long courseId);
}

