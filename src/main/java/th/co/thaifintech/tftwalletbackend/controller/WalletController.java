package th.co.thaifintech.tftwalletbackend.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.co.thaifintech.tftwalletbackend.constant.PayType;
import th.co.thaifintech.tftwalletbackend.dto.Dealing;
import th.co.thaifintech.tftwalletbackend.entity.TransactionReport;
import th.co.thaifintech.tftwalletbackend.entity.User;
import th.co.thaifintech.tftwalletbackend.repository.TransactionReportRepository;
import th.co.thaifintech.tftwalletbackend.repository.UserRepository;
import th.co.thaifintech.tftwalletbackend.repository.WalletRepository;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private WalletRepository walletRepository;
	@Autowired
	private TransactionReportRepository transactionReportRepository;
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private static LocalDateTime local =LocalDateTime.now();
	
	@PostMapping("/add")
	public String addWallet(@RequestBody Dealing addwallet){
		User user = userrepository.findByUsername(addwallet.getUsername_buyer());
		if(user==null){
			return "User not found";
		}
	
		user.getWallet().setWalletMoney(user.getWallet().getWalletMoney()+addwallet.getPrice());
		List<TransactionReport> tran_lsit= new ArrayList<>();
		TransactionReport tran_report=new TransactionReport();
		tran_report.setCreateDate(formatter.format(local));
		tran_report.setMoneyWallet(addwallet.getPrice());
		tran_report.setStatus(PayType.ADD.toString());
		tran_report.setUsernameBuyer(user.getName());
		tran_report.setUser(user);
		tran_lsit.add(tran_report);
		user.setTransactionReport(tran_lsit);
		userrepository.save(user);
		return "Success";
	}
	
	@PostMapping("/exchange")
	public String exchangeWallet(@RequestBody Dealing dealer){
		User buyer = userrepository.findByUsername(dealer.getUsername_buyer());
		if(buyer==null){
			return "User not found";
		}
		
		User seller = userrepository.findByUsername(dealer.getUsername_seller());
		
		if(seller==null){
			return "User not found";
		}
		buyer.getWallet().setWalletMoney(buyer.getWallet().getWalletMoney()-dealer.getPrice());
		
		seller.getWallet().setWalletMoney(seller.getWallet().getWalletMoney()+dealer.getPrice());
		
		List<TransactionReport> tran_lsit= new ArrayList<>();
		TransactionReport tran_report=new TransactionReport();
		tran_report.setCreateDate(formatter.format(local));
		tran_report.setMoneyWallet(dealer.getPrice());
		tran_report.setStatus(PayType.EXCHANGE.toString());
		tran_report.setUsernameBuyer(buyer.getName());
		tran_report.setUsernameSeller(seller.getName());
		tran_lsit.add(tran_report);
		buyer.setTransactionReport(tran_lsit);
		seller.setTransactionReport(tran_lsit);
		userrepository.save(buyer);
		userrepository.save(seller);
		return "Success";
	}
}
