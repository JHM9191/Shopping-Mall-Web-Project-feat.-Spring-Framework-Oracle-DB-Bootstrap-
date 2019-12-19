package sp365.vo;

public class InputVO {
	String search;

	
	public InputVO() {
		super();
	}


	public InputVO(String search) {
		super();
		this.search = search;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	@Override
	public String toString() {
		return "InputVO [search=" + search + "]";
	}
	
	
	
		
	

}
