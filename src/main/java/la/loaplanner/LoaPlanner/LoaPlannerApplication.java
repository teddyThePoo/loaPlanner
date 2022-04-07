package la.loaplanner.LoaPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LoaPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoaPlannerApplication.class, args);
	}
}
