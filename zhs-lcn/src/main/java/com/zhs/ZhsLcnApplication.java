package com.zhs;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer
public class ZhsLcnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhsLcnApplication.class, args);
	}

}
