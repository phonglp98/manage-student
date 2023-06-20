package phong.project.SpringBoot_Project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phong.project.SpringBoot_Project.dto.StudentDto;
import phong.project.SpringBoot_Project.dto.UserDto;
import phong.project.SpringBoot_Project.entity.Enrollment;
import phong.project.SpringBoot_Project.entity.Student;
import phong.project.SpringBoot_Project.entity.User;
import phong.project.SpringBoot_Project.exception.NotFoundException;
import phong.project.SpringBoot_Project.mapper.StudentMapper;
import phong.project.SpringBoot_Project.repository.CourseRepository;
import phong.project.SpringBoot_Project.repository.EnrollmentRepository;
import phong.project.SpringBoot_Project.repository.StudentRepository;
import phong.project.SpringBoot_Project.repository.UserRepository;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<StudentDto> getAllStudents() {
		List<StudentDto> students = new ArrayList<>();
		for (Student student : studentRepository.findAll()) {
			students.add(StudentMapper.convertToStudentDto(student));
		}
		return students;
	}

	@Override
	public StudentDto getStudentById(Long id) {
		Optional<Student> result = studentRepository.findById(id);
		if (result.isPresent()) {
			return StudentMapper.convertToStudentDto(result.get());
		}
		throw new NotFoundException("Student not found with id: " + id);
	}

	@Override
	public Student createStudent(Student student) {
		Optional<User> user = userRepository.findByUsername(student.getUser().getUsername());
		if(user.isPresent()) {
			student.getUser().setId(user.get().getId());
			return studentRepository.save(student);
		}
		throw new NotFoundException("Loi");
	}

	@Override
	public Student updateStudent(Long id, Student studentDetails) {
		Optional<Student> result = studentRepository.findById(id);
		if (result.isPresent()) {
			studentDetails.getUser().setId(result.get().getUser().getId());
			studentDetails.setId(id);
			return studentRepository.save(studentDetails);
		} else {
			throw new NotFoundException("Student not found with id: " + id);
		}
	}

	@Override
	public Void deleteStudent(Long id) {
		Optional<Student> result = studentRepository.findById(id);
		if (result.isPresent()) {
			for (Enrollment enrollment : result.get().getEnrollments()) {
				enrollmentRepository.deleteAll(result.get().getEnrollments());
				courseRepository.delete(enrollment.getCourse());
			}
			studentRepository.delete(result.get());
		} else {
			throw new NotFoundException("Student not found with id: " + id);
		}
		return null;
	}

	@Override
	public StudentDto getStudentByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			Optional<Student> student = studentRepository.findByUserId(user.get().getId());
			if (student.isPresent()) {
				Student stu = new Student();
				stu = student.get();
				stu.setUser(user.get());
				studentRepository.save(stu);
				return StudentMapper.convertToStudentDto(stu);
			}
		}
		throw new NotFoundException("Student not found with id: ");
	}

}
