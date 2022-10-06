package web.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BbsDataCond {
	private String title;
	private String author;
	private String searchType; 
	private String search;
	private String viewType;
	
	@Override
	public String toString() {
		
		return "[ title = "+ getTitle() + " author = " + getAuthor() + 
				" searchType = " + getSearchType() + " search = " + getSearch() + " ]";
	}
}
