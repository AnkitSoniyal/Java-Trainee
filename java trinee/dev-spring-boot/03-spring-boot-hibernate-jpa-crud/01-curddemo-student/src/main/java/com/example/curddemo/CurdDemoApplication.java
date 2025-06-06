package com.example.curddemo;

import com.example.curddemo.dao.StudentDAO;
import com.example.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurdDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner-> {
			//createMultipleStudent(studentDAO);
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//displayAllStudent(studentDAO);
			//displayStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};

	}

	public void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 Student Objects...");
		Student student1 = new Student("Qwe","Iop","qwe@gmail.com");
		Student student2 = new Student("Asd","Jkl","@gmail.com");
		Student student3 = new Student("Bonita","Applebum","Bonita@gmail.com");

		System.out.println("Saving the Student... ");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("creating new student...");
		Student student = new Student("Asd","Zxc","asd@gmail.com");
		System.out.println("saving the student...");
		studentDAO.save(student);
		System.out.println("Saved the student...Generated id: "+student.getId());
	}
	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a ner Student ... ");
		Student student=new Student("Wer","Uio","wer@gmail.com");
		studentDAO.save(student);
		System.out.println("Reading the Student ... ");
		Student student1=studentDAO.findById(student.getId());
		System.out.println("Reading the Student by ID ... ");
		System.out.println(student1);
	}
	private void displayAllStudent(StudentDAO studentDAO) {
		System.out.println("Displaying all Student ... ");
		List<Student> students=studentDAO.findAll();
		for(Student student:students){
			System.out.println(student);
		}
	}

	private void displayStudentByLastName(StudentDAO studentDAO) {
		System.out.println("Displaying student by last name ... ");
		List<Student> students=studentDAO.findByLastName("Applebum");
		for(Student student:students){
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Updating student ... ");
		int id=1;
		Student student=studentDAO.findById(id);
		student.setFirstName("Scooby");
		studentDAO.update(student);
		System.out.println("Updated the student ... ");
		System.out.println(student);

	}
	private void deleteStudent(StudentDAO studentDAO) {
		displayAllStudent(studentDAO);
		int id=2;
		Student student=studentDAO.findById(id);
		System.out.println("Deleting student ... "+student);
		studentDAO.delete(id);
		System.out.println("Deleted the student ... ");
		displayAllStudent(studentDAO);
	}
	private void deleteAllStudent(StudentDAO studentDAO) {
		displayAllStudent(studentDAO);
		System.out.println("Deleting all student ... ");
		int i =studentDAO.deleteAll();
		System.out.println("Deleted %d student ... "+i);
	}
}

