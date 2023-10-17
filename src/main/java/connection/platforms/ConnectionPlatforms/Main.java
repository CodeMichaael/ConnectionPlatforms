package connection.platforms.ConnectionPlatforms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "connection.platforms.ConnectionPlatforms.repository")
public class Main{

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}


}
