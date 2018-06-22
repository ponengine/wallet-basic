package th.co.thaifintech.tftwalletbackend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="wallet")
public class Wallet {
	
	
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	private Long id;
	private int walletMoney;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "wallet")
	private User user;
}
