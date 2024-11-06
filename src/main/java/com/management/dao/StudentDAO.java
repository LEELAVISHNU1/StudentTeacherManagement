package com.management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.config.HibernateUtil;
import com.management.entity.Student;

public class StudentDAO {

	public void saveStudent(Student student) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
	}
	
	public Student getStudent(Long id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Student student=session.get(Student.class, id);
		session.close();
		return student;
	}
	
	public List<Student> getAllStudents(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<Student> students=session.createQuery("from Student",Student.class).list();
		session.close();
		return students;
	}
	
	public void deleteStudent(Long id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Student student=session.get(Student.class, id);
		session.delete(student);
		tx.commit();
		session.close();
	}
}
