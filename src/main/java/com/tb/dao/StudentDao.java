package com.tb.dao;

import org.hibernate.Session;

import com.tb.model.Student;
import com.tb.util.HibernateUtil;

public class StudentDao implements DataDao<Student> {

	@Override
	public void create(Student entity) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(entity);

		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Student retrieve(int id, Class<Student> clazz) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Student student = session.load(clazz, id);

		session.getTransaction().commit();
		session.close();

		return student;

	}

	@Override
	public void update(Student entity) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.saveOrUpdate(entity);

		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void delete(int id, Class<Student> clazz) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Student student = session.load(clazz, id);

		if (student != null)
			session.delete(student);

		session.getTransaction().commit();
		session.close();

	}
}
