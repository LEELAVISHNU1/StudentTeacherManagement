package com.management.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.management.config.HibernateUtil;
import com.management.entity.Teacher;
import java.util.List;



public class TeacherDAO {

	public void saveTeacher(Teacher teacher) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(teacher);
		tx.commit();
		session.close();
	}
	
	public Teacher getTeacher(Long id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Teacher teacher=session.get(Teacher.class, id);
		session.close();
		return teacher;
	}
	
	public List<Teacher> getAllTeachers(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<Teacher> teachers=session.createQuery("from Teacher",Teacher.class).list();
		session.close();
		return teachers;
	}
	
	public void deleteTeacher(Long id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Teacher teacher=session.get(Teacher.class, id);
		session.delete(teacher);
		tx.commit();
		session.close();
	}
}
