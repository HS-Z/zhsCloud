package com.zhs.provider;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.zhs.common.ZhsCommonApplication;
import org.springframework.boot.SpringApplication;


@EnableDistributedTransaction   //tx-lcn
public class ZhsProviderApplication extends ZhsCommonApplication{

	public static void main(String[] args) {
		SpringApplication.run(ZhsProviderApplication.class, args);
	}
}
