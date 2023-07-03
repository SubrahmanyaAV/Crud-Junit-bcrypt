package com.cruds.junit.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cruds.entity.User;
import com.cruds.repo.UserRepository;

@SpringBootTest
class CrudJunitTestApplicationTests {

	@Autowired
	private UserRepository repo;

	@Test
	public void testCreateUser() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "secret";
		String encodedPassword = passwordEncoder.encode(password);
		User user = new User("Subrahmanya", "AV", "Subbu@gmail.com",encodedPassword);
		
		User u = repo.save(user);
		
		assertThat(u.getId()).isNotNull();
	}
	
	@Test
	public void listAll(){
		
		Iterable<User> list = repo.findAll();
		list.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void findById() {
		User user = repo.findById(1).get();
		System.out.println(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void updateUser() {
		User user = repo.findById(1).get();
		user.setFirstName("subbu");
		
		repo.save(user);
	}
	
	@Test
	public void deleteUser() {
		
		Integer userId = 1;
		repo.deleteById(userId);
		
	}
}
