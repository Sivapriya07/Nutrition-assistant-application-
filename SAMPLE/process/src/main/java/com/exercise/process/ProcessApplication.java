package com.exercise.process;

import com.exercise.process.Entity.Role;
import com.exercise.process.Entity.User;
import com.exercise.process.Repository.Rolerepository;
import com.exercise.process.Repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProcessApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProcessApplication.class, args);
	}
}







