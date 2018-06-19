package projectImplementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Account implements IAccount
{
	String accountHolderName;
	private double accountBalance;
	private int accountNo;
	private int password;
	ArrayList<MiniStatement> statement = new ArrayList<MiniStatement>();
	ArrayList<PassBook> pstatement = new ArrayList<PassBook>();
	
	public Account(int accountNo, double accountBalance, String accountHolderName, int password)
	{
		this.accountBalance=0.00;
		this.accountHolderName=accountHolderName;
		this.accountNo= accountNo;
		this.password = password;
	}
	
	public void withdrawAmount(int amount)
	{
		if(amount<0.00||this.accountBalance<1.00)
		{
			System.out.println("Withdrawal not Possible....!!! ");
			return ;
		}
		else 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter PIN");
			while(true)
			{
				int pass = sc.nextInt();
				if(pass==this.password)
					break;
				System.out.println("<<<<Wrong PIN>>>>\nEnter PIN again...!!!");
			}
				LocalDate date = LocalDate.now();
				LocalTime time =LocalTime.now();
				this.accountBalance-=amount;
				System.out.println("Congratulations....!!!\nWithdrawal Successful..!!!!");
				System.out.println("Remaning Balance is : " + this.accountBalance);
				if(this.statement.size()>5)
					this.statement.remove(0);
				MiniStatement e = new MiniStatement("Debit", amount, time, date, this.accountBalance);
				statement.add(e);
				PassBook ps = new PassBook("Debit",this.accountBalance, amount, date, time);
				pstatement.add(ps);
		}
	}
	
	
	public void depositAmount(int amount)
	{
		if(amount<0.00)
			System.out.println("Negative Amount Error");
		else
		{
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			this.accountBalance+=amount;
			System.out.println("Amount successfully Deposited...!!!!");
			System.out.println("Updated Balance = : " + this.accountBalance);
			MiniStatement e = new MiniStatement("Credit", amount, time, date, this.accountBalance);
			if(statement.size()>4)	
				this.statement.remove(0);
			statement.add(e);
			PassBook ps = new PassBook("Credit",this.accountBalance, amount, date, time);
			pstatement.add(ps);
		}
		
	}
	
	public void getAccountDetails()
	{
		System.out.println("Account Holder Name : " + this.accountHolderName);
		System.out.println("Account Number :"+ this.accountNo);
		System.out.println("Account Balance : "+ this.accountBalance);
	}
	
	public void getMiniStatement()
	{
		System.out.println("Amount\t\tTransaction Type\t\tBalance\t\tTime\t\t\tDate");
		for(int i=0;i<statement.size();i++)
		{
			System.out.println(statement.get(i).transactionAmount+"\t\t"+statement.get(i).transcationType+"\t\t\t\t"+statement.get(i).balance +"\t\t"+statement.get(i).transactionTime+"\t\t"+statement.get(i).transactionDate);
		}
	}
	public void getPassBookStatement()
	{
		System.out.println("Amount\t\tTransaction Type\t\tBalance\t\t\tTime\t\t\tDate");
		for(int i=0;i<pstatement.size();i++)
		{
			System.out.println(pstatement.get(i).transactionAmount+"\t\t"+pstatement.get(i).transactiontype+"\t\t\t\t"+pstatement.get(i).balance+"\t\t\t"+pstatement.get(i).transactionTime+"\t\t"+pstatement.get(i).transactionDate);
		}
	}


	
}