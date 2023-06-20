package phong.project.SpringBoot_Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import phong.project.SpringBoot_Project.dto.CourseDto;
import phong.project.SpringBoot_Project.entity.Course;

@Service
public interface CourseService {

	public List<CourseDto> getAllCoursesByStudentId(Long studentId);

	public CourseDto getCourseById(Long id);

	public Course createCourse(Course course);

	public Course updateCourse(Long id, Course courseDetails);

	public Void deleteCourse(Long id);

	public List<CourseDto> getAllCourses();

	public List<CourseDto> getAllCourseByStudentIdEnrolled(Long studentId);

}
