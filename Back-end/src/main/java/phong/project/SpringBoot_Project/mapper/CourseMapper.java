package phong.project.SpringBoot_Project.mapper;

import phong.project.SpringBoot_Project.dto.CourseDto;
import phong.project.SpringBoot_Project.entity.Course;

public class CourseMapper {
	public static CourseDto convertToCourseDto(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setId(course.getId());
		courseDto.setName(course.getName());
		courseDto.setStartDate(course.getStartDate());
		courseDto.setEndDate(course.getEndDate());
		courseDto.setDescription(course.getDescription());
		courseDto.setCapacity(course.getCapacity());
		return courseDto;
	}
}
