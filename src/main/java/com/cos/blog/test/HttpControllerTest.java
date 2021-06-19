package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	@GetMapping("/http/get1")
	public String httpGet1(@RequestParam int id, @RequestParam String username, @RequestParam int password, @RequestParam String email) {
		return "Http Get1, " + id + ",'" + username + ",'" + password + ",'" + email;
	}
	@GetMapping("/http/get")
	public String httpGet(Member m) {
		return "Http Get, " + m.getId() + ",'" + m.getUsername() + ",'" + m.getPassword() + ",'" + m.getEmail();
	}
	@PostMapping("/http/post")
	public String httpPost(@RequestBody Member m) {
		return "Http Post, " + m.getId() + ",'" + m.getUsername() + ",'" + m.getPassword() + ",'" + m.getEmail();
	}
	@PostMapping("/http/postText")
	public String httpPost(@RequestBody String text) {
		return "Http Post, " + text;
	}
	@PutMapping("/http/put")
	public String httpPut() {
		return "Http Put";
	}
	@DeleteMapping("/http/delete")
	public String httpDelete() {
		return "Http Delete";
	}
}
