package org.zerock.myapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ServletComponentScan
@SpringBootApplication
public class StudyController2App {

	public static void main(String[] args) {
		SpringApplication.run(StudyController2App.class, args);
		log.trace("main({}) invoked.", Arrays.toString(args));
	} // main

} // end class
