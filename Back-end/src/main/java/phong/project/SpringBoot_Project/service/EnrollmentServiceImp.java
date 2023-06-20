package phong.project.SpringBoot_Project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phong.project.SpringBoot_Project.dto.EnrollmentDto;
import phong.project.SpringBoot_Project.dto.UserDto;
import phong.project.SpringBoot_Project.entity.Enrollment;
import phong.project.SpringBoot_Project.entity.Student;
import phong.project.SpringBoot_Project.entity.User;
import phong.project.SpringBoot_Project.exception.NotFoundException;
import phong.project.SpringBoot_Project.mapper.EnrollmentMapper;
import phong.project.SpringBoot_Project.mapper.StudentMapper;
import phong.project.SpringBoot_Project.mapper.UserMapper;
import phong.project.SpringBoot_Project.repository.CourseRepository;
import phong.project.SpringBoot_Project.repository.EnrollmentRepository;
import phong.project.SpringBoot_Project.repository.StudentRepository;
import phong.project.SpringBoot_Project.repository.UserRepository;

@Service
public class EnrollmentServiceImp implements EnrollmentService{
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<EnrollmentDto> getAllEnrollments() {
		List<EnrollmentDto> result = new ArrayList<>();
		for (Enrollment enrollment : enrollmentRepository.findAll()) {
			result.add(EnrollmentMapper.convertToEnrollmentDto(enrollment));
		}
		return result;
	}

	@Override
	public EnrollmentDto getEnrollmentById(Long id) {
		Optional<Enrollment> result = enrollmentRepository.findByCourseId(id);
		if(result.isPresent()) {
			return EnrollmentMapper.convertToEnrollmentDto(result.get());
		}
		throw new NotFoundException("Enrollment not found with id: " + id);
	}

	@Override
	public Enrollment createEnrollment(Enrollment enrollment) {
//		Optional<Enrollment> result = enrollmentRepository.findById(enrollment.getId());
//		if (result.isPresent()) {
//			throw new NotFoundException("Enrollment existed");
//		} else {
			return enrollmentRepository.save(enrollment);
//		}
	}

	@Override
	public Enrollment updateEnrollment(Long id, Enrollment enrollmentDetails) {
		Optional<Enrollment> result = enrollmentRepository.findById(id);
		if (result.isPresent()) {
			enrollmentDetails.setId(id);
			return enrollmentRepository.save(enrollmentDetails);
		} else {
			throw new NotFoundException("Enrollment not found with id: " + id);
		}
	}

	@Override
	public Void deleteEnrollment(Long id) {
		Optional<Enrollment> result = enrollmentRepository.findById(id);
		if (result.isPresent()) {
			enrollmentRepository.delete(result.get());
		} else {
			throw new NotFoundException("Enrollment not found with id: " + id);
		}
		return null;
	}

}
