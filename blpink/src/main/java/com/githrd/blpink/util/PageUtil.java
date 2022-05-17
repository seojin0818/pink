package com.githrd.blpink.util;

public class PageUtil {
	private int nowPage = 1;
	private int totalCount;
	
	private int pageRow = 3;
	private int pageGroup = 3;
	
	private int startPage; // 현재 페이지에서 보여줄 시작 페이지
	private int endPage;
	
	private int startCont;
	private int endCont;
	
	private int totalPage = 1;

	public PageUtil() {}
	public PageUtil(int nowPage, int totalCount) {
		this(nowPage, totalCount, 3, 3);
	}
	
	public PageUtil(int nowPage, int totalCount, int pageRow, int pageGroup) {
		this.nowPage = nowPage;
		this.totalCount = totalCount;
		this.pageRow = pageRow;
		this.pageGroup = pageGroup;
		
		setTotalPage();
		setStartPage();
		setEndPage();
		setCont();
	}
	
	// 총 페이지 수 계산하는 함수
	public void setTotalPage() {
		// 총 페이지 수 = 총 게시물 수 / 한 화면에 표시할 게시물 수(pageRow)
		totalPage = (totalCount % pageRow == 0) ? (totalCount == 0 ? 1 : (totalCount / pageRow)) : (totalCount / pageRow + 1);
		// 총 게시물 수 / 한 화면에 표시할 게시물 수가 나눠떨어지면
		// 		총 게시물 수 / 한 화면에 표시할 게시물 수로 계산하고
		// 		총 게시물 수가 0일 때는 1페이지를 띄우기
		// 총 게시물 수 / 한 화면에 표시할 게시물 수가 나눠떨어지지 않으면
		//		총 게시물 수 / 한 화면에 표시할 게시물 수 + 1로 계산하기
	}
	
	// 시작 페이지 계산해주는 함수
	public void setStartPage() {
		// 현재 페이지에서 -1을 해주고 거기에 한 화면에 보여질 이동 가능한 페이지 수로 나누기
		// 몫을 같게 만들기 위해서 -1을 해주는 것
		// 10	11	12
		
		int tmp = (nowPage - 1) / pageGroup;
		
		startPage = tmp * pageGroup + 1;
	}
	
	// 종료 페이지 계산 함수
	public void setEndPage() {
		// 현재 보고 있는 페이지 그룹을 계산하고
		int tmp = (nowPage -1) / pageGroup;
		endPage = (tmp + 1) * pageGroup;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}
	
	// 시작과 게시물 번호를 계산해주는 함수
	public void setCont() {
		/*
		 	
		 	현재 8페이지를 보고 있는 경우 시작 게시글 번호는
		 	7페이지의 마지막 게시글 번호 + 1
		 	현재 8페이지를 보고 있는 경우 마지막 게시글 번호는
		 	현재 페이지 * 한 페이지당 보여질 게시글 수
		 	
		 	주의 ]
		 	
		 		마지막 게시글 번호가 총 게시글 수보다 크면 안 됨
		 		
		 */
		
		startCont = (nowPage -1) * pageRow + 1;
		endCont = nowPage * pageRow > totalCount ? totalCount : nowPage * pageRow;
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageRow() {
		return pageRow;
	}
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}
	public int getPageGroup() {
		return pageGroup;
	}
	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartCont() {
		return startCont;
	}
	public void setStartCont(int startCont) {
		this.startCont = startCont;
	}
	public int getEndCont() {
		return endCont;
	}
	public void setEndCont(int endCont) {
		this.endCont = endCont;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
