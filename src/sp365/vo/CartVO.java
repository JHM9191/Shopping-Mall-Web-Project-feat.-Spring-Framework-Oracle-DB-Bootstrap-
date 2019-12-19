package sp365.vo;

import java.util.Date;

public class CartVO {
	private String c_id;
	private int c_qty;
	private String c_size;
	private int c_sum;
	private Date c_regdate;
	private String o_id;
	private String p_id;
	private String u_id;


	public CartVO() {
		super();
	}

	public CartVO(String c_id, int c_qty, String c_size, int c_sum, Date c_regdate, String o_id, String p_id,
			String u_id) {
		super();
		this.c_id = c_id;
		this.c_qty = c_qty;
		this.c_size = c_size;
		this.c_sum = c_sum;
		this.c_regdate = c_regdate;
		this.o_id = o_id;
		this.p_id = p_id;
		this.u_id = u_id;
	}




	public String getC_id() {
		return c_id;
	}


	public void setC_id(String c_id) {
		this.c_id = c_id;
	}


	public int getC_qty() {
		return c_qty;
	}


	public void setC_qty(int c_qty) {
		this.c_qty = c_qty;
	}


	public String getC_size() {
		return c_size;
	}


	public void setC_size(String c_size) {
		this.c_size = c_size;
	}


	public int getC_sum() {
		return c_sum;
	}



	public void setC_sum(int c_sum) {
		this.c_sum = c_sum;
	}



	public Date getC_regdate() {
		return c_regdate;
	}


	public void setC_regdate(Date c_regdate) {
		this.c_regdate = c_regdate;
	}


	public String getO_id() {
		return o_id;
	}


	public void setO_id(String o_id) {
		this.o_id = o_id;
	}


	public String getP_id() {
		return p_id;
	}


	public void setP_id(String p_id) {
		this.p_id = p_id;
	}


	public String getU_id() {
		return u_id;
	}


	public void setU_id(String u_id) {
		this.u_id = u_id;
	}



	@Override
	public String toString() {
		return "CartVO [c_id=" + c_id + ", c_qty=" + c_qty + ", c_size=" + c_size + ", c_sum=" + c_sum
				+ ", c_regdate=" + c_regdate + ", o_id=" + o_id + ", p_id=" + p_id + ", u_id=" + u_id + "]";
	}

	


	

}
