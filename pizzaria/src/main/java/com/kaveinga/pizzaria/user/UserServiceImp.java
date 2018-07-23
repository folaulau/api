package com.kaveinga.pizzaria.user;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	private User save(User user) throws RuntimeException{
		return userRepository.saveAndFlush(user);
	}
	
	private User patch(User user) throws RuntimeException{
		return userRepository.saveAndFlush(user);
	}
	
	private Boolean delete(Long id) throws RuntimeException{
		this.userRepository.delete(new User(id));
		return true;
	}

	@Override
	public User create(User user) {
		log.info("create(..)");
		return this.save(user);
	}

	@Override
	public User update(User user) {
		log.info("patch(..)");
		return this.patch(user);
	}

	@Override
	public User getById(Long id) {
		log.info("getById({})", id);
		Optional<User> optUser =  this.userRepository.findById(id);
		
		return optUser.orElseThrow(()-> new RuntimeException("User not found with id: "+id));
	}

	@Override
	public List<User> getAll() {
		log.info("getAll()");
		return this.userRepository.findAll();
	}

	@Override
	public User getByEmail(String email) {
		log.info("getByEmail()");
		Optional<User> optUser = this.userRepository.findByEmail(email);
		return optUser.orElseThrow(()-> new RuntimeException("User not found with email: "+email));
	}

	@Override
	public Boolean remove(Long id) {
		log.info("remove({})", id);
		return this.delete(id);
	}

	@Override
	public Boolean remove(User user) {
		log.info("remove({})", user);
		return this.remove(user.getId());
	}
}
