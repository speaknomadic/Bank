package bank;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name = "";
	private String address = "";
	private long money = 0;
	private long salary = 0;
	private List<Deposit> deposits = new ArrayList<Deposit>();
	private List<Credit> credits = new ArrayList<Credit>();

	public Customer(String name, String address, long money, long salary) {
		this.name = name;
		this.address = address;
		this.money = money;
		this.salary = salary;
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", money=" + money + ", salary=" + salary
				+ ", deposits=" + deposits + ", credits=" + credits + "]";
	}

	public Deposit offer(double percent, Deposit deposit) {
		deposit.setBalance((long) (money * percent / 100));
		money = (long) (money * percent / 100);
		deposits.add(deposit);

		return deposit;
	}

	public void receive(Credit k) {
		credits.add(k);
		money += k.getBalance();
	}

	public double totalPayments() {
		double total = 0;

		for(Credit k : credits) {
			total += k.getMonthlyFee();
		}
		
		return total;
	}

}
