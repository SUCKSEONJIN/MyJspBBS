package web.bbs.domain;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BbsData {
	
	@NotBlank(message = "제목을 적어주세요")
	private String title;
	
	@NotBlank(message = "내용을 적어주세요")
	private String text;
	
	@NotBlank
	private String author;
		
	private String time;
	
	
	private Integer views = 0;
		
	private Long id;
	public BbsData() {
		
	}
	
	public BbsData(String title, String text, String author, String time, Integer views ) {
		this.title = title;
		this.text = text;
		this.author=author;
		this.time = time;
		this.views = views;
	}
}
