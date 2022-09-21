package web.bbs.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDTO {

	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@Length(min = 8, max = 12, message="비번은 8~15자리수로 입력해주세요")
	private String password;
}
