package phong.project.SpringBoot_Project.mapper;

import phong.project.SpringBoot_Project.dto.EnrollmentDto;
import phong.project.SpringBoot_Project.entity.Enrollment;

public class EnrollmentMapper {
	public static EnrollmentDto convertToEnrollmentDto(Enrollment enrollment) {
		EnrollmentDto enrollmentDto = new EnrollmentDto();
		enrollmentDto.setId(enrollment.getId());
		enrollmentDto.setEnrollmentDate(enrollment.getEnrollmentDate());
		return enrollmentDto;
	}
}
