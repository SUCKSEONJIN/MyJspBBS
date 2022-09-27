package web.bbs.domain;

import java.nio.file.Files;
import java.nio.file.Path;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class ShopData {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
		
	private Long[] shopImgIds; 	
	
}
