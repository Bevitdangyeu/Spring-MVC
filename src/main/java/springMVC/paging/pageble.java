package springMVC.paging;

public interface pageble {
	int getPage();
	int getLimit();
	int getOffset();
	Sort getSort();
}
