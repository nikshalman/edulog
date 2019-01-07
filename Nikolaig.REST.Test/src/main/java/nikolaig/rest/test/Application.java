package nikolaig.rest.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nikolaig.rest.test.model.User;
import nikolaig.rest.test.repositories.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<User> users = null;
		
		// fetch all documents
		System.out.println("==========Fetch aLL users:==========");
		users = repository.findAll();
		users.forEach(System.out::println);
	
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
