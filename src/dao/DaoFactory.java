package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoFactory {

	// CourseDAO生成
	@SuppressWarnings("resource")
	public static CourseDAO createCourseDAO() {
		try{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDAO dao = (CourseDAO) context.getBean("jdbcCourseDao");
		return dao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// TourDAO生成
	@SuppressWarnings("resource")
	public static TourDAO createTourDAO() {
		try{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TourDAO dao = (TourDAO) context.getBean("jdbcTourDao");
		return dao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ParticipantDAO生成
	@SuppressWarnings("resource")
	public static ParticipantDAO createParticipantDAO() {
		try{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ParticipantDAO dao = (ParticipantDAO) context.getBean("jdbcParticipantDao");
		return dao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
