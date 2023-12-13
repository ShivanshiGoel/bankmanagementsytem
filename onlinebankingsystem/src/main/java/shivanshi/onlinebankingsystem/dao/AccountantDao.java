package shivanshi.onlinebankingsystem.dao;

import shivanshi.onlinebankingsystem.entity.Accountant;
import shivanshi.onlinebankingsystem.exception.AccountantException;
import shivanshi.onlinebankingsystem.exception.CustomerException;

public interface AccountantDao {

	public Accountant LoginAccountant( String accountantUsername, String accountantPassword) throws AccountantException ;
	
	public int addCustomer (String customerName,String customerMail, 
			String customerPassword, String customerMobile, String customerAddress  ) throws CustomerException;
	 
	public String addAccount( int customerBalance, int  cid) throws CustomerException;
	
	 public String deleteAccount( int customerAccountNumber) throws CustomerException;
	
	
}
