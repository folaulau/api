package com.kaveinga.pizzaria.loader;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaveinga.pizzaria.user.User;
import com.kaveinga.pizzaria.user.UserService;
import com.kaveinga.pizzaria.util.PasswordUtil;

@Component
public class UserLoader {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void init() {
		log.info("UserLoader - init()");
		add();
	}
	
	private void add() {
		User user = null;
		
		try {
			user = this.userService.getById(new Long(1));
		} catch (Exception e) {
			// TODO: handle exception
		}
		String password = "test12";
		String hashedPassword = PasswordUtil.hashPassword(password);
		//if(user==null) {
			for(int i=0;i<5;i++) {
				user = new User();
				user.setId(new Long(i+1));
				user.setActive(true);
				user.setEmail("folaukaveinga+"+RandomStringUtils.randomAlphabetic(20)+"@gmail.com");
				user.setName(RandomStringUtils.randomAlphabetic(15));
				user.setPhoneNumber(RandomUtils.nextLong(10000000, 999999999)+"");
				user.setUid(RandomStringUtils.randomAlphabetic(50));
				user.setPassword(hashedPassword);
				this.userService.create(user);
			}
		//}
	}
}
