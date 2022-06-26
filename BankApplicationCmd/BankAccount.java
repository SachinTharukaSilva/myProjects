import java.util.Scanner;
class BankAccount{
	String customerId;
	String name;
	double balance;
	double previousTransaction;
	
	BankAccount(String customerId, String name){
		this.customerId = customerId;
		this.name = name;
	}
	
	void deposit(double amount){
		this.balance += amount;
		previousTransaction = amount; 
		System.out.println(amount + " is Successfully Deposited!");
	}
	
	void withdraw(double amount){
		if(this.balance!=0){
			this.balance -= amount;
			previousTransaction = -amount;
			System.out.println(amount + " is Successfully Withdrawn!");
		}
	}
	void getPreviousTransaction(){
		if(previousTransaction > 0){
			System.out.println("Deposited : " + previousTransaction);
		}
		else if(previousTransaction < 0){
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else{
			System.out.println("No transaction");
		}
	}
	void start(){
		Scanner in = new Scanner(System.in);
		char option = '0';
		System.out.println("Welcome " + name);
		System.out.println("Your customer id : " + customerId);
		System.out.println();
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C Withdraw");
		System.out.println("D. Previous Transaction ");
		System.out.println("0. Exit");
		
		do{
			System.out.println("---------------------");
			System.out.print("Enter an option : ");
			option = in.next().charAt(0);
			System.out.println("---------------------");
			
			switch(option){
				case 'A':{
					System.out.println("Balance : " + balance);
					break;
				}
				case 'B':{
					System.out.print("Enter amount to deposit:");
					double amount = in.nextDouble();
					deposit(amount);
					System.out.println();
					break;
				}
				case 'C' : {
					System.out.print("Enter amount to wthraw :");
					double amount = in.nextDouble();
					withdraw(amount);
					System.out.println();
					break;
				}
				case 'D' : {
					getPreviousTransaction();
					break;
				}
				default:
					System.out.println("Invalid option");
					break;
			}
		} while (option!= '0');
		
		
	}  
}
