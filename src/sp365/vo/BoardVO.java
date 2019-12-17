package sp365.vo;

import java.util.Date;

public class BoardVO {
	private String b_id;
	private String b_title;
	private String b_writer;
	private String b_content;
	private Date b_regdate;
	private String b_reply;
	private String u_id;

	public BoardVO() {
		super();
	}

	public BoardVO(String b_id, String b_title, String b_writer, String b_content, String b_reply, String u_id) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_content = b_content;
		this.b_reply = b_reply;
		this.u_id = u_id;
	}

	public BoardVO(String b_id, String b_title, String b_writer, String b_content, Date b_regdate, String b_reply,
			String u_id) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_content = b_content;
		this.b_regdate = b_regdate;
		this.b_reply = b_reply;
		this.u_id = u_id;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public Date getB_regdate() {
		return b_regdate;
	}

	public void setB_regdate(Date b_regdate) {
		this.b_regdate = b_regdate;
	}

	public String getB_reply() {
		return b_reply;
	}

	public void setB_reply(String b_reply) {
		this.b_reply = b_reply;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "BoardVO [b_id=" + b_id + ", b_title=" + b_title + ", b_writer=" + b_writer + ", b_content=" + b_content
				+ ", b_regdate=" + b_regdate + ", b_reply=" + b_reply + ", u_id=" + u_id + "]";
	}

}
