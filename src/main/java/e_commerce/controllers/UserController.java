package e_commerce.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.dto.UserDto;
import e_commerce.dto.UserResponseDto;
import e_commerce.entities.User;
import e_commerce.services.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
		return ResponseEntity.ok(userService.createUser(userDto));
	}

	@GetMapping
	public ResponseEntity<List<UserResponseDto>> listUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}
	
}
