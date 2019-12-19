package sp365.vo;

import java.sql.Date;

public class UserVO {
	String u_id;
	String u_pwd;
	String u_name;
	String u_tel;
	String u_is_mgr;
	String u_gender;
	int u_age;
	String u_email;
	String u_address;
	Date u_start_date;
	int u_total_price;
	
	public UserVO() {
		super();
	}

	public UserVO(String u_id, String u_pwd, String u_name, String u_tel, String u_is_mgr, String u_gender, int u_age,
			String u_email, String u_address, Date u_start_date, int u_total_price) {
		super();
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_tel = u_tel;
		this.u_is_mgr = u_is_mgr;
		this.u_gender = u_gender;
		this.u_age = u_age;
		this.u_email = u_email;
		this.u_address = u_address;
		this.u_start_date = u_start_date;
		this.u_total_price = u_total_price;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_tel() {
		return u_tel;
	}

	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}

	public String getU_is_mgr() {
		return u_is_mgr;
	}

	public void setU_is_mgr(String u_is_mgr) {
		this.u_is_mgr = u_is_mgr;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public int getU_age() {
		return u_age;
	}

	public void setU_age(int u_age) {
		this.u_age = u_age;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public Date getU_start_date() {
		return u_start_date;
	}

	public void setU_start_date(Date u_start_date) {
		this.u_start_date = u_start_date;
	}

	public int getU_total_price() {
		return u_total_price;
	}

	public void setU_total_price(int u_total_price) {
		this.u_total_price = u_total_price;
	}

	@Override
	public String toString() {
		return "UserVO [u_id=" + u_id + ", u_pwd=" + u_pwd + ", u_name=" + u_name + ", u_tel=" + u_tel + ", u_is_mgr="
				+ u_is_mgr + ", u_gender=" + u_gender + ", u_age=" + u_age + ", u_email=" + u_email + ", u_address="
				+ u_address + ", u_start_date=" + u_start_date + ", u_total_price=" + u_total_price + "]";
	}
	
	
	
	
	
	
	
	
}
