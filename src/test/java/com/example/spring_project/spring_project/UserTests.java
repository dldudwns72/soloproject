package com.example.spring_project.spring_project;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_project.spring_project.model.UserModelTest;
import com.example.spring_project.spring_project.repository.UserRepositoryTest;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTests {

	// mock을 통한 현재 데이터베이스를 참조하지 않고 jpa 테스트를 해보기

	@Autowired
	private UserRepositoryTest userRepositorytest;

	@Test
	@DisplayName("테스트 실패 junit")
	public void testAddFail() {
		int sum = 40 + 15;
		// assertEquals는 두번째 파라미터의 값과 첫번째 파라미터의 값이 같아야지 테스트 통과
		// assertNotEquals는 값이 같지 않아야 테스트 통과
		Assertions.assertEquals(55, sum);
	}

	@Test
	@DisplayName("유저 정보 가져오기")
	void getUser() {
		List<UserModelTest> userModelTest = userRepositorytest.findAll();
		userModelTest.get(0).getName();
		// 첫번째 userModelTest의 이름이 "lee" 와 같으면 테스트 통과
		assertEquals("lee", userModelTest.get(0).getName());

		// userModelTest의 size가 2이면 통과
		assertEquals(2, userModelTest.size());
	}

	@Test
	void createUser() {
		UserModelTest userModelTest = new UserModelTest(3L, "DeleteUser", "54915786");
		userRepositorytest.save(userModelTest);
	}

	@Test
	void modifyUser() {
		Optional<UserModelTest> userModelTest = userRepositorytest.findById(1L);
		userModelTest.ifPresent(user -> {
			user.setName("kwak");
			user.setPhoneNumber("987654321");
			userRepositorytest.save(user);
		});
	}
	
	@Test
	void deleteUser() {
		userRepositorytest.deleteById(3L);
	}
	
}
