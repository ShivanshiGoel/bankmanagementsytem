package shivanshi.onlinebankingsystem;

import java.util.Scanner;

import shivanshi.onlinebankingsystem.dao.AccountantDao;
import shivanshi.onlinebankingsystem.dao.AccountantDaoImplementation;
import shivanshi.onlinebankingsystem.dao.CustomerDao;
import shivanshi.onlinebankingsystem.dao.CustomerDaoImplements;
import shivanshi.onlinebankingsystem.entity.Accountant;
import shivanshi.onlinebankingsystem.entity.Customer;
import shivanshi.onlinebankingsystem.exception.CustomerException;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean f = true;
        while (f) {
            System.out.println("...........WELCOME TO THE ONLINE BANKING SYSTEM...........");
            System.out.println(".....................................");
            System.out.println("1.ADMIN LOGIN PORTAL\r\n" + "2.customer");

            System.out.println("Choose your option");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Admin Login Credentials.....................Accountant");
                    System.out.println("Enter Username:");
                    String username = sc.next();
                    System.out.println("Enter password:");
                    String pass = sc.next();

                    AccountantDao ad = new AccountantDaoImplementation();

                    try {
                        Accountant a = ad.LoginAccountant(username, pass);
                        if (a == null) {
                            System.out.println("wrong Credentials");
                            break;
                        }

                        System.out.println("Login Successfully completed");
                        System.out.println(
                                "Welcome to: " + a.getAccountantUsername() + "'s Admin of Online Banking System");

                        boolean y = true;

                        while (y) {
                            System.out.println(".................\r\n" + "1. Add new customer account \r\n"
                                    + "2.remove account by account number\r\n");
                            int x = sc.nextInt();

                            if (x == 1) {
                                System.out.println(".............New account........");
                                System.out.println("enter customername:");
                                String a1 = sc.next();

                                System.out.println("Enter Account opening balance");
                                int a2 = sc.nextInt();

                                System.out.println("enter customer Mail:");
                                String a3 = sc.next();
                                System.out.println("enter customer Password:");
                                String a4 = sc.next();
                                System.out.println("enter customer mobile :");
                                String a5 = sc.next();
                                System.out.println("enter customer address:");
                                String a6 = sc.next();

                                int s1 = -1;

                                try {
                                    s1 = ad.addCustomer(a1, a3, a4, a5, a6);
                                    try {

                                        ad.addAccount(a2, s1);
                                    } catch (CustomerException e) {
                                        e.printStackTrace();
                                    }

                                    System.out.println("Customer added successfully");
                                } catch (CustomerException e) {
                                    System.out.println(e.getMessage());
                                }

                                System.out.println(".........................");
                            }
                            if (x == 2) {
                            	System.out.println(".............remove account..........");
                            	System.out.println("enter account number:");
                            	int ac = sc.nextInt();
                            	String s =null;
                            	try {
                            		s = ad.deleteAccount(ac);
                            	}
                            	
                            	catch (CustomerException e) {
                            		e.printStackTrace();
                            	}
                            	
                            	if (s!=null) {
                            		System.out.println(s);
                            	}
                            	
                            }
                             break;
                        }
                   
                    
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    break;
                    
                    

                case 2:
                    System.out.println("login .................................customer");
                    System.out.println("...............");
                    System.out.println("Enter user name:");
                    String customerUsername = sc.next();
                     System.out.println("enter password:");
                    String customerPassword = sc.next();
                    System.out.println("enter account numer:");
                    int accountNumber = sc.nextInt();
                    
                    CustomerDao cd = new CustomerDaoImplements();
                    
                    try {
                    	Customer cus = cd.LoginCustomer(customerUsername, customerPassword, accountNumber);
                    	System.out.println ("wecome : "+ cus.getCustomerName());
                    	
                    	
                    	boolean n = true;
                    	
                    	while (n) {
                    	
                    		System.out.println(".............................\r\n"+ "1.View balance\r\n" + "2.deposit money \r\n"+ " 3.withdraw money\r\n");
                    		
                    		int x = sc.nextInt();
                    		
                    		if(x ==1) {
                    			System.out.println("...........balance............");
                    			System.out.println("current account balance........");
                    			System.out.println("......................");
                    			
                    		}
                    		
                    		if (x==2) {
                    			
                    			System.out.println("...........deposit");
                    			System.out.println("enter the amount to deposit");
                    			int an = sc.nextInt();
                    			cd.Deposit(accountNumber,  an);
                    			System.out.println("your balance after the deposit");
                    			System.out.println(cd.viewBalance(accountNumber));
                    			System.out.println("......................");
                    			
                    		}
                    		
                    		if(x==3) {
                    			System.out.println("............withdraw money............");
                    			System.out.println("enter withdrawal amount");
                    			int an = sc.nextInt();
                    			try {
                    				cd.withdraw(accountNumber,  an);
                    				System.out.println("your balance after withdrawl ......");
                    				System.out.println(cd.viewBalance(accountNumber));
                    				System.out.println(".........................");
                    				
                    			}
                    			
                    			catch(CustomerException e) {
                    				System.out.println(e.getMessage());
                    			}
                    		}
                    		
                    	}
                    
                    }
                    
                    catch (Exception e) {
                    	
                    	
                    }
                    

                    
                    break;
            }
        }
    }
}
