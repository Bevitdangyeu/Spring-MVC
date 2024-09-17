package springMVC.paging;

public class PageRequest implements pageble {
	private int page;
	private int limit;
	private Sort sort;
	
	public PageRequest(int page, int limit, int offset, Sort sort) {
		this.page = page;
		this.limit = limit;
		this.sort = sort;
	}
	@Override
	public int getPage() {
		return this.page;
	}
	@Override
	public int getLimit() {
		return this.limit;
	}
	@Override
	public int getOffset() {
		return (this.page-1)*limit;
	}
	@Override
	public Sort getSort() {
		return this.sort;
	}
	
	
}
