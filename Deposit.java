package bank;

public class Deposit extends BaseProduct {

	private int monthlyPayment = 0;

	public Deposit(String account, double annualInterest, int period, long balance) {
		super(account, annualInterest, period, balance);
		this.monthlyPayment = (int) ((balance * annualInterest / 100) / 12);
	}

	public Deposit(Deposit original) {
		super((BaseProduct) original);

		this.monthlyPayment = original.monthlyPayment;
	}

	public int getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(int monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	@Override
	public String toString() {
		return "Deposit [monthlyPayment=" + monthlyPayment + "]" + super.toString();
	}

	public void update() {
		monthlyPayment = (int) ((getBalance() * getAnnualInterest() / 100) / 12);
	}
	
	public double calculateInterest(Deposit d){
		return d.getAnnualInterest();
		
	}

}
