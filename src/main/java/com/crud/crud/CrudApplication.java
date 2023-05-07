package com.crud.crud;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crud.crud.dao.StudentDAO;
import com.crud.crud.entity.Student;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean("Student")
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// // Create the student object

		// System.out.println("Creating new student object...");

		// // Save the object

		// System.out.println("Svaing the student");

		// studentDAO.save(tempStudent);

		// // Display the id

		// System.out.println("Created Student of id : " + tempStudent.getId());
		// Student myStudent = studentDAO.getById(tempStudent.getId());
		// System.out.println("Found Data in database" + myStudent);
		// System.out.println(studentDAO.getById(11).toString());
		// // createMultipleStudents(studentDAO);
		// Student myStudent = studentDAO.getById(1);
		// myStudent.setFirstName("patel");

		// studentDAO.update(myStudent);
		// for (Student student : studentDAO.findByLastName("Lee")) {
		// System.out.println(student.toString());
		// }
		// System.out.println(studentDAO.deleteAll() + " rows deleted");
		// createMultipleStudents(studentDAO);

		// System.out.println(studentDAO.deleteByFirstName("Jimmy") + "Number of rows
		// deleted");

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		ArrayList<Student> listOfTempStudents = new ArrayList<Student>();
		listOfTempStudents.add(new Student("Alex", "Heles", "alex@gmail.com"));

		Student[] students = {
				new Student("Jimmy", "Neeshom", "neeshom@gmail.com"),
				new Student("Jimmy", "Anderson", "anderson@gmail.com"),
				new Student("Brett", "Lee", "lee@gmail.com"),
		};
		for (Student student : students) {
			studentDAO.save(student);
			System.out.println("Created Student of id : " + student.getId());
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		// Create the student object

		System.out.println("Creating new student object...");

		Student tempStudent = new Student("Alex", "Heles", "alex@gmail.com");

		// Save the object

		System.out.println("Svaing the student");

		studentDAO.save(tempStudent);

		// Display the id

		System.out.println("Created Student of id : " + tempStudent.getId());
	}

}
