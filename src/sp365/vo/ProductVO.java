package sp365.vo;

import java.util.Date;

public class ProductVO {
	private String p_id;
	private String p_name;
	private int p_price;
	private int p_discount;
	private int p_price_sale;
	private int p_price_org;
	private int p_margin;
	private int p_stock;
	private String p_size;
	private String p_new;
	private String p_best;
	private String p_delivery_day;
	private String p_category;
	private String img_id;
	private Date p_regdate;

	public ProductVO() {
		super();
	}

	public ProductVO(String p_id, String p_name, int p_price, int p_discount, int p_price_sale, int p_price_org,
			int p_margin, int p_stock, String p_size, String p_new, String p_best, String p_delivery_day,
			String p_category, String p_img_id, Date p_regdate) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_discount = p_discount;
		this.p_price_sale = p_price_sale;
		this.p_price_org = p_price_org;
		this.p_margin = p_margin;
		this.p_stock = p_stock;
		this.p_size = p_size;
		this.p_new = p_new;
		this.p_best = p_best;
		this.p_delivery_day = p_delivery_day;
		this.p_category = p_category;
		this.img_id = p_img_id;
		this.p_regdate = p_regdate;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_discount() {
		return p_discount;
	}

	public void setP_discount(int p_discount) {
		this.p_discount = p_discount;
	}

	public int getP_price_sale() {
		return p_price_sale;
	}

	public void setP_price_sale(int p_price_sale) {
		this.p_price_sale = p_price_sale;
	}

	public int getP_price_org() {
		return p_price_org;
	}

	public void setP_price_org(int p_price_org) {
		this.p_price_org = p_price_org;
	}

	public int getP_margin() {
		return p_margin;
	}

	public void setP_margin(int p_margin) {
		this.p_margin = p_margin;
	}

	public int getP_stock() {
		return p_stock;
	}

	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}

	public String getP_new() {
		return p_new;
	}

	public void setP_new(String p_new) {
		this.p_new = p_new;
	}

	public String getP_best() {
		return p_best;
	}

	public void setP_best(String p_best) {
		this.p_best = p_best;
	}

	public String getP_delivery_day() {
		return p_delivery_day;
	}

	public void setP_delivery_day(String p_delivery_day) {
		this.p_delivery_day = p_delivery_day;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_img_id() {
		return img_id;
	}

	public void setP_img_id(String p_img_id) {
		this.img_id = p_img_id;
	}

	public Date getP_regdate() {
		return p_regdate;
	}

	public void setP_regdate(Date p_regdate) {
		this.p_regdate = p_regdate;
	}

	@Override
	public String toString() {
		return "ProductVO [p_id=" + p_id + ", p_name=" + p_name + ", p_price=" + p_price + ", p_discount=" + p_discount
				+ ", p_price_sale=" + p_price_sale + ", p_price_org=" + p_price_org + ", p_margin=" + p_margin
				+ ", p_stock=" + p_stock + ", p_size=" + p_size + ", p_new=" + p_new + ", p_best=" + p_best
				+ ", p_delivery_day=" + p_delivery_day + ", p_category=" + p_category + ", p_img_id=" + img_id
				+ ", p_regdate=" + p_regdate + "]";
	}

}
