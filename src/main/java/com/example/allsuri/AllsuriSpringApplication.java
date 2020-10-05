package com.example.allsuri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@EnableAspectJAutoProxy annotation enables support for handling the components marked with @Aspect annotation. It is similar to tag in the xml configuration.
@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
public class AllsuriSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllsuriSpringApplication.class, args);
	}

}
