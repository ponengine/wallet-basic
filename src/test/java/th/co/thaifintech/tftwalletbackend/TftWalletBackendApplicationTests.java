package th.co.thaifintech.tftwalletbackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import th.co.thaifintech.tftwalletbackend.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TftWalletBackendApplicationTests {

	@Test
	public void whenSerializingUsingJsonAnyGetter_thenCorrect()
	  throws JsonProcessingException {
	  
	    User bean = new User();
	    bean.setId(1L);
	    bean.setName("Nathapon");
	    bean.setPassword("P@ssw0rd");
	 
	    String result = new ObjectMapper().writeValueAsString(bean);
	    System.out.println(result);
	   
	}

}
