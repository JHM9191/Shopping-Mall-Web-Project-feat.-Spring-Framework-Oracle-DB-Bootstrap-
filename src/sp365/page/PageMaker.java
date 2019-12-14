package sp365.page;

public class PageMaker {

	private int totalcount; // ��ü ��ǰ ����
	private int pagenum; // ���� ������ ��ȣ
	private int startRow;
	private int endRow;
	private int contentnum = 20; // �� �������� � ǥ������
	private int startPage = 1; // ���� ������ ����� ���� ������
	private int endPage = 10; // ���� ������ ����� ������ ������
	private boolean prev = false; // ���� �������� ���� ȭ��ǥ
	private boolean next = true; // ���� �������� ���� ȭ��ǥ
	private int currentblock;// ���� ������ ���
	private int lastblock; // ������ ������ ���

	public void prevnext(int pagenum) {
		if (pagenum > 0 && pagenum < 11) {
			setPrev(false);
			setNext(true);
		} else if (getLastblock() == getCurrentblock()) {
			setPrev(true);
			setNext(false);
		} else {
			setPrev(true);
			setNext(true);

		}
		System.out.println("prevnext()" + pagenum);
	}

	// ��ü ������ ���� ����ϴ� �޼ҵ�
	public int calcpage(int totalcount, int contentnum) {
		int totalpage = totalcount / contentnum;
		if (totalcount % contentnum > 0) {
			totalpage++;
		}
		System.out.println("calcpage()" + totalpage);
		return totalpage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
		System.out.println("setTotalcount()" + this.totalcount);
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
		System.out.println("setPagenum()" + this.pagenum);
	}

	public int getContentnum() {
		return contentnum;
	}

	public void setContentnum(int contentnum) {
		this.contentnum = contentnum;
		System.out.println("setContentnum" + this.contentnum);
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int pagenum) {
		this.startRow = (pagenum * this.contentnum) - (this.contentnum - 1);
		System.out.println("setStartRow()" + this.startRow);
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int pagenum) {
		this.endRow = pagenum * this.contentnum;
		System.out.println("setEndRow()" + this.endRow);
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int currentblock) {
		this.startPage = (currentblock * 10) - 9;
		System.out.println("setStartPage()" + this.startPage);
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int getlastblock, int getcurrentblock) {
		if (getlastblock == getcurrentblock) {
			this.endPage = calcpage(getTotalcount(), getContentnum());
		} else {
			this.endPage = getStartPage() + 9;
		}
		System.out.println("setEndPage()" + this.endPage);
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
		System.out.println(this.prev);
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
		System.out.println(this.next);
	}

	public int getCurrentblock() {
		return currentblock;
	}

	public void setCurrentblock(int pagenum) {
		this.currentblock = pagenum / 10;
		if (pagenum % 10 > 0) {
			this.currentblock++;
		}
		System.out.println("setCurrentblock()" + this.currentblock);
	}

	public int getLastblock() {
		return lastblock;
	}

	public void setLastblock(int totalcount) {
		this.lastblock = totalcount / (10 * this.contentnum);
		if (totalcount % (10 * this.contentnum) > 0) {
			this.lastblock++;
		}
		System.out.println("setLastblock" + this.lastblock);
	}

}
