package web.bbs.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BbsData {
	private String title;
	private String text;
	private String author;
	private String time;
	private Integer good;
	private Long id;
	public BbsData() {
		
	}
	
	public BbsData(String title, String text, String author, String time, Integer good ) {
		this.title = title;
		this.text = text;
		this.author=author;
		this.time = time;
		this.good = good;
	}
}
