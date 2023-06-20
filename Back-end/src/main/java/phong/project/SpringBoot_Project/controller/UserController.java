package phong.project.SpringBoot_Project.controller;

import phong.project.SpringBoot_Project.dto.UserDto;
import phong.project.SpringBoot_Project.entity.User;
import phong.project.SpringBoot_Project.mapper.UserMapper;
import phong.project.SpringBoot_Project.repository.UserRepository;
import phong.project.SpringBoot_Project.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200") 
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
    	return ResponseEntity.ok(UserMapper.convertToUserDto(userService.createUser(user)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    	return ResponseEntity.ok(UserMapper.convertToUserDto(userService.updateUser(id, userDetails)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    	return ResponseEntity.ok(userService.deleteUser(id));
    }
    
    @PostMapping("/check-user")
    public ResponseEntity<Boolean> checkUser(@RequestBody UserDto userDto){
    	return ResponseEntity.ok(userService.checkUser(userDto));
    }
}

