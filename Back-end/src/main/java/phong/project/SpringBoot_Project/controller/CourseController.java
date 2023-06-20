package phong.project.SpringBoot_Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import phong.project.SpringBoot_Project.dto.CourseDto;
import phong.project.SpringBoot_Project.entity.Course;
import phong.project.SpringBoot_Project.mapper.CourseMapper;
import phong.project.SpringBoot_Project.mapper.EnrollmentMapper;
import phong.project.SpringBoot_Project.repository.CourseRepository;
import phong.project.SpringBoot_Project.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:4200") 
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
    	return ResponseEntity.ok(courseService.getAllCourses());
    }
    
    @GetMapping("/get/{studentId}")
    public ResponseEntity<List<CourseDto>> getAllCoursesByStudentId(@PathVariable Long studentId) {
    	return ResponseEntity.ok(courseService.getAllCoursesByStudentId(studentId));
    }
    
    @GetMapping("/get/enrolled/{studentId}")
    public ResponseEntity<List<CourseDto>> getAllCourseByStudentIdEnrolled(@PathVariable Long studentId) {
    	return ResponseEntity.ok(courseService.getAllCourseByStudentIdEnrolled(studentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
    	return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody Course course) {
    	return ResponseEntity.ok(CourseMapper.convertToCourseDto(courseService.createCourse(course)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
    	return ResponseEntity.ok(CourseMapper.convertToCourseDto(courseService.updateCourse(id, courseDetails)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
    	return ResponseEntity.ok(courseService.deleteCourse(id));
    }
}

