package dao;

public class PageBean {
private Integer PageNumber;//1
Integer PageLimit;//5
Integer Pagelow;//(pagenumber-1)*5+1
Integer Pagecol;//pagelow+pagelimit-1

Integer total;//sql 게시물갯수


Integer PageCount;//4

Integer PageStart;//(pagenumber-1)/4*4+1
Integer PageEnd;//pagestart+pagecount-1


Integer PagetotalCount;//pagecount/total if(나머지가있다면 +1)//필요없음
Integer totalPage;//pagelimit/total if(나머지가 있다면 +1)
public PageBean() {}
public PageBean(int pagenumber,int total) {
	// TODO Auto-generated constructor stub
	
	this.PageNumber = 1;
	if(pagenumber !=1)
	{
		setPageNumber(pagenumber);
	}
	this.PageLimit =5;
	this.Pagelow = (PageNumber-1)*PageLimit+1;
	this.Pagecol = Pagelow+PageLimit-1;
    
	this.PageCount = 4;
	this.PageStart =(PageNumber-1)/4*4+1;
	this.PageEnd = PageStart+PageCount-1;
	
	this.total=total;
	
	this.totalPage = total/PageLimit;    
	if(total%PageLimit != 0)
	{
		this.totalPage+=1;
	}
	if(totalPage <PageEnd)
	{
		this.PageEnd=totalPage;
	}
	this.PagetotalCount = total/PageCount;
	
}

public int getPageNumber() {
	return PageNumber;
}


public void setPageNumber(int pageNumber) {
	PageNumber = pageNumber;
}


public int getPageLimit() {
	return PageLimit;
}


public void setPageLimit(int pageLimit) {
	PageLimit = pageLimit;
}


public int getPagelow() {
	return Pagelow;
}


public void setPagelow(int pagelow) {
	Pagelow = pagelow;
}


public int getPagecol() {
	return Pagecol;
}


public void setPagecol(int pagecol) {
	Pagecol = pagecol;
}


public int getTotal() {
	return total;
}


public void setTotal(int total) {
	this.total = total;
}


public int getTotalPage() {
	return totalPage;
}


public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}


public int getPageCount() {
	return PageCount;
}


public void setPageCount(int pageCount) {
	PageCount = pageCount;
}


public int getPageStart() {
	return PageStart;
}


public void setPageStart(int pageStart) {
	PageStart = pageStart;
}


public int getPageEnd() {
	return PageEnd;
}


public void setPageEnd(int pageEnd) {
	PageEnd = pageEnd;
}


public int getPagetotalCount() {
	return PagetotalCount;
}


public void setPagetotalCount(int pagetotalCount) {
	PagetotalCount = pagetotalCount;
}

}

