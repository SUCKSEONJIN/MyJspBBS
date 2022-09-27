package web.bbs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonAlias;



@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class BbsApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void WhenTestApp_thenEmptyResponse() throws
	Exception{
		this.mockMvc.perform(get("/foos")).andExpect(status().isOk()).andExpect(null);
			
	
	}


}