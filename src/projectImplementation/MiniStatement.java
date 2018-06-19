package projectImplementation;

import java.time.LocalDate;
import java.time.LocalTime;

public class MiniStatement 
{
	String transcationType;
	int transactionAmount;
	LocalTime transactionTime;
	double balance;
	LocalDate transactionDate;
	
	public MiniStatement(String transactionType, int transactionAmount, LocalTime Time, LocalDate Date, double balance)
	{
		this.transcationType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = Date;
		this.transactionTime = Time;
		this.balance= balance;
	}
}
