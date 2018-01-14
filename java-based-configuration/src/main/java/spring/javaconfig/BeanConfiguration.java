package spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.bean.AccountDao;
import spring.bean.AccountDaoInMemoryImpl;
import spring.bean.AccountService;
import spring.bean.AccountServiceImpl;

@Configuration
public class BeanConfiguration {
	@Bean
	public AccountService accountService() {
		AccountServiceImpl bean = new AccountServiceImpl();
		bean.setAccountDao(accountDao());
		
		return bean;
	}
	
	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//dependency account dao can be injected here
		return bean;
	}
}
