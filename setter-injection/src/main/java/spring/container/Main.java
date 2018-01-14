package spring.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.AccountService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		AccountService accountService = context.getBean(AccountService.class);

		System.out.println("Before money transfer");
		System.out.println("Account 3 balance :" + accountService.getAccount(3).getBalance());
		System.out.println("Account 4 balance :" + accountService.getAccount(4).getBalance());

		accountService.transferMoney(3, 4, 5.0);

		System.out.println("After money transfer");
		System.out.println("Account 3 balance :" + accountService.getAccount(3).getBalance());
		System.out.println("Account 4 balance :" + accountService.getAccount(4).getBalance());

		((ConfigurableApplicationContext) (context)).close();
	}

}
