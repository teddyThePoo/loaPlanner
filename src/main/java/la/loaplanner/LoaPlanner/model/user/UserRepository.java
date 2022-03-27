package la.loaplanner.LoaPlanner.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserById(Long userId);
	User findUserByUsername(String username);
}
