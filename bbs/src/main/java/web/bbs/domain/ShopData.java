package web.bbs.domain;

import java.nio.file.Files;
import java.nio.file.Path;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ShopData {

	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String userId;
	@NotBlank
	private String location;
	
	private String time;
	@NotBlank
	private String text;
	@NotNull	
	private Long[] shopImgId; 	
	
}
