package com.management;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.management.entity.ClassRoom;
import com.management.entity.Student;
import com.management.entity.Teacher;

import com.management.dao.*;

public class MainApp {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(ClassRoom.class)
				.buildSessionFactory();
		
		StudentDAO studentDAO=new StudentDAO();
		TeacherDAO teacherDAO=new TeacherDAO();
		ClassRoomDAO classRoomDAO=new ClassRoomDAO();
		
		Student student1=new Student("Alice");
		Student student2=new Student("Bob");
		
		Teacher teacher1=new Teacher("Mr.Giri");
		Teacher teacher2=new Teacher("Ms.Jhansi");
		
		ClassRoom classRoom1=new ClassRoom("Maths");
		ClassRoom classRoom2=new ClassRoom("Science");
		
		classRoomDAO.saveClassRoom(classRoom1);
		classRoomDAO.saveClassRoom(classRoom2);
		
		teacherDAO.saveTeacher(teacher1);
		teacherDAO.saveTeacher(teacher2);
		
		studentDAO.saveStudent(student1);
		studentDAO.saveStudent(student2);
		
		
		classRoom1.getStudents().add(student1);
		classRoom1.getStudents().add(student2);
		classRoom1.getTeachers().add(teacher1);
		
		classRoom2.getStudents().add(student1);
		classRoom2.getTeachers().add(teacher2);
		
		classRoomDAO.saveClassRoom(classRoom1);
		classRoomDAO.saveClassRoom(classRoom2);
		
		System.out.println("All Students:");
		for(Student student:studentDAO.getAllStudents()) {
			System.out.println(student.getName());
		}
		
		System.out.println("All Teachers: ");
		for(Teacher teacher:teacherDAO.getAllTeachers()) {
			System.out.println(teacher.getName());
		}
		
		System.out.println("All CLassRooms: ");
		for(ClassRoom classRoom:classRoomDAO.getAllClassRooms()) {
			System.out.println(classRoom.getName());
		}
		
		factory.close();
	}
}
