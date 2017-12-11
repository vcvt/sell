package com.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;
import java.util.TimeZone;

@SpringBootApplication
public class SellApplication {

	public static void main(String[] args) {
		/*TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
		TimeZone.setDefault(tz);*/
		SpringApplication.run(SellApplication.class, args);
	}
}
