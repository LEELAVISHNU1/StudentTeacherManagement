package com.management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.config.HibernateUtil;
import com.management.entity.ClassRoom;

public class ClassRoomDAO {

	public void saveClassRoom(ClassRoom classRoom) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(classRoom);
		tx.commit();
		session.close();
	}
	
	public ClassRoom getClassRoom(Long id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		ClassRoom classRoom=session.get(ClassRoom.class, id);
		session.close();
		return classRoom;
	}
	
	public List<ClassRoom> getAllClassRooms(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<ClassRoom> classRooms=session.createQuery("from ClassRoom",ClassRoom.class).list();
		session.close();
		return classRooms;
	}
	
	public void deleteClassRoom(Long id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		ClassRoom classRoom=session.get(ClassRoom.class, id);
		session.delete(classRoom);
		tx.commit();
		session.close();
	}
}
