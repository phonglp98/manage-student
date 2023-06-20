package phong.project.SpringBoot_Project.mapper;


import phong.project.SpringBoot_Project.dto.UserDto;
import phong.project.SpringBoot_Project.entity.User;

public class UserMapper {
	public static UserDto convertToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setRole(user.getRole());
		return userDto;
	}

}
