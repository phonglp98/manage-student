package phong.project.SpringBoot_Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import phong.project.SpringBoot_Project.dto.StudentDto;
import phong.project.SpringBoot_Project.dto.UserDto;
import phong.project.SpringBoot_Project.entity.Student;

@Service
public interface StudentService {

	public List<StudentDto> getAllStudents();

	public StudentDto getStudentById(Long id);

	public Student createStudent(Student student);

	public Student updateStudent(Long id, Student studentDetails);

	public Void deleteStudent(Long id);

	public StudentDto getStudentByUsername(String username);
	

}
