package web.bbs.domain;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BbsData {
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String text;
	
	@NotBlank
	private String author;
	
	@NotBlank
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
