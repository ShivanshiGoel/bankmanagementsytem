package shivanshi.onlinebankingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shivanshi.onlinebankingsystem.databaseconnection.DatabaseConnection;
import shivanshi.onlinebankingsystem.entity.Customer;
import shivanshi.onlinebankingsystem.exception.CustomerException;

public class CustomerDaoImplements implements CustomerDao{

	@Override
	public Customer LoginCustomer(String customerUsername, String customerPassword, int customerAccountNumber)
			throws CustomerException {
		
		Customer customer =null;
		try(Connection conn = DatabaseConnection.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on i.cid = a.cid where customerName = ? and customerPassword = ? and customerAccountNumber =? ");
		ps.setString(1,  customerUsername);
		ps.setString(2,  customerPassword);
		ps.setInt(3, customerAccountNumber);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int ac = rs.getInt("customerAccountNumber");
			String n = rs.getString("customerName");
			int b = rs.getInt("customerBalance");
			String e= rs.getString("customerMail");
			String p =rs.getString("customerPasword");
			String m = rs.getString("customerMobile");
			String ad = rs.getString("customerAddress");
			
			customer = new Customer(ac, n , b ,e , p , m, ad);
			
		}
		
		else {
				
				throw new CustomerException("invalid customer name and password");
				
				
		}
		}
		catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		
		return customer;
	}

	@Override
	public int Deposit(int customerAccountNumber, int amount) throws CustomerException {
		
		int b =-1;
		try (Connection conn =DatabaseConnection.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update account set customerBalance = customerBalance+ ? where customerAccountNumber =?");
		
		ps.setInt(1,  amount);
		ps.setInt(2,  customerAccountNumber);
		int rs =ps.executeUpdate();
		
		}
		catch(SQLException e) {
			
			throw new CustomerException(e.getMessage());
		}
		
		
		return 0;
	}

	
	
	
	
}
