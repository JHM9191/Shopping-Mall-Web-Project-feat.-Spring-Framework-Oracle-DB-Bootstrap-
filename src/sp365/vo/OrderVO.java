package sp365.vo;

import java.util.Date;

public class OrderVO {
	private String o_id;
	private String o_name;
	private String o_tel;
	private String o_email;
	private String o_address;
	private Date o_regdate;
	private int o_total;
	private String o_payment;
	private String u_id;


	public OrderVO() {
		super();
	}


	public OrderVO(String o_id, String o_name, String o_tel, String o_email, String o_address, Date o_regdate,
			int o_total, String o_payment, String u_id) {
		super();
		this.o_id = o_id;
		this.o_name = o_name;
		this.o_tel = o_tel;
		this.o_email = o_email;
		this.o_address = o_address;
		this.o_regdate = o_regdate;
		this.o_total = o_total;
		this.o_payment = o_payment;
		this.u_id = u_id;
	}


	public String getO_id() {
		return o_id;
	}


	public void setO_id(String o_id) {
		this.o_id = o_id;
	}


	public String getO_name() {
		return o_name;
	}


	public void setO_name(String o_name) {
		this.o_name = o_name;
	}


	public String getO_tel() {
		return o_tel;
	}


	public void setO_tel(String o_tel) {
		this.o_tel = o_tel;
	}


	public String getO_email() {
		return o_email;
	}


	public void setO_email(String o_email) {
		this.o_email = o_email;
	}


	public String getO_address() {
		return o_address;
	}


	public void setO_address(String o_address) {
		this.o_address = o_address;
	}


	public Date getO_regdate() {
		return o_regdate;
	}


	public void setO_regdate(Date o_regdate) {
		this.o_regdate = o_regdate;
	}


	public int getO_total() {
		return o_total;
	}


	public void setO_total(int o_total) {
		this.o_total = o_total;
	}


	public String getO_payment() {
		return o_payment;
	}


	public void setO_payment(String o_payment) {
		this.o_payment = o_payment;
	}


	public String getU_id() {
		return u_id;
	}


	public void setU_id(String u_id) {
		this.u_id = u_id;
	}


	@Override
	public String toString() {
		return "OrderVO [o_id=" + o_id + ", o_name=" + o_name + ", o_tel=" + o_tel + ", o_email=" + o_email
				+ ", o_address=" + o_address + ", o_regdate=" + o_regdate + ", o_total=" + o_total + ", o_payment="
				+ o_payment + ", u_id=" + u_id + "]";
	}

	


	

}
