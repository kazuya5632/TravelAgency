package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.Course;
import logic.CourseLogicInterface;

public class CourseAction extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	private String name;
	private String days;
	private String place;
	private String hotel;
	private String transport;
	private String plan;
	private String ver;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String startRegist() {
		return "success";
	}

	public String regist() {
		try {
			// リクエストパラメータを設定
			Course course = new Course(name, days, place, hotel, transport, plan);

			// セッションマップに格納
			sessionMap.put("course", course);

			return "success";
		} catch (Exception e) {
			return "failure";
		}
	}

	@SuppressWarnings({ "resource" })
	public String goRegist() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Object object  = context.getBean("courseLogic");
			CourseLogicInterface logic = (CourseLogicInterface)object;

			// コースをデータベースに登録
			Course course = (Course) sessionMap.get("course");
			logic.registCourse(course);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
}
