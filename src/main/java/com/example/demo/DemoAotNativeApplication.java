package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration(proxyBeanMethods=false)
public class DemoAotNativeApplication {

	public static void main(String[] args) throws ClassNotFoundException {
//		System.out.println("HELLO " + Arrays.asList(DemoAotNativeApplication.class.getClassLoader().loadClass("com.example.demo.DemoAotNativeApplication$$SpringCGLIB$$0").getDeclaredMethods()));
		SpringApplication.run(DemoAotNativeApplication.class, args);
	}

}
