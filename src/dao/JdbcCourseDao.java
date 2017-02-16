package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Course;

public class JdbcCourseDao implements CourseDAO {
	private Session session;

	public JdbcCourseDao() {
		try {
			Configuration config = new Configuration().configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void registCourse(Course course) {
		Transaction transaction = session.beginTransaction();
		session.save(course);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Course> searchAll() {
		List<Course> list = new ArrayList<Course>();
		list = session.createCriteria(Course.class).list();
		session.close();
		return list;
	}

	@Override
	public Course findCourseByPrimaryKey(int code) {
		try {
			Course course = (Course) session.load(Course.class, code);
			session.close();
			return course;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
