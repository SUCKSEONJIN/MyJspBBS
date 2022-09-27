package web.bbs.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class Example {
	private Long id;
	@JsonAlias 
	private String docs;
}
