package com.spring.command;

public class SearchCriteria extends Criteria {
	
	private String searchType="";;
	private String keyword="";;
	// 처음 리스트를 출력할 때 searchType/keyword의 parameter값이 null이기 때문에
	// sql에서 오류가 날 수 있는 것을 방지하기 위해 빈 스트링을 삽입

	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
