package la.loaplanner.LoaPlanner.controller.dto;

import lombok.Data;

@Data
public class UserRequestDto {
	private Long id;
	private String username;
	private String password;

	public UserRequestDto(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
}
