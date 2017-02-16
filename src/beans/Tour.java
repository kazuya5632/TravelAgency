package beans;

import java.io.Serializable;

import org.hibernate.annotations.Proxy;

@Proxy(lazy=false)
public class Tour implements Serializable {
	private int code;
	private int courseCode;
	private String name;
	private int capacity;
	private int adultPrice;
	private int childPrice;
	private String departure;
	private String deadline;
	private boolean flag;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

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

	public Tour() {
		super();
	}

	public Tour(int courseCode, String name, int capacity, int adultPrice, int childPrice, String departure,
			String deadline) {
		super();
		this.courseCode = courseCode;
		this.name = name;
		this.capacity = capacity;
		this.adultPrice = adultPrice;
		this.childPrice = childPrice;
		this.departure = departure;
		this.deadline = deadline;
	}

}
