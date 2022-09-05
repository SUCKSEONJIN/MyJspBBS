package web.bbs.domain;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
	
	@NotBlank
	private String name;
	
	@NotNull	
	private Integer age;
	
	@NotEmpty
	@Length(min=6, max=12, message = "아이디는 6~12자리로 만들어주세요")
	private String userId;
		
	private Long id;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Length(min=8, max=15, message = "비번은 8~15자리수로 입력해주세요")
	private String password;
	
	
	private List<BbsData> texts;
	
	public Member(String name, Integer age, String eamil, String password, String userId) {
		this.name = name;
		this.age = age;
		this.email = eamil;
		this.password = password;
		this.userId = userId;
	}
	
	public Member() {
		
	}
}
