package cn.hfxt.entity;

import java.util.List;

public class smbms_bill_page {
	
	private int pageNo;	//当前页码
	private int pageTotal; //总页码
	private int pageTotalCount; //总记录数
	private int pageSize=6; //每页显示数量
	private List<smbms_zd> items; //当前页显示数据

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		if(pageTotalCount>0){
			this.pageTotalCount = pageTotalCount;
			pageTotal=(this.pageTotalCount % pageSize==0)?(this.pageTotalCount/pageSize):(this.pageTotalCount/pageSize)+1 ;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<smbms_zd> getItems() {
		return items;
	}
	public void setItems(List<smbms_zd> items) {
		this.items = items;
	}
	
}
