package org.bees.box;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config/*/*.xml")
public class BoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxApplication.class, args);
		System.out.println("hello world?");
	}

}
