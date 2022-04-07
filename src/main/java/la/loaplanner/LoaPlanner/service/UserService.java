package la.loaplanner.LoaPlanner.service;

import la.loaplanner.LoaPlanner.controller.dto.UserRequestDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import la.loaplanner.LoaPlanner.model.user.User;
import la.loaplanner.LoaPlanner.model.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);
		if (user == null) throw new UsernameNotFoundException("Check you user name.");

		return user;
	}

	public Long save(UserRequestDto userRequestDto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userRequestDto.setPassword(encoder.encode(userRequestDto.getPassword()));

		return userRepository.save(User.builder()
				.username(userRequestDto.getUsername())
				.auth(userRequestDto.getAuth())
				.password(userRequestDto.getPassword()).build()).getId();
	}
}