package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		// 람다식
		User user = userRepository.findById(id).orElseThrow(() -> {
				return new IllegalArgumentException("해당 유저는 없습니다. id:" + id);
		});

		// 객체가 리턴되는 경우 MessageConverter가 Jackson을 이용하여 JSON을 변경하여 브라우저에 전달한다.
		// Content-Type : application/json
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	} 
	
	@GetMapping("/dummy/user")
	public Page<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pagarable) {
		Page<User> pagingUser = userRepository.findAll(pagarable);
		
		return pagingUser;
	}
	
	@Transactional // 함수종료시 자동 커밋된다.
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("수정 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		//userRepository.save(user);
		return user;
	}
	
	@DeleteMapping("/dummy/delete-user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch(Exception e) {
			return "삭제 실패 " + e.getMessage();
		}
		return "삭제 성공 id: " + id;
	}
}
