package phong.project.SpringBoot_Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import phong.project.SpringBoot_Project.dto.EnrollmentDto;
import phong.project.SpringBoot_Project.entity.Enrollment;

@Service
public interface EnrollmentService {

	public List<EnrollmentDto> getAllEnrollments();

	public EnrollmentDto getEnrollmentById(Long id);

	public Enrollment createEnrollment(Enrollment enrollment);

	public Enrollment updateEnrollment(Long id, Enrollment enrollmentDetails);

	public Void deleteEnrollment(Long id);

}
