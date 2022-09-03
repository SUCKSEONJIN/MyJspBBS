package web.bbs.domain;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDTO {

	@NotNull
	private String email;
	
	@NotNull
	private String password;
}
