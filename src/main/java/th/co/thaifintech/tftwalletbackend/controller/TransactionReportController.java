package th.co.thaifintech.tftwalletbackend.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import th.co.thaifintech.tftwalletbackend.dto.TransactionReportDTO;
import th.co.thaifintech.tftwalletbackend.entity.TransactionReport;
import th.co.thaifintech.tftwalletbackend.entity.User;
import th.co.thaifintech.tftwalletbackend.repository.TransactionReportRepository;
import th.co.thaifintech.tftwalletbackend.repository.UserRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionReportController {
	@Autowired
	private TransactionReportRepository transactionReportRepository;
	@Autowired
	private UserRepository UserRepository;
	@GetMapping("/getallbyuser")
	public List<TransactionReportDTO> getTransaction(@RequestParam("username") String username){
	
		User user= UserRepository.findByUsername(username);
		
		List<TransactionReportDTO> tran_reportDtos= new ArrayList<>();
		System.out.println(user.getId());
//        for (TransactionReport transactionReport : transactionReportRepository.findByUser(user)) {
//        	TransactionReportDTO tran_report = new TransactionReportDTO();
//            try {
//                BeanUtils.copyProperties(tran_report, transactionReport);
//                tran_reportDtos.add(tran_report);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
		return tran_reportDtos;
	}
	@GetMapping("/getalltran")
	public List<TransactionReportDTO> getalltransaction(){
		ModelMapper modelMapper = new ModelMapper();
	  List<TransactionReportDTO> tranReportDtos= new ArrayList<>();
      for (TransactionReport transactionReport : transactionReportRepository.findAll()) {
    	   TransactionReportDTO tranReport = new TransactionReportDTO();
        try {
        	tranReport = modelMapper.map(transactionReport, TransactionReportDTO.class);
            tranReportDtos.add(tranReport);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }return tranReportDtos;
	}
	@GetMapping("/gettrantoday")
	public List<TransactionReportDTO> gettran_today(String today){
	List<TransactionReportDTO> tran_reportDtos= new ArrayList<>();
//        for (TransactionReport transactionReport : transactionReportRepository.findByCreateDate(today)) {
//        	TransactionReportDTO tran_report = new TransactionReportDTO();
//            try {
//                BeanUtils.copyProperties(tran_report, transactionReport);
//                tran_reportDtos.add(tran_report);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
        return tran_reportDtos;
	}
}
