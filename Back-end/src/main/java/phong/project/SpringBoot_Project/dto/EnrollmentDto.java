package phong.project.SpringBoot_Project.dto;

import java.time.LocalDate;

import phong.project.SpringBoot_Project.entity.Course;
import phong.project.SpringBoot_Project.entity.Student;

public class EnrollmentDto {
    private Long id;
    private Student student;
    private Course course;
    private String enrollmentDate;


    public EnrollmentDto() {
    }	

    public EnrollmentDto(Long id, String enrollmentDate) {
        this.id = id;
        this.enrollmentDate = enrollmentDate;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
    
    
}

