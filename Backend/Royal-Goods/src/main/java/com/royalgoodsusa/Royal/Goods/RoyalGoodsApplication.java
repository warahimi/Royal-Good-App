package com.royalgoodsusa.Royal.Goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/*
	Royal Goods Application
 */
@SpringBootApplication
@EnableJpaAuditing // Enables JPA Auditing
public class RoyalGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoyalGoodsApplication.class, args);
	}

}
