package phong.project.SpringBoot_Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import phong.project.SpringBoot_Project.dto.EnrollmentDto;
import phong.project.SpringBoot_Project.entity.Enrollment;
import phong.project.SpringBoot_Project.mapper.EnrollmentMapper;
import phong.project.SpringBoot_Project.repository.EnrollmentRepository;
import phong.project.SpringBoot_Project.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@CrossOrigin(origins = "http://localhost:4200") 
public class EnrollmentController {

    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<EnrollmentDto>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDto> getEnrollmentById(@PathVariable Long id) {
    	return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDto> createEnrollment(@RequestBody Enrollment enrollment) {
    	return ResponseEntity.ok(EnrollmentMapper.convertToEnrollmentDto(enrollmentService.createEnrollment(enrollment)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDto> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollmentDetails) {
    	return ResponseEntity.ok(EnrollmentMapper.convertToEnrollmentDto(enrollmentService.updateEnrollment(id, enrollmentDetails)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
    	return ResponseEntity.ok(enrollmentService.deleteEnrollment(id));
    }
}

