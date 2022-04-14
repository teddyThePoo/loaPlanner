package la.loaplanner.LoaPlanner.controller.dto;

import lombok.Data;

@Data
public class UserRequestDto {
	private String username;
	private String password;
	private String auth;

	public UserRequestDto(String username, String password, String auth) {
		this.username = username;
		this.password = password;
		this.auth = auth;
	}
}
