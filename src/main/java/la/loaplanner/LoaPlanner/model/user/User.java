package la.loaplanner.LoaPlanner.model.user;

import java.util.*;

import javax.persistence.*;

import lombok.AccessLevel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;

	private String auth;

	@OneToMany(mappedBy="user")
	private List<Character> characters = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	private Group group;

	@Builder
	public User(String username, String password, String auth) {
		this.username = username;
		this.password = password;
		this.auth = auth;
	}

	// 사용자의 권한을 콜렉션 형태로 반환
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> roles = new HashSet<>();
		for (String role : auth.split(",")) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		return roles;
	}

	// 사용자의 id를 반환
	@Override
	public String getUsername() {
		return username;
	}

	// 사용자의 password를 반환
	@Override
	public String getPassword() {
		return password;
	}

	// 계정 만료 여부 반환
	@Override
	public boolean isAccountNonExpired() {
		// 만료되었는지 확인하는 로직
		return true; // true -> 만료되지 않았음
	}

	// 계정 잠금 여부 반환
	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠금되었는지 확인하는 로직
		return true; // true -> 잠금되지 않았음
	}

	// 패스워드의 만료 여부 반환
	@Override
	public boolean isCredentialsNonExpired() {
		// 패스워드가 만료되었는지 확인하는 로직
		return true; // true -> 만료되지 않았음
	}

	// 계정 사용 가능 여부 반환
	@Override
	public boolean isEnabled() {
		// 계정이 사용 가능한지 확인하는 로직
		return true; // true -> 사용 가능
	}
}