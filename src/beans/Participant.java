package beans;

import java.io.Serializable;

import org.hibernate.annotations.Proxy;

@Proxy(lazy = false)
public class Participant implements Serializable {
	private int code;
	private String name;
	private String kana;
	private String sex;
	private String birthday;
	private String address;
	private String tel;
	private String mail;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Participant() {
		super();
	}

	public Participant(int code, String name, String kana, String sex, String birthday, String address, String tel,
			String mail) {
		super();
		this.code = code;
		this.name = name;
		this.kana = kana;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
	}

	public Participant(String name, String kana, String sex, String birthday, String address, String tel, String mail) {
		super();
		this.name = name;
		this.kana = kana;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
	}

}
