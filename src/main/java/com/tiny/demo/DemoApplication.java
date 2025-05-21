package com.tiny.demo;

import com.tiny.demo.entity.Event;
import com.tiny.demo.repository.EventRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;



import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner seed(EventRepository repo) {
		return args -> {
			if (repo.count() == 0) {
				repo.save(new Event(null, "Spring Boot Launch", LocalDate.of(2024, 5, 20)));
				repo.save(new Event(null, "Frontend Deploy", LocalDate.of(2024, 5, 21)));
				repo.save(new Event(null, "Docker Compose Success", LocalDate.of(2024, 5, 22)));
			}
		};
	}
}
