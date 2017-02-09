import bank.Bank;
import bank.Credit;
import bank.Customer;
import bank.Deposit;

public class Demo {

	public static void main(String[] args) {

		/*
		 * Point 3.
		 */
		Deposit shortDeposit = new Deposit("Short Deposit", 3, 3, 0);
		Deposit longDeposit = new Deposit("Long Deposit", 5, 12, 0);

		/*
		 * Point 4.
		 */
		Credit homeCredit = new Credit("Home Credit", 6, 60, 0);
		Credit customerCredit = new Credit("Customer Credit", 10, 12, 0);

		/*
		 * Point 5.
		 */
		Bank bank = new Bank("UBB", "Sofia", 200_000);
		bank.addProduct(shortDeposit);
		bank.addProduct(longDeposit);
		bank.addProduct(homeCredit);
		bank.addProduct(customerCredit);

		/*
		 * Point 6.
		 */
		Customer clients[] = new Customer[10];
		for (int i = 0; i < clients.length; i++) {
			clients[i] = new Customer("Name " + (i + 1), "Address " + (i + 1), (int) (Math.random() * 10000),
					(int) (460 + Math.random() * 1000));
		}

		/*
		 * Point 7.
		 */
		for (Customer c : clients) {
			Deposit d = c.offer(80 + Math.random() * 20, bank.randomDeposit());
			d.update();
			bank.update(d);
			bank.payInterest();
		}

		/*
		 * Point 8.
		 */
		System.out.println(bank);

		/*
		 * Point 9.
		 */
		for (Customer c : clients) {
			Credit k = bank.randomCredit();
			k.setBalance((long) (Math.random() * 1000));
			k.update();

			k = bank.evaluate(c, k);
			if (k == null) {
				continue;
			}

			c.receive(k);
			bank.give(k);
		}

		/*
		 * Point 10.
		 */
		System.out.println(bank);
		for (Customer c : clients) {
			System.out.println(c);
		}
	}

}
