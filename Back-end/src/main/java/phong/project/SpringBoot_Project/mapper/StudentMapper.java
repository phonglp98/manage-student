package phong.project.SpringBoot_Project.mapper;

import phong.project.SpringBoot_Project.dto.StudentDto;
import phong.project.SpringBoot_Project.entity.Student;

public class StudentMapper {
	public static StudentDto convertToStudentDto(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setFirstName(student.getFirstName());
		studentDto.setLastName(student.getLastName());
		studentDto.setDateOfBirth(student.getDateOfBirth());
		studentDto.setAddress(student.getAddress());
		studentDto.setEmail(student.getEmail());
		return studentDto;
	}

}
