package com.example.ooadtest;
import org.junit.jupiter.api.Test;
//import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.User;
import com.example.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
	public void testCreateUser() {
		User user = new User();
		user.setusername("ravikumar@gmail.com");
		user.setpassword("ravi2020");
		
		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getid());
		
		assertThat(user.getusername()).isEqualTo(existUser.getusername());
		
	}
    
}
