package phong.project.SpringBoot_Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import phong.project.SpringBoot_Project.dto.StudentDto;
import phong.project.SpringBoot_Project.entity.Student;
import phong.project.SpringBoot_Project.mapper.StudentMapper;
import phong.project.SpringBoot_Project.repository.StudentRepository;
import phong.project.SpringBoot_Project.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200") 
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentService studentService;

	@GetMapping
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	@PostMapping(path = "", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDto> createStudent(@RequestBody Student student) {
		return ResponseEntity.ok(StudentMapper.convertToStudentDto(studentService.createStudent(student)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		return ResponseEntity.ok(StudentMapper.convertToStudentDto(studentService.updateStudent(id, studentDetails)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.deleteStudent(id));
	}

	@GetMapping("/dashboard/{username}")
	public ResponseEntity<StudentDto> getStudentByUsername(@PathVariable String username) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.getStudent(username));
    	return ResponseEntity.ok(studentService.getStudentByUsername(username));
	}
}
