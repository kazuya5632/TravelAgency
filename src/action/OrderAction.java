package action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.Participant;
import logic.ParticipantLogicInterface;
import logic.TourLogicInterface;

public class OrderAction extends ActionSupport implements RequestAware, SessionAware {
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
	private int courseCode;
	private String departure;
	private String leaderName;
	private String tel;
	private String adultNumber;
	private String childNumber;
	private int adultPrice;
	private int childPrice;
	private String name;
	private String kana;
	private String sex;
	private String birthday;

	// ツアー検索
	@SuppressWarnings("resource")
	public String searchTour() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object object = context.getBean("tourLogic");
		TourLogicInterface logic = (TourLogicInterface) object;

		try {

			requestMap.put("tourList", logic.findTourByCourseCode(courseCode, departure));
			requestMap.put("orderCourseCode", courseCode);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// ツアー詳細
	@SuppressWarnings("resource")
	public String tourDetail() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object object = context.getBean("tourLogic");
		TourLogicInterface logic = (TourLogicInterface) object;

		try {

			// ツアー格納
			sessionMap.put("tour", logic.findTourByPrimaryKey(code));
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 詳細から申し込み
	public String preOrder() {
		try {
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 責任者登録
	public String leaderRegist() {
		try {
			Participant participant = new Participant(name, kana, sex, birthday, address, tel, mail);

			// 参加者（責任者）格納
			sessionMap.put("participant", participant);

			// 大人人数格納
			requestMap.put("adultNumber", adultNumber);
			// 子供人数格納
			requestMap.put("childNumber", childNumber);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 責任者情報登録
	@SuppressWarnings("resource")
	public String goRegistLeader() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object object = context.getBean("participantLogic");
		ParticipantLogicInterface logic = (ParticipantLogicInterface) object;

		try {

			// 出発日取得
			String departure = getDeparture();

			// DB登録
			Participant participant = (Participant) sessionMap.get("participant");
			int orderMoney = logic.registParticipant(participant, adultNumber, adultPrice, childNumber, childPrice,
					departure);

			// 金額
			int adNumber = Integer.parseInt(adultNumber);
			int chNumber = Integer.parseInt(childNumber);
			int money = (adNumber * adultPrice) + (chNumber * childPrice);

			// 格納
			sessionMap.put("orderMoney", orderMoney);
			requestMap.put("adultNumber", adultNumber);
			requestMap.put("childNumber", childNumber);
			requestMap.put("adultPrice", adultPrice);
			requestMap.put("childPrice", childPrice);
			requestMap.put("departure", departure);
			requestMap.put("money", money);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public String goPreOrder() {
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Map<String, Object> getRequestMap() {
		return requestMap;
	}

	public void setRequestMap(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	private String address;
	private String mail;

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

	// ツアーコード
	private int code;

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdultNumber() {
		return adultNumber;
	}

	public void setAdultNumber(String adultNumber) {
		this.adultNumber = adultNumber;
	}

	public String getChildNumber() {
		return childNumber;
	}

	public void setChildNumber(String childNumber) {
		this.childNumber = childNumber;
	}

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

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}
}
