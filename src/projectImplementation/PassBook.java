package projectImplementation;

import java.time.LocalDate;
import java.time.LocalTime;

public class PassBook
{
	LocalDate transactionDate;
	LocalTime transactionTime;
	double balance;
	int transactionAmount;
	String transactiontype;
	
	public PassBook(String type, double balance, int amount, LocalDate date, LocalTime time)
	{
		this.balance = balance;
		this.transactionAmount=amount;
		this.transactionTime = time;
		this.transactiontype=type;
		this.transactionDate = date;
	}
	
}
