package com.codelib.springboot.springmvc.simple.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/helloworld")
	public String sayHelloWorld() {
		return "Hello World!";
	}
}
