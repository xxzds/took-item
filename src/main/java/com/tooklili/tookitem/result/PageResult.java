package com.tooklili.tookitem.result;

import java.util.List;
import com.google.common.collect.Lists;

public class PageResult<T> extends BaseResult {

    private static final long serialVersionUID = 1453224020829563569L;

    private long               totalCount;
    private int               pageSize;
    private int               currentPage;
    
    private List<T>           data             = Lists.newArrayList();
    
    public PageResult(){
    	super();
    }

    public PageResult(int currentPage, int pageSize) {
        this(currentPage,pageSize,0);
    }
    
    public PageResult(int currentPage, int pageSize,int totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount=totalCount;
    }

    public long getTotalCount() {
        return totalCount;
    }
    
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	/*************************匹配long类型***************************/
    public PageResult(long currentPage, long pageSize) {
        this((int)currentPage,(int)pageSize,0);
    }
    
    public PageResult(long currentPage, long pageSize,long totalCount) {
        this((int)currentPage,(int)pageSize,(int)totalCount);
    } 
    public void setTotalCountLong(long totalCount) {
        this.totalCount = (int)totalCount;
    }   
}
