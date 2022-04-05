package la.loaplanner.LoaPlanner;

import la.loaplanner.LoaPlanner.listener.TodoliBotEventListner;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LoaPlannerApplication {
	private static JDA jda = null;
	private static final String BOT_TOKEN = "OTM1ODk3ODk1Mjc2Nzk3OTYz.YfFU1g.6-sguhcqbswh92awNkxzNqtRHQw";

	public static void main(String[] args) {

		try {
			jda = JDABuilder.createDefault(BOT_TOKEN)
					.addEventListeners(new TodoliBotEventListner())
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		SpringApplication.run(LoaPlannerApplication.class, args);
	}

}
