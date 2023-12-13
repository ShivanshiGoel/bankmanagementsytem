package shivanshi.onlinebankingsystem.dao;

import shivanshi.onlinebankingsystem.entity.Customer;
import shivanshi.onlinebankingsystem.exception.CustomerException;

public interface CustomerDao {

	public Customer LoginCustomer(String customerUsername, String customerPassword,int customerAccountNumber)throws CustomerException;
	
	public int viewBalance (int customerAccountNumber) throws CustomerException; 
	
	public int Deposit(int customerAccountNumber, int amount) throws CustomerException;
	
	
	public int withdraw(int customerAccountNumber, int amount) throws CustomerException; 
	
	
}
