package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	@GetMapping("/http/get")
	public String httpGet() {
		return "Http Get";
	}
	@PostMapping("/http/post")
	public String httpPost() {
		return "Http Post";
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
