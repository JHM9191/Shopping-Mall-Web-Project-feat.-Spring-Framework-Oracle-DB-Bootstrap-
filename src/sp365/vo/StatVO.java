package sp365.vo;

public class StatVO {
	String condition;
	int totSale;
	int period;

	public StatVO() {
		super();
	}

	public StatVO(String condition, int totSale) {
		super();
		this.condition = condition;
		this.totSale = totSale;
	}

	public StatVO(String condition, int totSale, int period) {
		super();
		this.condition = condition;
		this.totSale = totSale;
		this.period = period;
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

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "StatVO [condition=" + condition + ", totSale=" + totSale + ", period=" + period + "]";
	}

}
