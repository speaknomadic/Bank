package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private String name = "";
	private String address = "";
	private List<BaseProduct> products = new ArrayList<BaseProduct>();
	private long money = 0;
	private long reserve = 0;
	private List<Deposit> deposits = new ArrayList<Deposit>();
	private List<Credit> credits = new ArrayList<Credit>();

	public Bank(String name, String address, long money) {
		this.name = name;
		this.address = address;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", address=" + address + ", money=" + money + ", reserve=" + reserve + "]";
	}

	public Deposit randomDeposit() {
		BaseProduct result = null;

		do {
			result = products.get((int) (Math.random() * products.size()));
		} while (result instanceof Deposit == false);

		result = new Deposit((Deposit) result);

		deposits.add((Deposit) result);

		return (Deposit) result;
	}

	public void addProduct(BaseProduct product) {
		products.add(product);
	}

	public void update(Deposit d) {
		money += d.getBalance();
		reserve += 0.9 * d.getBalance();
	}

	public Credit randomCredit() {
		BaseProduct result = null;

		do {
			result = products.get((int) (Math.random() * products.size()));
		} while (result instanceof Credit == false);

		return (Credit) result;
	}

	public void give(Credit k) {
		credits.add(k);
		money -= k.getBalance();
		reserve -= 0.9 * k.getBalance();
	}

	public Credit evaluate(Customer c, Credit k) {
		if (c.totalPayments() >= 0.5 * c.getSalary()) {
			return null;
		}

		if (k.getBalance() > reserve) {
			return null;
		}
		return k;
	}

	public void payInterest() {
		long sum = 0;
		for (int i = 0; i < deposits.size(); i++) {
			Deposit deposit = deposits.get(i);
			double interest = deposit.calculateInterest(deposit);
			sum += interest * deposit.getBalance();
			double sumFinal = deposits.get(i).getBalance() + sum;
			deposits.get(i).setBalance((long) sumFinal);
			money -= sumFinal;

		}

	}
}
