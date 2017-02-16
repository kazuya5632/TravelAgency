package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Participant;

public class JdbcParticipantDao implements ParticipantDAO {
	private Session session;

	public JdbcParticipantDao() {
		try {
			Configuration config = new Configuration().configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// DB登録
	@Override
	public void registParticipant(Participant participant) {
		Transaction transaction = session.beginTransaction();
		session.save(participant);
		transaction.commit();
		session.close();
	}
}
