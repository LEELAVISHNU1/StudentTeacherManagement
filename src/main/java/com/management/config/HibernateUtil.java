package com.management.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.management.entity.ClassRoom;
import com.management.entity.Student;
import com.management.entity.Teacher;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Student.class)
                                                .addAnnotatedClass(Teacher.class)
                                                .addAnnotatedClass(ClassRoom.class)
                                                .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
