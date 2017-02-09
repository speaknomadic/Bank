package bank;

abstract class BaseProduct {

	private String account = "";
	private double annualInterest = 0;
	private int period = 0;
	private long balance = 0;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getAnnualInterest() {
		return annualInterest;
	}

	public void setAnnualInterest(double annualInterest) {
		this.annualInterest = annualInterest;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public BaseProduct(String account, double annualInterest, int period, long balance) {
		this.account = account;
		this.annualInterest = annualInterest;
		this.period = period;
		this.balance = balance;
	}

	public BaseProduct(BaseProduct original) {
		this.account = original.account;
		this.annualInterest = original.annualInterest;
		this.period = original.period;
		this.balance = original.balance;
	}

	@Override
	public String toString() {
		return "BaseProduct [account=" + account + ", annualInterest=" + annualInterest + ", period=" + period
				+ ", balance=" + balance + "]";
	}
}
