package th.co.thaifintech.tftwalletbackend.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import th.co.thaifintech.tftwalletbackend.constant.PayType;
@Getter
@Setter
public class TransactionReportDTO {

	private Long id;
	private String createDate;
	private int  moneyWallet;
	private String status;
	private String usernameBuyer;
	private String usernameSeller;
}
