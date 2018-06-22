/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.thaifintech.tftwalletbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Proxy;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Dev
 */
@Setter
@Getter
@Entity
@Table(name="user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue
    private Long id;


    private String name;
   
    private String username;
    
 
    private String password;  
    
    private String createDate;
 
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}


    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    //@JoinColumn(name = "wallet_id")
    private Wallet wallet;
    
    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="user")
//    @JoinColumn(name = "tran_id")
    private List<TransactionReport> TransactionReport;
    
}
