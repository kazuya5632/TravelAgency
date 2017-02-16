package beans;

import java.io.Serializable;

import org.hibernate.annotations.Proxy;

@Proxy(lazy=false)
public class Course implements Serializable{
	private int code;
	private String name;
	private String days;
	private String place;
	private String hotel;
	private String transport;
	private String plan;
	private String ver;

	public Course() {
		super();
	}

	public Course(String name, String days, String place, String hotel, String transport, String plan) {
		super();
		this.name = name;
		this.days = days;
		this.place = place;
		this.hotel = hotel;
		this.transport = transport;
		this.plan = plan;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "code:" + code + " name:" + name + " days:" + days + " place:" + place + " hotel:" + hotel
				+ " transport:" + transport + " plan:" + plan + " ver:" + ver;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
