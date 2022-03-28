package la.loaplanner.LoaPlanner.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import la.loaplanner.LoaPlanner.controller.dto.UserRequestDto;
import la.loaplanner.LoaPlanner.model.user.User;
import la.loaplanner.LoaPlanner.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping("/login")
	public UserDetails login(@RequestBody UserRequestDto requestDto) {
		return userService.loadUserByUsername(requestDto.getUsername());
	}

}
