package org.zerock.myapp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.PersonDTO;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@NoArgsConstructor

@RequestMapping("/controller")

@Controller
public class ReturnTypesController {

	// ---------------------------------------------------//
	// 1. void return type (매개변수도 없는 경우)
	// ---------------------------------------------------//
	@GetMapping("/void")
	void returnVoid() {
		log.trace("returnVoid() invoked.");
	} // handler

	// ---------------------------------------------------//
	// 2. String return type (핸들러 선언의 정석)
	// ---------------------------------------------------//
	@GetMapping("/string")
	String returnString() {
		log.trace("returnString() invoked.");

		return "Yoon";
	} // returnString

	// ---------------------------------------------------//
	// 3. String return type (핸들러 선언의 정석)
	// with Spring command object(모든 전송파라미터를 자동수집한 DTO 객체
	// ---------------------------------------------------//
	@GetMapping(path = "/stringWithCommandObject", params = { "name", "age" })
	String returnStringWithCommandObject(PersonDTO dto) {
		log.trace("StringWithCommandObject({}) invoked.");

		return "stringWithCommandObject";
	} // returnString

	// ---------------------------------------------------//
	// 4. String return type (핸들러 선언의 정석)
	// with "redirect:" (리다이렉션을 수행하는 문자열 반환)
	// ---------------------------------------------------//
	@GetMapping("/stringForRedirection")
	String returnStringForRedirection() {
		log.trace("returnStringForRedirection() invoked.");

//		return "redirect:/controller/redirect";
		return "redirect:http://localhost:8080/controller/redirect";
	} // returnString

	@GetMapping("/redirect")
	String redirect() {
		log.trace("redirect() invoked.");

		return "redirect";
	} // redirect

	@PostMapping("/forward")
	String forward() {
		log.trace("forward() invoked.");

		return "forward";
	} // forward
		// ---------------------------------------------------//
		// 5. String return type (핸들러 선언의 정석)
		// with "forward:"
		// ---------------------------------------------------//

	@PostMapping("/stringForForward")
	String returnStringForForward() {
		log.trace("returnStringForForward() invoked.");

		return "forward:forward";
	} // returnstringForForward

	// ---------------------------------------------------//
	// 6. 
	// ---------------------------------------------------//
	@GetMapping("/returnJavaObject")
	@ResponseBody
	PersonDTO returnJavaObject() {
		log.trace("returnJavaObject() invoked.");

		PersonDTO dto = new PersonDTO();
		
		dto.setAge(23);
		dto.setName("Yoon");
		
		return dto;
	} // returnJavaObject
	
	@GetMapping("/returnResponseEnity")
	ResponseEntity<String> returnResponseEnity(){
		log.trace("returnResponseEnity() invoked.");
		
		String json = "{'name' : 'Yoon','age' : 23}";
		
		HttpHeaders headers = new HttpHeaders();
		
//		headers.add("새로운헤더명", "값");
		headers.add("Content-Type", "application/json; charset=utf8");
		
		
//		return new ResponseEntity<>(바디컨텐츠, 헤더, 응답코드);
		return new ResponseEntity<>(json, headers, HttpStatus.OK);
	} // returnResponseEnity

} // end class
