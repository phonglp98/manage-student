package phong.project.SpringBoot_Project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phong.project.SpringBoot_Project.dto.UserDto;
import phong.project.SpringBoot_Project.entity.Course;
import phong.project.SpringBoot_Project.entity.Enrollment;
import phong.project.SpringBoot_Project.entity.Student;
import phong.project.SpringBoot_Project.entity.User;
import phong.project.SpringBoot_Project.exception.NotFoundException;
import phong.project.SpringBoot_Project.mapper.UserMapper;
import phong.project.SpringBoot_Project.repository.CourseRepository;
import phong.project.SpringBoot_Project.repository.EnrollmentRepository;
import phong.project.SpringBoot_Project.repository.StudentRepository;
import phong.project.SpringBoot_Project.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> users = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			users.add(UserMapper.convertToUserDto(user));
		}
		return users;
	}

	@Override
	public UserDto getUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return UserMapper.convertToUserDto(user.get());
		} else {
			throw new NotFoundException("User not found with username: " + username);
		}
	}

	@Override
	public User createUser(User user) {
		if (user.getUsername().equals("") && user.getPassword().equals("")) {
			throw new NotFoundException("Khong duoc de trong");
		} else {
			return userRepository.save(user);
		}
	}

	@Override
	public User updateUser(Long id, User userDetails) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userDetails.setId(id);
			return userRepository.save(userDetails);
		} else {
			throw new NotFoundException("User not found with id: " + id);
		}
	}

	@Override
	public Void deleteUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			for (Enrollment enrollment : user.get().getStudent().getEnrollments()) {
				enrollmentRepository.deleteAll(user.get().getStudent().getEnrollments());
				courseRepository.delete(enrollment.getCourse());
			}
			studentRepository.delete(user.get().getStudent());
			userRepository.delete(user.get());
		} else {
			throw new NotFoundException("User not found with id: " + id);
		}
		return null;
	}

	@Override
	public Boolean checkUser(UserDto userDto) {
		Optional<User> user = userRepository.findByUsername(userDto.getUsername());
		if (user.isPresent()) {
			if (userDto.getUsername().equals(userRepository.findByUsername(userDto.getUsername()).get().getUsername())
					&& userDto.getPassword()
							.equals(userRepository.findByUsername(userDto.getUsername()).get().getPassword())) {
				if (user.get().getRole().equals("student")) {
					return true;
				}
			}
		}
		return false;
	}

}
