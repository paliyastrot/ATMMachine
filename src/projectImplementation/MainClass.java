package projectImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MainClass
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Name to open Account");
		String name  = scan.nextLine();
		Random rand = new Random();
		int accountNo = rand.nextInt(1000000);
		System.out.println("Enter Transaction PIN for your account");
		int password = scan.nextInt();
		Map<Integer, Account> map = new HashMap<Integer, Account>();
		Account acc = new Account(accountNo, 0.00, name, password);
		map.put(accountNo, acc);
		while(true)
		{
			System.out.println("1.Account Details\n2.Deposit Amount\n3.Withdraw Amount\n4.Get Mini Statement\n5.Get PassBook\n6.Exit");
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("<<<Account Details>>>");
				acc.getAccountDetails();
				break;
			case 2:
				System.out.println("Enter Amount to be deposited :  ");
				int amount =scan.nextInt();
				acc.depositAmount(amount);
				break;
			case 3:
				System.out.println("Enter the amount : ");
				int amt = scan.nextInt();
				acc.withdrawAmount(amt);
				break;
			case 4:
				acc.getMiniStatement();
				break;
			case 5:
				acc.getPassBookStatement();
				break;
			case 6:
				System.out.println("<><>EXITING<><>");
				System.exit(0);
			}
		}
	}

}
