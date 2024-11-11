package com.springboot.demo.mycoolapp;

import com.springboot.demo.mycoolapp.dao.StudentDAO;
import com.springboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student = new Student("John", "Doe", "john@luvcode.com");
		Student student2 = new Student("Mary", "Public", "mary@luvcode.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita@luvcode.com");

		studentDAO.save(student);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("Saved Student. Generated id: " + student.getId());
		System.out.println("Saved Student. Generated id: " + student2.getId());
		System.out.println("Saved Student. Generated id: " + student3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {

		Student student = new Student("Paul", "Doe", "paul@luvcode.com");
		studentDAO.save(student);
		System.out.println("Saved Student. Generated id: " + student.getId());
	}
}
