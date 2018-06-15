package com.example.demo;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicsApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(Config.class, args);
		
		context.getBean(Controller.class).save(new Employee(1, "saurin", 10000.00F));
		context.getBean(Controller.class).getEmployeeById(1).stream().forEach(System.out::println);
	}

}
