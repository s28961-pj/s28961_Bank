package com.pjatk.project;

import com.pjatk.project.controller.AccountController;
import com.pjatk.project.model.Account;
import com.pjatk.project.model.Currency;
import com.pjatk.project.repository.AccountRepository;
import com.pjatk.project.service.AccountService;
import jakarta.xml.bind.ValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws ValidationException {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
