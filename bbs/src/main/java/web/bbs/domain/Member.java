package web.bbs.domain;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
	
	@NotBlank
	private String name;
	
	@NotNull	
	private int age;
	
	@NotEmpty
	private Long id;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private List<BbsData> texts;
	
	public Member(String name, int age, String eamil, String password) {
		this.name = name;
		this.age = age;
		this.email = eamil;
		this.password = password;
	}
	
	public Member() {
		
	}
}
