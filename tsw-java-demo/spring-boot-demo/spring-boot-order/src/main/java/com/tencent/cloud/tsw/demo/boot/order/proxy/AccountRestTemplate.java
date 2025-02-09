package com.tencent.cloud.tsw.demo.boot.order.proxy;

import com.tencent.cloud.tsw.demo.boot.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author skyehtzhang
 * @date 2020/11/9
 */
@Component
public class AccountRestTemplate {

	@Autowired
	private RestTemplate restTemplate;

	public Boolean pay(Order order) {
		// 扣钱
		try {
			String s = NewHttpClient.doPost("http://127.0.0.1:19101/account/pay", order);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		//return restTemplate.postForObject("http://127.0.0.1:19101/account/pay", order,
				//Boolean.class);
	}

}
