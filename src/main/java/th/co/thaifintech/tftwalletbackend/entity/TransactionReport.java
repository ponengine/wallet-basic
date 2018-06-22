package th.co.thaifintech.tftwalletbackend.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import th.co.thaifintech.tftwalletbackend.constant.PayType;
@Getter
@Setter
@Entity
@Table(name="transactionreport")
public class TransactionReport implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "tran_id")
	private Long id;
	private String createDate;
	private int  moneyWallet;
	private String status;
	private String usernameBuyer;
	private String usernameSeller;
	
	public TransactionReport() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return String.format(
				"TransactionReport [id=%s, createDate=%s, moneyWallet=%s, status=%s, usernameBuyer=%s, usernameSeller=%s, user=%s]",
				id, createDate, moneyWallet, status, usernameBuyer, usernameSeller, user);
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
}
