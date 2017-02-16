package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.Tour;
import logic.CourseLogicInterface;
import logic.TourLogicInterface;

public class TourAction extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	private int courseCode;
	private String name;
	private int capacity;
	private int adultPrice;
	private int childPrice;
	private String departure;
	private String deadline;
	private boolean flag;



	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(int adultPrice) {
		this.adultPrice = adultPrice;
	}

	public int getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(int childPrice) {
		this.childPrice = childPrice;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	@SuppressWarnings("resource")
	public String startRegist() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Object object = context.getBean("courseLogic");
			CourseLogicInterface logic = (CourseLogicInterface) object;

			// コース全件取得
			sessionMap.put("courseList", logic.searchAll());

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@SuppressWarnings("resource")
	public String regist() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Object object = context.getBean("courseLogic");
			CourseLogicInterface logic = (CourseLogicInterface) object;

			// コース格納
			sessionMap.put("course", logic.findCourseByPrimaryKey(courseCode));

			// ツアー格納
			Tour tour = new Tour(courseCode, name, capacity, adultPrice, childPrice, departure, deadline);
			sessionMap.put("tour", tour);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}


	@SuppressWarnings("resource")
	public String goRegist() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Object object = context.getBean("tourLogic");
			TourLogicInterface logic = (TourLogicInterface) object;

			// DB登録
			Tour tour = (Tour) sessionMap.get("tour");
			logic.registTour(tour);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

}
