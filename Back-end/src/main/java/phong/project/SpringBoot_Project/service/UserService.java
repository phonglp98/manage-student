package phong.project.SpringBoot_Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import phong.project.SpringBoot_Project.dto.UserDto;
import phong.project.SpringBoot_Project.entity.User;

@Service
public interface UserService {
	public List<UserDto> getAllUsers();
	
	public UserDto getUserByUsername(String username);
	
	public User createUser(User user);

	public User updateUser(Long id, User userDetails);

	public Void deleteUser(Long id);

	public Boolean checkUser(UserDto userDto);

}
