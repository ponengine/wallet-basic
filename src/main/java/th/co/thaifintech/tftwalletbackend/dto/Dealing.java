package th.co.thaifintech.tftwalletbackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dealing {
	private String pin;
	private int price;
	private String username_buyer;
	private String username_seller;
	
}
