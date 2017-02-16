package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Tour;

@SuppressWarnings("deprecation")
public class JdbcTourDao implements TourDAO {
	private Session session;

	public JdbcTourDao() {
		try {
			Configuration config = new Configuration().configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void registTour(Tour tour) {
		Transaction transaction = session.beginTransaction();
		session.save(tour);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Tour> findTourByCourseCode(int courseCode, String departure) {
		Query query = session.getNamedQuery("tourInCourseCode");
		query.setInteger("course_code", courseCode);
		query.setString("departure", departure);
		List<Tour> list = query.list();

		return list;
	}

	@Override
	public Tour findTourByPrimaryKey(int code) {
		try {
			Tour tour = (Tour) session.load(Tour.class, code);
			session.close();
			return tour;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
