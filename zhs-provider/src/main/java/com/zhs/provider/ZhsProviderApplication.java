package com.zhs.provider;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.zhs.common.ZhsCommonApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement    //开启本地事务
@EnableDistributedTransaction   //tx-lcn
public class ZhsProviderApplication extends ZhsCommonApplication{

	public static void main(String[] args) {
		SpringApplication.run(ZhsProviderApplication.class, args);
	}
}
