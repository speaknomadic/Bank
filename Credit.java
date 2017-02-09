package bank;

public class Credit extends BaseProduct {

	private int monthlyFee = 0;

	public Credit(String account, double annualInterest, int period, long balance) {
		super(account, annualInterest, period, balance);
		this.monthlyFee = (int) (balance * annualInterest / 100 / 12 + 0.5);
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	@Override
	public String toString() {
		return "Credit [monthlyFee=" + monthlyFee + "]" + super.toString();
	}

	public void update() {
		monthlyFee = (int) (getBalance() * getAnnualInterest() / 100 / 12 + 0.5);
	}

}
