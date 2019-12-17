package sp365.vo;

public class StatVO {
	String condition;
	int totSale;

	public StatVO() {
		super();
	}

	public StatVO(String condition, int totSale) {
		super();
		this.condition = condition;
		this.totSale = totSale;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getTotSale() {
		return totSale;
	}

	public void setTotSale(int totSale) {
		this.totSale = totSale;
	}

	@Override
	public String toString() {
		return "StatVO [condition=" + condition + ", totSale=" + totSale + "]";
	}

}
