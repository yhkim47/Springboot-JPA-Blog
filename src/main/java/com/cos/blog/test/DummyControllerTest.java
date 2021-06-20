package com.cos.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// http://localhost:8000/blog/dummy/user/3
	// {id}는 3을 전달받는다.
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		// http://localhost:8000/blog/dummy/user/4를 찾으면 데이터베이스에서 null이 나오므로 문제가 됨
	
		//User user = userRepository.findById(id).get();
		
		/*
		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
			@Override
			public User get() {
				// TODO Auto-generated method stub
				return new User();
			}
		});
		*/
		
		/*
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id:" + id);
			}
		});
		*/
<<<<<<< HEAD
		
=======
		  
>>>>>>> master_14강
		// 람다식
		User user = userRepository.findById(id).orElseThrow(() -> {
				return new IllegalArgumentException("해당 유저는 없습니다. id:" + id);
		});

		// 객체가 리턴되는 경우 MessageConverter가 Jackson을 이용하여 JSON을 변경하여 브라우저에 전달한다.
		// Content-Type : application/json
		return user;
	}
}
