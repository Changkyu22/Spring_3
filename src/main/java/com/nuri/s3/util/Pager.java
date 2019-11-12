package com.nuri.s3.util;

public class Pager {

	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	private String kind;
	private String search;
	private Integer startRow;
	private Integer lastRow;
	

	public Integer getPerPage() {
		if(perPage == null || perPage == 0) {
			this.perPage = 10;
		}
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}

	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getLastRow() {
		return lastRow;
	}

	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public Integer getCurPage() {
		if (this.curPage == null) {
			this.curPage = 1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
	public void makeRow() {
		// rownum 계산
		this.startRow = (this.getCurPage()-1) * this.getPerPage() + 1;
		this.lastRow = this.getCurPage() * this.getPerPage();
	}
	

	public void makePager(int totalCount) {
		// 1. 전체 글의 개수 (totalCount)
		// 매개변수로 int totalCount를 받아옴

		// 2. 전체 페이지의 개수
		int totalPage = totalCount / perPage;
		if (totalCount % this.getPerPage() != 0) {
			totalPage++;
		}

		// 3. 전체 블럭의 개수
		int perBlock = 5;
		totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		// 4. curPage를 이용해서 curBlock(현재 블럭번호)가 몇번인지 알아오기
		curBlock = this.getCurPage() / perBlock;
		if (this.getCurPage() % perBlock != 0) {
			curBlock++;
		}

		// 5. curBlock으로 startNum과 lastNum 구하기
		startNum = (curBlock - 1) * perBlock + 1;

		lastNum = curBlock * perBlock;
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}

	}

}
