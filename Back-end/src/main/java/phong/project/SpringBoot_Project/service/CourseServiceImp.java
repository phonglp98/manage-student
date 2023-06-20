package phong.project.SpringBoot_Project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phong.project.SpringBoot_Project.dto.CourseDto;
import phong.project.SpringBoot_Project.dto.EnrollmentDto;
import phong.project.SpringBoot_Project.entity.Course;
import phong.project.SpringBoot_Project.entity.Enrollment;
import phong.project.SpringBoot_Project.entity.Student;
import phong.project.SpringBoot_Project.exception.NotFoundException;
import phong.project.SpringBoot_Project.mapper.CourseMapper;
import phong.project.SpringBoot_Project.mapper.EnrollmentMapper;
import phong.project.SpringBoot_Project.repository.CourseRepository;
import phong.project.SpringBoot_Project.repository.EnrollmentRepository;
import phong.project.SpringBoot_Project.repository.StudentRepository;
import phong.project.SpringBoot_Project.repository.UserRepository;

@Service
public class CourseServiceImp implements CourseService {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<CourseDto> getAllCoursesByStudentId(Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		List<Course> result = new ArrayList<>();
		List<Course> dsMonCua1dkTheoStudent = new ArrayList<>();
		List<CourseDto> resultFinal = new ArrayList<>();
		for (Enrollment en : student.get().getEnrollments()) {
			dsMonCua1dkTheoStudent.add(en.getCourse());
		}
		result = courseRepository.findAll();
		result.removeAll(dsMonCua1dkTheoStudent);
		for (Course course : result) {
			resultFinal.add(CourseMapper.convertToCourseDto(course));
		}
		return resultFinal;
	}

	@Override
	public CourseDto getCourseById(Long id) {
		Optional<Course> result = courseRepository.findById(id);
		if (result.isPresent()) {
			return CourseMapper.convertToCourseDto(result.get());
		}
		throw new NotFoundException("Course not found with id: " + id);
	}

	@Override
	public Course createCourse(Course course) {
		Optional<Course> result = courseRepository.findByName(course.getName());
		if (result.isPresent()) {
			throw new NotFoundException("Enrollment existed");
		} else {
			return courseRepository.save(course);
		}
	}

	@Override
	public Course updateCourse(Long id, Course courseDetails) {
		Optional<Course> result = courseRepository.findById(id);
		if (result.isPresent()) {
			courseDetails.setId(id);
			return courseRepository.save(courseDetails);
		} else {
			throw new NotFoundException("Course not found with id: " + id);
		}
	}

	@Override
	public Void deleteCourse(Long id) {
		Optional<Course> result = courseRepository.findById(id);
		if (result.isPresent()) {
			for (Enrollment enrollment : result.get().getEnrollments()) {
				enrollmentRepository.deleteAll(result.get().getEnrollments());
				studentRepository.delete(enrollment.getStudent());
			}
			courseRepository.delete(result.get());
		} else {
			throw new NotFoundException("Course not found with id: " + id);
		}
		return null;
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<CourseDto> result = new ArrayList<>();
		for (Course course : courseRepository.findAll()) {
			result.add(CourseMapper.convertToCourseDto(course));
		}
		return result;
	}

	@Override
	public List<CourseDto> getAllCourseByStudentIdEnrolled(Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		List<Course> dsMonCua1dkTheoStudent = new ArrayList<>();
		List<CourseDto> resultFinal = new ArrayList<>();
		for (Enrollment en : student.get().getEnrollments()) {
			dsMonCua1dkTheoStudent.add(en.getCourse());
		}
		for (Course course : dsMonCua1dkTheoStudent) {
			resultFinal.add(CourseMapper.convertToCourseDto(course));
		}
		return resultFinal;
	}

}
