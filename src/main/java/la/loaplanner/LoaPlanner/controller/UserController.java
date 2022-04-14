package la.loaplanner.LoaPlanner.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import la.loaplanner.LoaPlanner.controller.dto.UserRequestDto;
import la.loaplanner.LoaPlanner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
	private final UserService userService;

	@PostMapping("/user")
	public RedirectView signup(UserRequestDto userRequestDto) { // 회원 추가
		userService.save(userRequestDto);
		return new RedirectView("/login.html");
	}

	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/login";
	}
}
