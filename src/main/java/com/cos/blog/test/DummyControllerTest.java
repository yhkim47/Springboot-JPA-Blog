package com.cos.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	@Autowired
	private UserRepository userRepository;
	
	// postman을 이용하여 http body에 x-www-form-urlencoded로 username, password, email을 요청한다.
	@PostMapping("/dummy/join")
	public String join(String username, String password, String email) {
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		System.out.println("email:" + email);
		return "회원 가입이 완료되었습니다.";
	}

	@PostMapping("/dummy/joinuser")
	public String join(User user) {
		System.out.println(user.toString());
		//
		user.setRole(RoleType.USER);
		userRepository.save(user);
		//
		return "회원 가입이 완료되었습니다.";
	}
}
