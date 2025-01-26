package e_commerce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_commerce.dto.UserDto;
import e_commerce.dto.UserResponseDto;
import e_commerce.entities.Cart;
import e_commerce.entities.User;
import e_commerce.repositories.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(UserDto userDto) {

		User user = new User(null, userDto.name(), userDto.cpf(), userDto.email(), userDto.password(), userDto.phone());

		userRepository.save(user);
		return user;
	}

	public UserResponseDto toDto(User entity) {
		return new UserResponseDto(entity.getId(), entity.getName(), entity.getEmail());
	}

	public List<UserResponseDto> findAllUsers() {
		List<User> entity = userRepository.findAll();
		return entity.stream().map(this::toDto).collect(Collectors.toList());
	}

	public Optional<Cart> findCartByUserId(Long userId) {
		return userRepository.findCartByUser_Id(userId);
	}

	public User findById(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not Found!"));
		return user;
	}

}
